Name : Maciej Skrzypczynski Student Number : C17339163  Date : 11/04/2019
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
Data Explorer Assignment topic 
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
Github link  : https://github.com/maciek98s/Code/tree/master/Java%20project/Java%20Assignment
youtube Link : https://youtu.be/ztyzqWRHKv8

-------------------------------------------------------------------------------------------------------------------------------------------------------------------
Classes 
GUI Class
DBConnect Class
QueryProcessing class
Control Class

SQL and Data cleaning 
During the making of assigment i have downloaded and created a local 
oracle server on my own machine at home in order to use Sql developer to make a table and
then import the data from a csv file into the table, i have used the following sql command to use the table 
create table city(
"NUMBER" NUMBER(4),
"NAME" VARCHAR(100),
"LOCATION" VARCHAR(100),
"AREAOFCITY" VARCHAR(50),
"FACILITIES" VARCHAR(500),
"DESCR" VARCHAR(200)
);
The table city stores The numberid, name, lcoation,areaofcity,facilities and description from the data set  parks in galway city
that was aquired from the link supplied with the assignment description. I had also made a copy of the table on my redwood
schema in dit in order successfully demo the program in the lab on DIt machines. When i was importing the data into the table
i aslo had to get rid of some collumns like latitude logitude etc, as they would just take up space and they do not provide
good data for the user to work with in the program.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
Further Desciption of classes and thier methods in case more information needed
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
DBConnect class
description - a class mainly used to open and close connections to the database 
public boolean Connect() - method used to connect to the database and return true or false depending wether the connection was
successfull or not.
public void closeConnection - method used to close current connection.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
QueryProcessing class
description- a class mainly used to execute and manipulate queries

Constructor - Creates a DBConnect object and connects to the database

public void executeQuery(string query) - method cretes a statement variable and then sets the result variable by executing
the statement with the query passed which would be an sql statement.The method sets the variable query status to be true / false
depending if the execution of the SQl statement was successfull 

public TableModel queryToTableModel - this is the method borrowed from the rs2xml.jar file 
the method creates a Resultsetmeta data object from the result variable in order to then use
the metadata to get the column count and then use a for loop to initalise a String vector with 
the columns that are in the data table
then it creates a Vector object storing vector objects called "rows".("Vector<Vector<Object>> rows = new Vector<Vector<Object>>();")
After that the method has a while loop which whenever is entered it creates a new Vector object
called "newRow" which will store the data from the row that result.next is on at that moment into the NewRow vector meaning that the newRow vector
object contains the data thats inside of the row and then the newrow vector is added to the vector created previously called rows meaning that
the newRow vector stores data from each row and the rows vector stores the all newRow vectors so it basically stores all rows that were in 
the resultset then the data is return as a new DefaultTable Model(rows,columnNames) so when the method is called it will create a table
that will have columns stored in columnNames and the rows stored in rows vector. Overall it will create a table from whatever columns and whatever
rows are in ResultSet.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
GUI class 
NormalModeOn,AdvanceModeOn,SqlModeOn - these methods just change the look of the west panel to like it should for the appropriate mode is entered.
clearMode- this method just clears the west screen before the user enters a mode in order to clear any previous componenents on it.
clear Table method just clears the table from the scroll panel from the screen and the display table
initilises the center panel with the Scrollpane in order to show the table

the connectButton - when clicked and connection successfull the button is no longer used and loads the rest of the components to the North panel, 
if connection is not successfull the program terminates, this button is also reused for a submit button in the SQLmode to execute the
statement entered in that mode.if selectTextfield.getText is not equal to "Enter Category" it means the next time the button will
 be pressed it will be used for a Submit button in sql mode and not a connectbutton

the submitButton - this is used for a submit button in advance mode to execute which ever category the user wants to see as a select statement 
and it also check if the user has entered a clause or not meaning if the have entered a clause the program will execute the clause in the select statement
 with a where clause instead of just a normal select statement. i have made all my columns in the table in all capitol laters so then when the user enters a 
category that the want to see i bring everything to UpperCase to 
prevent Case sensitive errors. 

errorMessageCheck()- this is just a method to display a message to the user to inform them they have done something wrong. 
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
OverAll Programm Features
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
>Connecting to database using JDBC driver
>Shows iteresting facts from the Data Set
>Gui that allows for queries and displays queries in a JTable
>Flexible Queries 
>Option to navigate through modes from Least To More Flexible ones 
>appropriate Error message when invalid Input entered


