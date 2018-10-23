#program for an algorithm to convert to base of 2 to 9 from decimal by maciej skrzypczynski
#date 3/10/2018

# User enters number
numstr = input("Enter the number you want to convert to convert \n")
num = int(numstr)
decimal = 0

print("You have entered number",num)
#user enters the base
basestr = input("Please state the base from 2 to 9 \n")
base = int(basestr)

binary = ''
#error checking to check if the user base entered is within the right range
while base > 9 or base <=1:
    basestr = input("Please enter the number in the correct range,2 to 9 \n")
    base = int(basestr)

#while loop calculating binary and putting it into the string
while num != 0 :

    remainder = num % base
    remainder = str(remainder)
    binary =  remainder + binary
    num = num / base
    num = int(num)
#display number in binary

print('your Number in the base of your choice is equal to  ',binary)

temp = 0#veriable used for temporary  use
r = len(binary) -1 #check length of string
value = 0 #variable used to store the string value converted back to an int
counter= 0 #counter variable

while r !=-1:
    value = int(binary[r])
    #if binary[r] == 0:
    temp = base**counter *value
    decimal = decimal + temp
    r = r -1
    counter = counter +1

print('Your original number used was  ',decimal)

