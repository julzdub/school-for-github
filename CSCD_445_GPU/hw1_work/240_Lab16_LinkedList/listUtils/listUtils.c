#include "listUtils.h"
#include "../linkedList/linkedList.h"

Node * buildNode(FILE * in, void *(*buildData)(FILE * in) ) {
	
	Node * nn = (Node *)calloc(1,sizeof(Node));
	nn->data = buildData(in);
	nn->next = NULL;
	return nn;
	
}

void sort(LinkedList * theList, int (*compare)(const void *, const void *)) {
	
	Node * start = NULL;
	Node * search = NULL;
	Node * min = NULL;
	
	void * temp;
	
	for(start = theList->head; start->next != NULL; start = start->next) {
		min = start;
		for(search = start->next; search != NULL; search = search->next) {
			if(compare(search->data, min->data) < 0) {
				min = search;
			}
		}
		
		temp = min->data;
		min->data = start->data;
		start->data = temp;
	}
	
	start = NULL;
	search = NULL;
	min = NULL;
	temp = NULL;
}

void buildList(LinkedList * myList, FILE * fin, int total, void * (*buildData)(FILE * in)) {

	int x;
	for(x=0;x<total;x++) {
		Node * nn = buildNode(fin, buildData);
		addLast(myList, nn);
	}

}
