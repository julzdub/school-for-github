#include "linkedList.h"

LinkedList * linkedList() {
	
	LinkedList * myList = (LinkedList*)calloc(1,sizeof(LinkedList));
	
	return myList;
}

void addLast(LinkedList * theList, Node * nn) {
	Node * cur;
	if(theList->size != 0)	{
		cur = theList->head;
		while (cur->next != NULL) {
			cur = cur->next;
		}
		
		cur->next = nn;
	}
	else {
		theList->head = nn;
	}

	theList->size = theList->size+1;
	cur = NULL;
}
void addFirst(LinkedList * theList, Node * nn) {
	
	nn -> next = theList->head->next;
	theList -> head = nn;
	theList -> size = theList->size+1;
	
}

void removeLast(LinkedList * theList, void (*removeData)(void *)) {
	
	Node * cur = NULL;
	Node * ptr = NULL;

	cur = theList->head;
	while (cur->next != NULL) {
		ptr = cur;		
		cur = cur->next;
	}
	removeData(cur->data);
	ptr->next = NULL;
	cur = NULL;
	ptr = NULL;
}	

void removeItem(LinkedList * theList, Node * nn, void (*removeData)(void *), int (*compare)(const void *, const void *)) {
	
	Node * cur = theList->head;
	Node * ptr = NULL;
	while(compare(cur->data, nn->data) != 0) {
		ptr = cur;		
		cur = cur->next;
	}
	
	removeData(cur->data);
	ptr->next = cur->next;
	cur->next = NULL;
	cur = NULL;
	theList->size = theList->size-1;
	
}

void clearList(LinkedList * theList, void (*removeData)(void *)) {
	
	Node * cur;
	for(cur = theList->head; cur->next != NULL; cur = cur->next) {
		removeData(cur->data);
		theList->size = theList->size-1;
	}
	cur = NULL;
}

void printList(const LinkedList * theList, void (*convertData)(void *)) {
	Node * cur;
	for(cur = theList->head; cur->next != NULL; cur = cur->next) {
		convertData(cur->data);
	}
	cur = NULL;
}

LinkedList * cleanList(LinkedList * theList, void (*removeData)(void *)) {
	clearList(theList, removeData);
	free(theList);
	return NULL;
}

//end linkedList
