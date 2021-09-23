#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX_X 10000
#define MAX_Y 100

int getNumOfDistinct(char* to, char* from);

int main() {
    /*by scan*/
    int testcase;
    scanf("%d", &testcase);

    for (int tc = 0; tc < testcase; tc++) {
        char from[MAX_X];
        char to[MAX_Y];

        scanf("%s", from);
        scanf("%s", to);

        printf("%d\n", getNumOfDistinct(to, from));
    }

    /*by file reading
    FILE* fp = fopen("test.txt", "r");
    if (fp == NULL) {
        printf("ERR_FILE_OPEN\n");
        return 0;
    }
    int testcase;
    fscanf(fp, "%d", &testcase);
    for (int tc = 0; tc < testcase; tc++) {
        char from[MAX_X];
        char to[MAX_Y];

        fscanf(fp, "%s", from);
        fscanf(fp, "%s", to);

        printf("%d\n", getNumOfDistinct(to, from));
    }
    */
    
    return 0;
}

int getNumOfDistinct(char* to, char* from) {
    int len1 = strlen(to);
    int len2 = strlen(from);

    /*table initialize*/
    int** table = malloc(sizeof(int*) * (len1 + 1));    //len + 1 for outline
    for (int i = 0; i <= len1; i++) table[i] = malloc(sizeof(int) * (len2 + 1));

    /*table's outline*/
    for (int j = 0; j <= len1; j++) table[j][0] = 0;
    for (int i = 0; i <= len2; i++) table[0][i] = 1;
    
    /*compute*/
    for (int i = 1; i <= len1; i++) {
        for (int j = 1; j <= len2; j++) {
            table[i][j] = table[i][j - 1];
            if (to[i - 1] == from[j - 1]) table[i][j] += table[i - 1][j - 1];
        }
    }
    return table[len1][len2];
}