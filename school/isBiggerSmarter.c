#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 1000

typedef struct _Elephant {
	int weight;
	int iq;
	int idx;
}Elephant;

void sortByWeight(Elephant* e, int len);
int getMaxIdx(Elephant* e, int len);
void swap(Elephant* e, int x, int y);

int getLDS(Elephant* e, int len, int* edgeTo);
void printLDS(Elephant* e, int* edgeTo, int start);

int main() {
	Elephant arr[MAX];
	int size = 0;
	
	/*insert*/
	FILE* fp = fopen("test.txt", "r");
	if (fp == NULL) {
		printf("ERR_FILE_OPEN\n");
		return 1;
	}
	while (!feof(fp)) {
		fscanf(fp, "%d %d", &arr[size].weight, &arr[size].iq);
		arr[size].idx = size + 1;
		size++;
	}

	/*sort by weight [selection sort]*/
	sortByWeight(arr, size);

	/*get longest decrease(IQ) sequence [DP]*/
	int* edgeTo = malloc(sizeof(int) * size);
	int start = 0;
	int max = getLDS(arr, size, edgeTo, &start);

	/*print*/
	printf("%d\n", max);
	printLDS(arr, edgeTo, start);

	return 0;	
}

void sortByWeight(Elephant* e, int len) {
	if (len <= 0) return;
	swap(e, len - 1, getMaxIdx(e, len));
	sortByWeight(e, len - 1);
}
int getMaxIdx(Elephant* e, int len) {
	int max = e[0].weight;
	int maxIdx = 0;
	for (int i = 1; i < len; i++) {
		if (max < e[i].weight) {
			max = e[i].weight;
			maxIdx = i;
		}
	}
	return maxIdx;
}
void swap(Elephant* e, int x, int y) {
	Elephant tmp = e[x];
	e[x] = e[y];
	e[y] = tmp;
}
int getLDS(Elephant* e, int size, int* edgeTo, int* start) {
	int* length = malloc(sizeof(int) * size);
	int max = 1;
	
	for (int i = 0; i < size; i++) {
		edgeTo[i] = i;
		length[i] = 1;
		for (int j = 0; j < i; j++) {
			if (e[i].weight != e[j].weight &&
				e[i].iq < e[j].iq && length[j] + 1 > length[i]) {

				length[i] = length[j] + 1;
				edgeTo[i] = j;
			}
		}
		if (length[i] > max) {
			max = length[i];
			*start = i;
		}
	}
	return max;
}
void printLDS(Elephant* e, int* edgeTo, int start) {
	if (start == edgeTo[start]) {
		printf("%d\n", e[start].idx);
		return;
	}
	printLDS(e, edgeTo, edgeTo[start]);
	printf("%d\n", e[start].idx);
}
