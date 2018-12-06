/*
--------------------------------------------------------------------------------------------------------------------------------------------------------------
Program Description : Programming second assigment , lottery game that contains 6 functions which deal with 6 different option 
each function fulfills a differents task. the user is asked to enter 6 numbers  then they  can chose to display their number,
sort their numbers, compare the numbers with the wining number to check if they ended up winning anything, checking the 
frequency of their numbers to see how many time a certain number/s came up, user also has the option to exit the program 
from the menu. The program also contains appropriate error checking like checking that the numbers entered by the user
are within the range of 1- 42 and than the user has entered a different set of numbers with no repeats of the same number.
Compiler used - Borland

Date : 06/03/2018

Author: Maciej Skrzypczynski (C17339163)
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
#include <stdio.h>
#include <stdlib.h>
#define SIZE 6
#define NUMBERS 42

//Prototype for Option 1 (Entering numbers )
void option1(int array[],int array2[]);
//Prototype for option 2 ( Displaying the numbers)
void option2(int array[]);
//Prototype for option 3 ( Sorting numbers)
void option3(int array[]);
// Prototype for option 4 (checking the numbers with the winning numbers)
void option4(int array[]);
// prototype for option 5 (checking number frequency )
void option5(int array2[]);
//prototype for option 6(exit program)
int  option6(int);

int main()
{
    int numbers[SIZE];
    int i;
    int n;
    int input;
    int counter[NUMBERS+1];
    int counter3;
    
    
    //counter3 is used to to see if the user has chosen option 1 before choosing option 2,3,4,5
    counter3 = 0;
    n = 0;
    
    // for loop to initialise all elements of the counter array to 0 for later use for option 5 and 1 
    for(i=0; i<NUMBERS+1; i++)
    {
        *(counter+ i)=0;
    }//end for    
    
    //beginning of the do while loop to print the menu and for the swtich statement
    do
    {
        //input is always kept at 10 to prevent any bugs when the user enters a character
        input = 10; 
        
        printf("\t\t Welcome to the lottery Game");
        
        //only show this when the program begins or the user has not entered into option 1
        if(counter3==0)
        {
            printf("\n you must select option 1 before selecting any other option");
        }//end if         
        
        printf("\n\t 1)  Enter 6 numbers");
        printf("\n\t 2)  Display The numbers ");
        printf("\n\t 3)  Sort your numbers");
        printf("\n\t 4)  Check your numbers for winnings ");
        printf("\n\t 5)  Check number frequency ");
        printf("\n\t 6)  Exit \n");
        
        scanf("%d",&input);
        flushall();
        
        system("CLS");
        
        //begining of the switch statement
        switch(input)
        {
            //when 1 entered the user acesses the first option by calling the function for it.
            case 1:
            {
                //function call for the  option1
                option1(numbers,counter);
                
                // counter incremented so they user can use option 2,3,4,5 after option 1 has been done at least once
                counter3++;
                break;
                
            }//end case 1
            
            //when 2 entered the user accesses the second option by calling the function for it 
            case 2:
            {
                // the function will only be called when the user has done the first option at least once
                if(counter3 >= 1)
                {    
                    //function call for option 2
                    option2(numbers);
                    break;
                    
                }//end if 
                
                // if the user didnt chose option 1 at least once and tried to go into option 2 display following message 
                else
                {
                    printf("\t You need to chose option 1 before acessing this option \n\n");
                    break;
                    
                }//end else               
            }//end case 2
            
            // when 3 entered the user acesses the 3rd option by calling the function for it 
            case 3:
            {
                if(counter3 >=1)      
                {    
                    //function call for option 3
                    option3(numbers);
                    break;
                    
                }//end if
                else
                {
                    printf("\t You need to chose option 1 before acessing this option \n\n");
                    break;
                    
                }//end else                
            } //end case 3   
           
            //when 5 entered user acesses the 5th option by calling the function for it 
            case 5:
            {
                if(counter3 >= 1)   
                {
                    //call for option 5
                    option5(counter);
                    break;
                    
                }//end if
                else
                {
                    printf("\t You need to chose option 1 before acessing this option \n\n");
                    break;
                    
                }//end else    
            }//ensd case 5
            
            //when 4 entered the user acceses the 4th option by calling the function for it 
            case 4:
            {
                if(counter3 >= 1) 
                {
                    //call for option 4
                    option4(numbers);
                    break;
                    
                }//end if 
                else
                {
                    printf("\t You need to chose option 1 before acessing this option \n\n");
                    break;
                    
                } //end else   
            }//end case 4    
            
            //when 6 entered the user acesses the 6th option by calling the function for it 
            case 6:
            {
                //call for option 6 which returns an integer
                n = option6(n);
                
            }//end case 6
            
            //default statement if the user enteres an option that not valid
            default:
            {
                printf("\t You input was invalid make sure your are choosing viable options\n\n");
                break;
                
            }//end default    
        }//end switch
    }//end do while
    while(n==0);
    
    return 0;    
} //end main   

//Function Option 1 which gets the users input for lotto numbers  with appropriate error checking 2 arrays where passed to it from the main 
//the numbers array and the counter array 
void option1(int lottonumbers[],int counter2[])
{ 
    int i;
    // n is used for extra error checking
    int n;
    int j;
    int x;
    
    //creating an array that stores all possible numbers that can be entered by the user that are valid to the rule (1-42 )    
    int numberss[NUMBERS] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42};
       
    n = 0;
        
    printf("You Chose Option 1");
    printf("\n Enter the 6 numbers \n All numbers must be different and within the range of 1- 42 \n");

    //for loop to make the user intilise the array with their input 
    for(i=0; i<SIZE; i++)
    {
        scanf("%d",& *(lottonumbers +i));
        flushall();
        
    }//end for    

    //for loop for error checking if numbers are different  and within range
    for(j=0; j<SIZE; j++)    
    {
        //for loop for error checking  if numbers are different and within range 
        for(i=0; i<SIZE; i++)
        {
            //if statement that checks if userinputed numbers are within range when i and j are both 5
            if( i== SIZE-1 && j == SIZE-1)
            {
                
                //while loop gives the user appropriate error message and tells to re enter valid numbers                
                while(*(lottonumbers + j) <= 0 || *(lottonumbers + j) > NUMBERS)
                {
                    printf(" \n You entered invalid numbers please try again \n ");
                    printf(" Remeber each number must be different and in the range of 1 - 42\n");
                    
                    //for loop for re initialising the array
                    for(i=0; i<SIZE; i++)
                    {
                        scanf("%d",& *(lottonumbers +i));
                        flushall();
                        
                    }//end for 
                    
                    //n is incremented telling the program that the user input had at least one mistake. 
                    n++;
                }//end while                
            }//end for
            
            //else statemnt that checks if all other elements of the array contain different numbers and are withing the range of 1 -42 
            else 
            {        
                //when i and j are equal increment i
                if(i==j)
                {
                    i++;
                }//end if
                
                //while loop displays an appropriate message if user entered same number more than once and asks to re enter valid numbers
                while(*(lottonumbers + j) == *(lottonumbers + i))
                {
                    printf(" \n You entered invalid numbers please try again \n ");
                    printf(" Remeber each number must be different and in the range of 1 - 42\n");
                    
                    //for loop to re-enter numbers into the array 
                    for(x=0; x<SIZE; x++)
                    {
                        scanf("%d",& *(lottonumbers +x));
                        flushall();
                    }//end for
                    
                    n++;
                }//end while
                
                //while loop display appropriate message if user entered numbers outside of the range and asks to re enter valid numbers
                while(*(lottonumbers +i) <=0 || *(lottonumbers + i) > NUMBERS)
                {
                    printf(" \n You entered invalid numbers please try again \n ");
                    printf(" Remeber each number must be different and in the range of 1 - 42\n");
                    
                    //for loop to re-enter numbers into the array
                    for(x=0; x<SIZE; x++)
                    {
                        scanf("%d",& *(lottonumbers +x));
                        flushall();
                    }//end for       
                    
                    n++;
                }//end while
            }//end else     
        }//end for
        
        // if statement that if any errors detected at all from the users input will reset the for loop to double check if the user input is 100 procent correct
        if(n > 0)
        {
            j = 0;
            n = 0;
            
        }//end if        
    }//end for       
    
    //nested for loops that will increment an element of the counter array depending on the users input to keep the frequency of the number entered (userinput= 1 contents of counter array[1] = ++)
    for(i=0; i<SIZE; i++)   
    {
        for(j=0; j<NUMBERS; j++)
        {
            if( *(lottonumbers + i)== *(numberss + j) )
            {
                    *(counter2 + j+1) = *(counter2 + j+1) + 1;  
            }//end if        
        }//end for
    }//end for
    
    system("CLS");
    
}//end option 1        
    
//Function option 2 which display user input for the lotto numbers. has the number array passed to it. 
void option2(int displaynumbers[])
{    
    int i;
    
    printf("You Chose option 2");
    printf("\n The numbers you have entered are \n");
    
    //for loop that displays the numbers to the user that he/she entered
    for(i=0; i<SIZE; i++)
    {
        printf("%d ", *(displaynumbers + i));    
    }//end for

    printf("\n Press Enter To continue ............");
    
    getchar();
    system("CLS");
    
}//end option 2 

/*the function option 3 has 1 array passed to it from the main that contains
the numbers the user has inputted and sorts them using bubble sort algorithm and prints the array out sorted*/
void option3(int sort[])
{
    int i,j;
    int temp;
    
    printf("You Chose option 3");
    printf("\n These are your numbers in acending order \n");
    
    //sorting the array with bubble sort algorithm
    for(i=0; i<SIZE-1; i++)
    {
        for(j=0; j<SIZE-i-1; j++)
        {
            if(*(sort + j) > *(sort + j+1))
            {
                temp = *(sort + j);
                *(sort + j) = *(sort + j+1);
                *(sort + j+1) = temp;
            }//end if    
        }//end for
    }//end for
    
    //for loop displays the array sorted
    for(i=0; i<SIZE; i++)
    {
        printf("%d ",*(sort + i));
    }//end for
    
    printf("\n Press Enter To continue..............\n");
    
    getchar();    
    system("CLS"); 
}//end option 3    

