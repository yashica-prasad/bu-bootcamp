#include <stdio.h>

void swap(int *a, int *b){
    int temp = *b;
    *b = *a;
    *a = temp;
}

/*
    broken_swap fails because it takes in copies of the values of a and b instead of memory addresses
*/
void broken_swap(int a, int b){
    int temp = b;
    b = a;
    a = temp;
}

int main() {
    int a = 10;
    int b = 2;
    printf("a before swap: %d\n", a);
    printf("b before swap: %d\n", b);
    swap(&a, &b);
    printf("a after swap: %d\n", a);
    printf("b after swap: %d\n", b);
    broken_swap(a, b);
    printf("a after broken_swap: %d\n", a);
    printf("b after broken_swap: %d\n", b);
}

