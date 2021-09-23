#include<stdio.h>
#include<stdlib.h>

typedef struct _Path {
	int y;
	int prevY;
	int cost;
}Path;

Path initPath(int y, int prevY, int cost);
Path getMinCostPath(int** costs, int height, int width, Path** paths);
Path getMinCostAdj(Path** paths, int x, int y, int height, int curCost);
Path getMinCostRow(int** costs, Path** paths, int colNum, int height);
void printPath(int** costs, int start, Path** paths, int width);
void savePath(int** costs, int start, Path** paths, int width, int* dest);

int main() {
	int height, width;
	int** costs;
	
	FILE* fp = fopen("test.txt", "r");
	if (fp == NULL) {
		printf("ERR_FILE_OPEN\n");
		return 0;
	}
	
	while (!feof(fp)) {
		/*Insert*/
		fscanf(fp, "%d %d", &height, &width);
		costs = malloc(sizeof(int*) * height);
		
		//initialize costs array
		for (int h = 0; h < height; h++)
			costs[h] = malloc(sizeof(int) * width);
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				fscanf(fp, "%d", &costs[h][w]);
			}
		}
		
		//initialize paths array
		Path** paths = malloc(sizeof(Path*) * height);
		for (int i = 0; i < height; i++)
			paths[i] = malloc(sizeof(Path) * width);

		/*Get cheapest path*/
		Path cheapest = getMinCostPath(costs, height, width, paths);

		/*Print*/
		printPath(costs, cheapest.y, paths, width);
		printf("\n%d\n", cheapest.cost);
	}
	
	return 0;
}

Path initPath(int y, int prevY, int cost) {
	Path p = { y, prevY, cost};
	return p;
}
Path getMinCostPath(int** costs, int height, int width, Path** paths) {
	
	//paths's first column init
	for (int h = 0; h < height; h++) 
		paths[h][0] = initPath(h, -1, costs[h][0]);

	//construct dp table with values which was saved in previous column
	for (int w = 1; w < width; w++) {
		for (int h = 0; h < height; h++) {
			Path minAdj = getMinCostAdj(paths, w, h, height-1, costs[h][w]);
			int from = minAdj.y;
			int cost = minAdj.cost + costs[h][w];
			paths[h][w] = initPath(h, from, cost);
		}	
	}

	//get cheapest path in last column
	return getMinCostRow(costs ,paths, width - 1, height);
}
Path getMinCostAdj(Path** paths, int w, int h, int maxH, int curCost) {
	int adjs[3];
	int minCost = paths[h][w - 1].cost + curCost;
	int minIdx = h;

	//consider cylinder
	adjs[0] = (h != 0) ? h - 1 : maxH;
	adjs[1] = h;
	adjs[2] = (h != maxH) ? h + 1 : 0;
	
	for (int i = 0; i < 3; i++) {
		int idx = adjs[i];
		int cost = paths[idx][w - 1].cost + curCost;
		if (minCost > cost) {
			minCost = cost;
			minIdx = idx;
		}
	}

	return paths[minIdx][w-1];
}
Path getMinCostRow(int** costs, Path** paths, int col, int height) {
	int minCost = paths[0][col].cost;
	int minIdx[10] = { 0, };
	int minCnt = 0;

	for (int i = 1; i < height; i++) {
		int cost = paths[i][col].cost;
		if (cost < minCost) {
			minCnt = 0;
			minCost = cost;
			minIdx[minCnt++] = i;
		}
		else if(cost == minCost) minIdx[minCnt++] = i;
	}

	//lexicographically order
	if (minCnt != 1) {
		int** tmps = malloc(sizeof(int*) * height);
		for (int i = 0; i < height; i++) tmps[i] = malloc(sizeof(int) * (col+1));
		for (int i = 0; i < minCnt; i++) {
			savePath(costs, minIdx[i], paths, col+1, tmps[i]);
		}
		for (int i = 1; i < minCnt; i++) {
			for (int j = 0; j > col + 1; j++) {
				if (tmps[i - 1][j] < tmps[i][j]) {
					minIdx[0] = minIdx[i];
					break;
				}
				else if (tmps[i - 1][j] < tmps[i][j]) break;
			}
		}
	}

	return paths[minIdx[0]][col];
}
void savePath(int** costs, int start, Path** paths, int width, int* dest) {
	if (start == -1) return;

	Path tmp = paths[start][width - 1];
	savePath(costs, tmp.prevY, paths, width - 1, dest);
	dest[width - 1] = costs[tmp.y][width - 1];
}
void printPath(int** costs, int start, Path** paths, int width) {
	if (start == -1) return;

	Path tmp = paths[start][width-1];
	printPath(costs, tmp.prevY, paths, width-1);
	printf("%d ", costs[tmp.y][width-1]);
}
