/**
*@todo save path only instead of saving each sequence
@2021 09 09
*/


#include<stdio.h>
#include<stdlib.h>
#define MAX 1000

typedef struct _Elephant {
	int weight;
	int iq;
	int idx;
}Elephant;
typedef struct _Sequence {
	int *seq;
	int len;
}Sequence;

Sequence* initSeqArr(int size);
int* copyArr(int* src, int size);

void sortByWeight(Elephant* e, int len);
int getMaxIdx(Elephant* e, int len);
void swap(Elephant* e, int x, int y);

Sequence getLDS(Elephant* e, int len);

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
	Sequence max = getLDS(arr, size);

	/*print*/
	printf("%d\n", max.len);
	for (int i = 0; i < max.len; i++) printf("%d\n", max.seq[i]);

	return 0;	
}

Sequence* initSeqArr(int size) {
	Sequence* s = malloc(sizeof(Sequence) * size);
	for (int i = 0; i < size; i++) {
		s[i].seq = malloc(sizeof(int) * 1);
		s[i].len = 1;
	}
	return s;
}
int* copyArr(int* src, int size) {
	int* des = malloc(sizeof(int) * size);
	for (int i = 0; i < size; i++) des[i] = src[i];
	return des;
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
Sequence getLDS(Elephant* e, int size) {
	Sequence* length = initSeqArr(size); //init all length to 1
	Sequence lds = length[0];
	for (int i = 0; i < size; i++) {
		length[i].seq[0] = e[i].idx;	//init sequence with each index
		for (int j = 0; j < i; j++) {
			if (e[i].weight != e[j].weight && 
				e[i].iq < e[j].iq && length[j].len + 1 > length[i].len) {
				
				length[i].len = length[j].len + 1;
				length[i].seq = copyArr(length[j].seq, length[i].len);
				length[i].seq[length[i].len - 1] = e[i].idx;	//add each index for sequence's last
			}
		}
		if (length[i].len > lds.len) lds = length[i];
	}
	return lds;
}