/*the  function option 5 has 1 array passed to it from the main which is called counter
which contains the frequency of the numbers being entered. the function displays the frequecny to the user*/
void option5(int counter[])
{
    int i;
      
    printf("You Chose option 5 : Number frequency \n\n ");    
   
    //for loop to dispaly the frequency of the numbers to the user that are stored in the array counter
    for(i=1; i<NUMBERS+1; i++) 
    {
        if(*(counter + i) > 0)
        {
            //if the number was entered only ones say time instead of times
            if(*(counter +i) ==1)
            {    
                printf("\n The Number %d came up %d time \n",i,*(counter +i));  
            }//end if        
            else
            {
                printf("\n The Number %d came up %d times \n",i,*(counter +i));
            }//end else        
        }//end if 
    }//end for
     
    printf("Press Enter to continue.......");
    
    getchar();
    system("CLS");
        
}//end option 5

//Function option 4 display to the user  if he has won any prices the function had the array containing user numbers passed to it
void option4(int userinput[])
{
    int winning[SIZE] = {1,3,5,7,9,11};
    int bonus_number;
    int counter;
    int bonus;
    int i;
    int j;
    
    bonus_number = 42;
    counter = 0;
    bonus = 0;
    
    printf("You chose option 4 : checking if any of your numbers match the winning numbers\n");    

    //array check if the userinput was equal to any wining number or a bonus number
    for(i=0; i<SIZE; i++)
    {
        for(j=0; j<SIZE; j++)
        {    
            if(*(userinput + i) == *(winning +j))
            {
                counter++;
            }//end if 
        }//end for    
        if(*(userinput +i) == bonus_number)
        {
            bonus++;
        }//end if
    }//end for
    
    // if 6 winning number match display following 
    if(counter==6)
    {
        printf("\n Match 6 = Jackpot \n");
    }//end if 
    
    // if 5 and bonus match display following 
    if(counter==5 && bonus==1)
    {
        printf("\n Match 5 + Bonus = New Car\n");
    }//end if 
    
    // if 5 match no bonus display following
    if(counter == 5 && bonus==0)
    {
        printf(" \n Match 5 = Holiday \n");
    }//end if     
    
    // if 4 match no bonus display following
    if(counter == 4 && bonus==0)
    {
        printf("\n Match 4 = Night Out \n");
    } //end if    
    
    //if 4 match with bonus display following
    if(counter == 4 && bonus==1)
    {
        printf("\n Match 4 + Bonus = Weekend Away \n");
    }//end if   
    
    //if 3 match with bonus display following
    if(counter == 3 && bonus==1)
    {
        printf("\n Match 3 + Bonus = Cinema Tickets \n");
    }//end if
    
    // ifl ess  than 0 or 1 or 2 match display following
    if(counter==1 || counter==2)
    {
        printf("\n Unfortunetally your numbers didnt match any prizes \n");
    }//end if
    
    // if 3 with no bonus match display following 
    if(counter==3 && bonus==0)
    {
        printf("\n Unfortunetally your numbers didnt match any prizes \n");
    }//end if

    printf("Press Enter to Continue.......");
    
    getchar();
    system("CLS");
    
}//end option 4    

/*function option 6 has the number n passed to it and it increments its and passes it back as
the function is use to exit the program so it goes outside the do while loop and it exists */
int option6(int n)
{
    n = n + 1;
    
    printf("\n You chose to exit the program GOODBYE");
    getchar();
    
    return n;
}//end option 6    

