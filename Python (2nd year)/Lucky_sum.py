#Author : Maciej Skrzypczynski
#Program Description : A program that contains a functon that returns the sum of 3 values passes but if one of
# the values is equal to 13 then it does not count towards the sum and the values to its right do not count
#Date : 29/10/2018

def lucky_sum(a, b, c):
    """Function to return the sum of 3 values passed but if the value is 13 then it does not count towards the sum and value to its right do not count"""
    if a == 13:
        a = 0
        b = 0
        c = 0
        lucky_sum(a, b, c)

    if b == 13:
        b = 0
        c = 0
        lucky_sum(a, b, c)

    if c == 13:
        c = 0
        lucky_sum(a, b, c)
    sum = a + b + c

    return sum

x = int(input("Enter First number"))
y = int(input("Enter First number"))
z = int(input("Enter First number"))
sum =lucky_sum(x,y,z)
print(sum)