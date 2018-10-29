#Author : Maciej Skrzypczynski
#Program description : Program designed to find the sum and the difference of two fractions
#As well as fiding a fractions simplest form
#Date : 29/10/2018

def GCD(a,b):
    """Function to find the greatest common divider """
    if b > a:
        if b % a == 0:
            return a
        else:
            return GCD(b % a, a)
    else:
        if a % b == 0:
            return b
        else:
            return GCD(b, a % b)


def LCM(a, b,x):
    """Compute the lowest common multiple of a and b"""
    return a * b / x


def addfrac(num1,dom1,num2,dom2,c):
    """Function to calculate the sum of two fractions """
    dev = c / dom1
    dev2= c / dom2
    num1 = dev * num1
    num2 = dev2* num2
    c = int(c)
    finalnum = num1 + num2
    finalnum = int(finalnum)
    adddedfrac = (finalnum,c)
    print("Your Fractions added are equal to ",adddedfrac)


def subfrac(num1,dom1,num2,dom2,c):
    """Function to calculate the difference of two fractions """
    dev = c / dom1
    dev2= c / dom2
    num1 = dev * num1
    num2 = dev2* num2
    c = int(c)
    finalnum = num1 - num2
    finalnum = int(finalnum)
    subtractedfrac = (finalnum,c)
    print("Your Fractions substracted are equal to ",subtractedfrac)


def reduce(a,b,c,):
    """Function to Display a fraction in its simplest form"""
    a = (a) / c
    a = int(a)
    b = (b) / c
    b = int(b)
    reduced = (a,b)
    print("The reduced fraction is equal to",reduced)


x = 0 # the GCD is stored in X
y = 0 # the LCM is sotred in y

nummerator_one = int(input("Enter The first numerator"))
dominator_one = int(input("Enter The first dominator"))
fractionone = (nummerator_one,dominator_one)

nummerator_one = int(input("Enter The second numerator"))
dominator_one = int(input("Enter The second dominator"))
fractiontwo = (nummerator_one,dominator_one)

print("Your First fraction is",fractionone)
print("Your second fraction is ",fractiontwo)


y = GCD(fractionone[1],fractiontwo[1])
x = LCM(fractionone[1],fractiontwo[1],y)

addfrac(*fractionone,*fractiontwo,x)
subfrac(*fractionone,*fractiontwo,x)

print("Enter a fraction you want to reduce ")
nummerator_one = int(input("Enter the numerator"))
dominator_one = int(input("Enter the dominator"))

reducefrac = (nummerator_one,dominator_one)
y = GCD(reducefrac[1],reducefrac[0])
reduce(*reducefrac,y)