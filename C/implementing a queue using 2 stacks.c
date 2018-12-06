/* Program to implement a queue using two stacks */
#include<stdio.h>
#include<stdlib.h>
 
/* structure of a stack node */
struct sNode
{
    int data;
    struct sNode *next;
};
 
/* structure of queue having two stacks */
struct queue
{
    struct sNode *stack1;
    struct sNode *stack2;
};
//function prototypes 
void enQueue(struct queue *q, int x);
int pop(struct sNode** top_ref);
int deQueue(struct queue *q);
void push(struct sNode** top_ref, int new_data); 
 
/* Driver function to test anove functions */
int main()
{

    
    struct queue *q = (struct queue*)malloc(sizeof(struct queue));
    q->stack1 = NULL;
    q->stack2 = NULL;
    
    printf("Numbers 1 2 3 and 4 are in the queue waiting \n ");

    
   //Queueing items
    enQueue(q, 1);
    enQueue(q, 2);
    enQueue(q, 3);
    enQueue(q, 4);


    
    /* Dequeue items */   
    printf("Dequeue of the numbers is \n ");
    printf("%d\n", deQueue(q));
    printf("%d\n", deQueue(q));
    printf("%d\n", deQueue(q));
    printf("%d\n", deQueue(q));

    
 
    getchar();
}
/* Function to enqueue an item to queue */
void enQueue(struct queue *q, int x)
{
    push(&q->stack1, x);
} 
/* Function to dequeue an item from queue */
int deQueue(struct queue *q)
{
    int x;
    /* If both stacks are empty then error */
    if(q->stack1 == NULL && q->stack2 == NULL)
    {
        printf("Q is empty");
        getchar();
        exit(0);
    } 
/* Move elements from satck1 to stack 2 only if
stack2 is empty */
    if(q->stack2 == NULL)
    {
        while(q->stack1 != NULL)
        {
            x = pop(&q->stack1);
            push(&q->stack2, x);
         
        }
    }
 
    x = pop(&q->stack2);
    return x;
}

/* Function to push an item to stack*/
void push(struct sNode** top_ref, int new_data)
{
    /* allocate node */
    struct sNode* new_node =
        (struct sNode*) malloc(sizeof(struct sNode));
        if(new_node == NULL)
        {
            printf("Stack overflow \n");
            getchar();
            exit(0);
             
        }
 
/* put in the data */
    new_node->data = new_data;
 
/* link the old list off the new node */
    new_node->next = (*top_ref);
 
/* move the head to point to the new node */
    (*top_ref) = new_node;
}
 
/* Function to pop an item from stack*/
int pop(struct sNode** top_ref)
{
    int res;
    struct sNode *top;
     
    /*If stack is empty then error */
    if(*top_ref == NULL)
    {
        printf("Stack overflow \n");
        getchar();
        exit(0);
         
    }
    else
    {
        top = *top_ref;
        res = top->data;
        *top_ref = top->next;
        free(top);
        return res;
         
    }
}