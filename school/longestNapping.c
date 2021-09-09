#include<stdio.h>
#include<stdlib.h>

typedef struct _Class {
	int startH;
	int startM;
	int endH;
	int endM;
}Class;

void sortClass(Class* classes, int start, int end);
int getFirstClassIdx(Class* classes, int start, int end);
void swap(Class* classes, int x, int y);

int main() {
	int testCase;
	scanf("%d", &testCase);
	
	for (int tc = 0; tc < testCase; tc++) {
		int num;
		int max = 0, napStart = 0;
		Class* classes;

		scanf("%d", &num);
		classes = malloc(sizeof(Class)*num);

		for (int i = 0; i < num; i++) {
			Class myClass;
			scanf("%d%*c%d %d%*c%d %*s", &myClass.startH, &myClass.startM, &myClass.endH, &myClass.endM);
			classes[i] = myClass;
		}

		sortClass(classes, 0, num - 1);

		for (int i = 0; i < num - 1; i++) {
			int tmp = classes[i].endH * 60 + classes[i].endM;
			if (max < tmp) {
				max = tmp;
				napStart = i;
			}
		}

		int duringH = classes[napStart + 1].startH - classes[napStart].endH;
		int duringM = classes[napStart + 1].startM - classes[napStart].endM;

		printf("Day #%d: the longest nap starts at %02d:%02d and will last for %d hours and %02d minutes",
			testCase, classes[napStart].startH, classes[napStart].startM, duringH, duringM);
	}
	
}
void sortClass(Class* classes, int start, int end) {
	if (start >= end) return;

	int first = getFirstClassIdx(classes, start, end);
	swap(classes, first, start);

	sortClass(classes, start + 1, end);
}

int getFirstClassIdx(Class* classes, int start, int end) {
	int first = classes[start].startH * 60 + classes[start].startM;
	int result = start;
	for (int i = start; i <= end; i++) {
		int tmp = classes[i].startH * 60 + classes[i].startM;
		if (tmp < first) {
			first = tmp;
			result = i;
		}
	}
	return result;
}

void swap(Class* classes, int x, int y) {
	Class tmp = classes[x];
	classes[x] = classes[y];
	classes[y] = tmp;
}