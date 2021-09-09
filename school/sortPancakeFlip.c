#include<stdio.h>
#include<string.h>
#define MAX_CAKE 31
#define TOP 1

void solve(int arr[], int end);
int getMaxIdx(int arr[], int end);
void moveToEnd(int arr[], int toMoved, int end);
void flip(int arr[], int idx);
int isSorted(int arr[], int size);

int size = 1;

int main() {
	char line[100];
	int stack[MAX_CAKE] = { 0, };
	
	/*input*/
	gets_s(line, 100);
	for (int s = strtok(line, " "); s; s = strtok(NULL, " "), size++)
		if (sscanf(s, "%d", &stack[size]) < 1) break;

	/*print*/
	
	//echo
	for (int i = 1; i < size; i++) printf("%d ", stack[i]);
	printf("\n----------------\n");
	
	solve(stack, size - 1);
	
	//sorted
	printf("----------------\n");
	for (int i = 1; i < size; i++) printf("%d ", stack[i]);
	
}

void solve(int arr[], int end) {
	if (isSorted(arr, end) || end <= TOP) {
		printf("0\n");
		return;
	}

	moveToEnd(arr, getMaxIdx(arr, end), end);
	solve(arr, end - 1);
}

int getMaxIdx(int arr[], int end) {
	int max = arr[TOP];
	int maxIdx = TOP;
	for (int i = TOP+1; i <= end; i++) {
		if (max < arr[i]) {
			max = arr[i];
			maxIdx = i;
		}
	}
	return maxIdx;
}

void moveToEnd(int arr[], int toMoved, int end) {
	if (toMoved == TOP) flip(arr, end);
	else {
		flip(arr, toMoved);
		flip(arr, end);
	}
}

void flip(int arr[], int idx) {
	printf("%d ", size - idx);

	int tmp[MAX_CAKE];
	int end = idx;

	for (int i = TOP; i <= idx; i++) {
		tmp[i] = arr[end--];
	}

	for (int i = TOP; i <= idx; i++) {
		arr[i] = tmp[i];
	}
}

int isSorted(int arr[], int size) {
	for (int i = TOP; i < size; i++) 
		if (arr[i] > arr[i + 1]) return 0;
	return 1;
}