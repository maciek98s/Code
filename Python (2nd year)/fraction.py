def GDC(a,b):
    if b > a:
        if b % a == 0:
            return a
        else:
            return GDC(b % a, a)
    else:
        if a % b == 0:
            return b
        else:
            return GDC(b, a % b)
def LCM(a, b,x):
    """Compute the lowest common multiple of a and b"""
    return a * b / x


def addfrac(num1,dom1,num2,dom2,c):
    dev = c / dom1
    dev2= c / dom2
    num1 = dev * num1
    num2 = dev2* num2
    c = int(c)
    finalnum = num1 + num2
    finalnum = int(finalnum)
    adddedfrac = (finalnum,c)
    print(adddedfrac)
def reduce(a,b,c,d,e)
#reminder when coontinueing later
# reduce is just nominator and dominator divided by the GCD
#substraction same as addition just - instead of the plus








nummerator_one = int(input("Enter The first numerator"))
dominator_one = int(input("Enter The first dominator"))
fractionone = (nummerator_one,dominator_one)

nummerator_one = int(input("Enter The second numerator"))
dominator_one = int(input("Enter The second dominator"))
fractiontwo = (nummerator_one,dominator_one)

print(fractionone)
print(fractiontwo)


x = 3
y = 3
c = 6

y = GDC(fractionone[1],fractiontwo[1])
print(x)
x = LCM(fractionone[1],fractiontwo[1],y)
print(x)
addfrac(*fractionone,*fractiontwo,x)

reduce(*fractionone,*fractiontwo,y)