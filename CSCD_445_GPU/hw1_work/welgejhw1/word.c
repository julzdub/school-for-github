#include "word.h"



/**
 * @brief Prints the specific word.
 *
 * Format is word - length
 *
 * @param passedIn - The void * passed in representing a specific word
 *
 * 
 */
void printTypeWord(void * passedIn)
{
	Word * temp = (Word *)passedIn;
   	printf("%s - %d\n", temp->ltrs, temp->occurances);

}// end printType

//will return a word pointer
Word * buildWord(char * aWord, int length) {
	Word * newWord = (Word *)calloc(1, sizeof(Word));
	newWord->ltrs = (char *)calloc(length + 1, sizeof(char));
	strcpy(newWord->ltrs, aWord);
	return newWord;
}

LinkedList * extractOneLine(char* aLine, LinkedList * masterList, int (*compare)(const void *, const void *)) {

	int inWord = 0;

	int i = 0; //means starting from the first index of 0, the first char in sentence.
	int wordLen = 0; //length of word.
	int start;
	while(aLine[i] != '\n' && aLine[i] != '\0') {
		if(isalpha(aLine[i]) != 0) {
			if (inWord == 0) {
				start = i; //we reach the start of a new word, then save i into variable start.
				inWord = 1;
			}//end if
			wordLen++;
		}//end if

		else if(inWord == 1) { //means current char is not alphabetical letter (delimiter).
			char temp[52];
			char * nextWordSrc = aLine + ((char)start);
			strncpy(temp, nextWordSrc, wordLen);
			Word * newWord = buildWord(temp, wordLen);

			if(newWord->len > 0 || newWord->ltrs[0] == 'a'|| newWord->ltrs[0] == 'A' || newWord->ltrs[0] == 'I') {
				if(isInList(masterList, compare, newWord) == 0) { //item is new to the list
					newWord->occurances = 1;
					addLast(masterList, buildNode(newWord));
				}

				else {
					Word * existingWordItem = returnItem(masterList, compare, newWord);
					existingWordItem->occurances = existingWordItem->occurances + 1;
				}
			} 
			wordLen = 0;
			inWord = 0;
		}

		i++;

	}//end while

	return masterList;
}

/**
 * @brief Compares two objects of type word.
 *
 * Words are compared based on the letters (word)
 *
 * @note The passed in items will need to be cast to the appropriate word type.
 *
 * @param p1 - The void * representing an object of type word
 * @param p2 - The void * representing an object of type word
 * @return int - Representing order < 0 indicates p1 is less than p2,
 * > 0 indicates p1 is greater than p2 and == 0 indicates p1 == p2 for contents
 *
 * @warning - The passed in void * p1 is checked - exit(-99) if NULL
 * @warning - The passed in void * p2 is checked - exit(-99) if NULL
 */
int compareWords(const void * p1, const void * p2)
{
   int res;
   Word *left = (Word *)p1;
   Word *right = (Word *)p2;
      
   return strcmp(left->ltrs, right->ltrs);
}// end compare

int compareWordCount(const void * p1, const void * p2) {
	int res;
	Word *left = (Word*)p1;
	Word *right =(Word*)p2;

	return left->occurances - right->occurances;
}



