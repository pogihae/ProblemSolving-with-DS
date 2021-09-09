#include<stdio.h>
#include<stdlib.h>

int getAvr(int arr[], int size);
int getNumOfDigit(int avr);

void sort(int arr[], int size);
int getMaxIdx(int arr[], int size);
void swap(int arr[], int x, int y);

int main() {
	int total, firstAvrNum;
	int* cost;
	int avr[2];
	int answer = 0;

	while (1) {
		/*input*/
		scanf("%d", &total);
		if (total == 0) return 0;
		firstAvrNum = total;

		cost = malloc(sizeof(int) * total);
		for (int i = 0; i < total; i++) {
			scanf("%d", &cost[i]);
		}

		/*average*/
		avr[0] = getAvr(cost, total);
		avr[1] = avr[0];
		
		int digitNum = getNumOfDigit(avr[0]);
		if (digitNum > 0) {
			avr[1] = avr[0] + 10;
			avr[0] -= digitNum;
			firstAvrNum = total - (digitNum * total / 10);
			//sort
			sort(cost, total);
		}

		/*calc*/
		for (int i = 0; i < firstAvrNum; i++) {
			if (avr[0] > cost[i]) answer += avr[0] - cost[i];
		}
		for (int i = firstAvrNum; i < total; i++) {
			if (avr[1] > cost[i]) answer += avr[1] - cost[i];
		}

		printf("$%d\n", answer);
	}
	return 0;
}

int getAvr(int arr[], int size) {
	int temp = 0;
	for (int i = 0; i < size; i++) temp += arr[i];
	return temp / size;
}
int getNumOfDigit(int avr) {
	return avr % 10;
}

void sort(int arr[], int size) {
	if (size <= 0) return;
	swap(arr, size - 1, getMaxIdx(arr, size));
	sort(arr, size - 1);
}
int getMaxIdx(int arr[], int size) {
	int max = arr[0];
	int maxIdx = 0;
	for (int i = 1; i < size; i++) {
		if (max < arr[i]) {
			max = arr[i];
			maxIdx = i;
		}
	}
	return maxIdx;
}
void swap(int arr[], int x, int y) {
	int temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
}