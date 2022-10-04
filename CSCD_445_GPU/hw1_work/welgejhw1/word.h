#ifndef WORD_H_
#define WORD_H_

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "linkedList.h"
#include "listUtils.h"

struct word
{
   char * ltrs;
   int len;
   int occurances;
};

typedef struct word Word;

Word * buildWord(char * aWord, int length);

LinkedList * extractOneLine(char * aLine, LinkedList * masterList, int (*compare)(const void *, const void *));

int compareWordCount(const void * p1, const void * p2);

int compareWords(const void * p1, const void * p2);

void printTypeWord(void * passedIn);

#endif