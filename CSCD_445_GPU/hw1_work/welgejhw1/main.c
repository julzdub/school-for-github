#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "linkedList.h"
#include "listUtils.h"
#include "word.h"

int main( int argc, const char * argv[]) {

    if(argc < 2) {
        printf("not enough args.");
        return 0;
    }

    LinkedList * wordList = linkedList();

    const char * filename = argv[1];

    FILE * fin = fopen("/Users/julian/Desktop/CSCD_445_GPU/welgejhw1/testfile1", "r");

    if(fin == NULL) {
        printf("error file pointer null.\n");
        exit(101);
    }

    char file_contents [1024];

    while( fgets(file_contents, 1024, fin)) {
        printf("fun bun.\n");
        extractOneLine(file_contents, wordList, compareWords);

    }

    sort(wordList, compareWords);
    printList(wordList, printTypeWord);

    sort(wordList, compareWordCount);
    printList(wordList,printTypeWord);

    fclose(fin);

    return 0;
}
