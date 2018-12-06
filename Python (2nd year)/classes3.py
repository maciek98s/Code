class MyClass(object):
    def __init__(self, param1=0):
        print("In Constructor")
        self.value = param1
        print(param1)

    def __str__(self):

        print("In str")
        return 'val is: {}'.format(str(self.value))

    def __add__(self, param2):

        print("in aDD")
        result = self.value + param2.value
        print(result)
        return MyClass(result)



add = MyClass(4)
add2 = MyClass(5)
add3 =  MyClass(0)

add + add2

print(add.value)
print(add2.value)


