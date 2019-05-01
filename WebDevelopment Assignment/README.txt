Author: Maciej Skrzypczynski
Date: 02/05/2019
---------------------------------------------------------------------------------------------------------------------------------------------------
Web Development Assignment
Layout:
5 - Html pages 
6 - PHp pages
5 - CSS 
and images 
----------------------------------------------------------------------------------------------------------------------------------------------------
Html pages 
---------------------------------------------------------------------------------------------------------------------------------------------------
Homepage.html - Contains the home page of the the website which contains few welcome information 
and other information about the "driving school "

About.html - About page just contains some random information about the website

contact.html - contains a contact form that can be filled to " contact " the admins 

Login.html - page containing 2 buttons login and create account that when clicked will activate a pop up
with a form either to login or create account 

LoginError.html - page that the website redirects into if the login is wrong 
---------------------------------------------------------------------------------------------------------------------------------------------------
Php pages 
---------------------------------------------------------------------------------------------------------------------------------------------------
newuser.php - php file that when entered it creates a table with the users username as its name which will then be used to store this users
 information in his own table meaning each user will have thier own table with
their own data, the php file also creates a table call user that stores information about all users that create an account. 

schedule.php - php file that diplays a table with user data on it depending on which user is logged in the data may vary. then this php file also
allows the user to edit, add and delete entries meaning it link to the
edit.php delte.php and add.php files via buttons however the adding and editing is done  on the 
schedule.php files it self in the form of a pop up instead of just completaly re directing the user to a different site

checkuser.php - file when entered will check if the username and password that the user is trying to log
in with are correct(are in the database ) and then if the login and password are in the user table in the
database the user will get redirected to schedule.php and if not to loginerror.html

edit.php - the php file which when the edit form is filled it passes the entered values into the edit.php
file and depending which ID the user has specified to edit, it will edit the chosen ID with the updated 
entries 

delete- in this file when the delete button is pressed it will pass a hidden value to the delete.php 
file which contains the id of which row to delete and then it will delete that row from the database

add.php - this file when the form fill correctly on the schedule.php when the add button is clicked will
enter the entered value into the database to be then displayed in the schedule.php file 

-----------------------------------------------------------------------------------------------------------------------------------------------------
Other Information 
-----------------------------------------------------------------------------------------------------------------------------------------------------
references - a lot of the styling and techniques used in this assignment where achieved with the help of https://www.w3schools.com website.






