/* 
------------------------------------------------------------------------------------------------------------
Program Description : A program that will simulate a mathematical quiz game . the game will
include various features like Entering the amount of question asked for the round
display of the number of questions that were answered correctly and incorrectly and give
the ability for the user to exit the program.
------------------------------------------------------------------------------------------------------------
Author: Maciej Skrzypczynski 
------------------------------------------------------------------------------------------------------------
Date : Started = 26/10/2017
 ------------------------------------------------------------------------------------------------------------
*/
#include <stdio.h>
#include <conio.h>//Added for the Command clrscr(); to be used
#define SIZE 5 //Define the Size For The Arrays

int main()
{
    int i;
    int correct;
    int incorrect;
    int select;
    int NumberOfQuestions;
    int questions[SIZE]={2,14,23,34,534};
    int Answer[SIZE];
    int useranswer;
    int n;
    int counter;
    int QuestionNumber;
        
    correct = 0;
    incorrect = 0;
    select = 0;
    NumberOfQuestions = 0;
    useranswer = 0;
    n = 0; 
    counter = 0;
    QuestionNumber = 1;
    
    do
    {
        printf("        WELCOME TO THE MATHEMATICAL QUIZ GAME      \n");
        printf("Press 1) To Select The Number Of Questions for this round \n");
        
        if(NumberOfQuestions>0)//Show How many questions a user decided to answer in this round in the main menu
        {
            printf("You Decided To Answer %d Questions This Round \n",NumberOfQuestions);
        }//end 1st if
        
        printf("Press 2) To Start The Quiz \n");
        
        if(counter>0)//Display The 3rd Option only after the Quiz was played once 
        {
            printf("Press 3) To check your score of correct and incorrect answers \n");
        }//end 2nd if 
        
        printf("Press 0) To Quit The Quiz  \n");
        
        select=4;/* this is due to the scanf only accepting numbers so when ever a character is put in it just reads the last input that was entered
               before hand so when a character was entered it would not display and error but it would just re-enter the input from last round ie 
               when 1 is entered and than the user tries to enter a character select will still remain 1 so it will go into the 1st option 
               therefore select is initialised at 4 so the program will display an  error at all times until a correct input is entered.
                So overall this is put to prevent characters from bugging the quiz  */
        
        
        scanf("%d",&select);
        flushall();
        
        clrscr(); //clear the menu of the screen once an option was selected    
        
        switch(select)//begin switch statement
        {
            case 1: //When 1 in putted Start  Option 1   
            {   
                
                printf("Remember the Amount of Question cannot be lower than 1 and higher than 5 Now \n");
                printf("Please Enter The Amount of Question You would Like for this round \n\n ");
               
                NumberOfQuestions=9;// this is due to the same reasons as why select was initialised to 4 before .To prevent characters from bugging the quiz.
                
                scanf("%d",&NumberOfQuestions);
                flushall();
               
                while(NumberOfQuestions<=0 || NumberOfQuestions>=6) // When the user input is not more than 0 and less than 6 questions display an error and ask to re input a value until a right one is entered  
                {
                    printf(" You Enter The Wrong Amount of Questions, try again \n");
                    
                    scanf("%d",&NumberOfQuestions);
                    flushall();
                }//end while in case 1
                clrscr();//clear the screen   
                
                break;
            }//end Case 1:
            
            case 2://When 2 in-putted Start option 2
            { 
                correct = 0;
                incorrect =0;
                
                if(NumberOfQuestions==0)//display this error when the user didn't specify the amount of questions he or she wants to be asked 
                {
                    printf("You didn't Enter The Amount of Questions you wish to be asked\n");
                    printf("You will now be brought back to the main menu,please specify the amount of questions you want to be asked\n"); 
                    printf("Enter any key to continue ....");
                    
                    getchar();
                    clrscr();
                    
                    break;
                }//end if         
            
                printf("You have chosen to Start the game \n");
                printf("Please Answer the following questions \n");
                
                for(i=0; i<NumberOfQuestions; i++)//  Generate the amount of questions user asked to be asked
                {
                    printf("\n Question Number %d \n",QuestionNumber);
                   
                    Answer[i]=questions[i]+questions[i]; //add numbers  in the question array and store it in the  Answer array 
                    // the for loop controls which place the numbers are being picked from the question array and in which position they are stored in the Answer array
                   
                    printf(" %d + %d = ",questions[i],questions[i]);
                   
                    scanf("%d",&useranswer);
                    flushall();
                   
                    printf("\n You Entered %d",useranswer);
                    
                    if(useranswer!=Answer[i])//when the Answer entered by the user is not equal to the one stored in the array display the following
                    {
                        printf(" \n Wrong Answer");
                        printf("\n The right answer is %d \n",Answer[i]);    
                        
                        incorrect++;
                    }//end if in case 2 for loop
                    if(useranswer==Answer[i])//when the answer entered by the user is equal to the one stored in the array display the following
                    {
                        printf(" \n Your Answer is right \n");  
                        
                        correct++;
                    }//end 2nd if in case 2 for loop  
                    
                    QuestionNumber++;
                    
                }//end for in case 2
                
                counter++;
                
                printf("Enter Any key to continue....");
                
                getchar();
                clrscr();
               
                break;
            }//end Case 2:
            
            case 3://When 3 in-putted Start option 3 
            {
                if(counter==0)
                {
                    while(counter==0)//the 3rd option is only visible when the quiz is played once so when the user 
                    //tries to enter 3 before starting the quiz display the following error   
                    {   
                        printf("The 3rd Option will only appear when you will attempt the quiz at least once \n");
                        printf("Enter any key to return to the menu \n");
                        
                        scanf("%d",&select);
                        counter++;
                        flushall();
                        
                        clrscr();
                        
                    }//end While in case 3      
                    counter=0;//counter is put back to 0 as this error should only display when the user inputs 3 before the quiz started
                }//end 1st if in case 3
                
                if(counter>0)//Display the Option To check your score only after the counter is more than zero i.e After the quiz is done at least once 
                {
                    printf("Your Correct Score = %d \n",correct);
                    printf("Your Incorrect Score = %d \n",incorrect);
                    printf("Enter Any key to continue....");
                    
                    getchar();
                    clrscr();
                    
                }//end 2nd if in case 3
                break;
            }//end Case 3:
                
            case 0: // When 0 in-putted Start the fourth option which is ending the quiz
            {
                
                printf("You Chose To Exit The Quiz, Thanks For Playing");
                getchar();
                return 0;
                break;
            }//end Case 0:
                   
            default: // if the input is anything else other than something from the menu display the following .
            {     
                while(select<0 || select > 3)//ask the user for a appropriate input until a valid one is submitted by the user and return 
                // to the main menu once a valid option is entered    
                {   
                    printf("Your Input is invalid (0,1,2,3 are the valid inputs) \n");
                    printf("Please enter a Appropriate character to go back to the main menu \n");
                    scanf("%d",&select);
                    flushall();
                }//end While in default
                           
                clrscr();//clear screen
                break;
            }//End Default
        }//End Switch
    }//end Do
    while(n==0);// while statement from the do while loop
}//end Main