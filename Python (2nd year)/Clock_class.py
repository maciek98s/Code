import time

class clock():
    def __init__(self,seconds,minutes,hours):
        self.s = seconds
        self.m = minutes
        self.h = hours
    def __str__(self):
        return "time is {}:{}:{}".format(self.h,self.m,self.s)

t1 = clock(40,20,2)

print(t1)
