#Author : Maciej Skrzypczynski
#Date : 06/12/2018
#program description : A python class to represent a 2D vector with add multiply substract and magnitude functions

class Vectors(object):
    def __init__(self,x=0,y=0,):
        self.x_coordinate = x
        self.y_coordinate = y


    def __add__(self, param2):
        """Class Method for adding Vectors """
        result = self.x_coordinate + param2.x_coordinate
        result2 = self.y_coordinate + param2.y_coordinate
        return Vectors(result,result2)



    def __str__(self):
        """Class Method For printing """
        if  self.y_coordinate != 0:
            return "({},{})".format(self.x_coordinate,self.y_coordinate)
        else:
            return "{} ".format(self.x_coordinate)



    def __sub__(self, param2):
        """Class method for substracting Vectors """
        result  =self.x_coordinate - param2.x_coordinate
        result2 =self.y_coordinate - param2.y_coordinate
        return Vectors(result,result2)


    def __mul__(self, param2):
        """Class method For multiplying Vectors by Vectors and Vectors by an int"""
        if type(param2) ==int:
            result = self.x_coordinate * param2
            result2 = self.y_coordinate * param2
            return Vectors(result,result2)
        result = self.x_coordinate * param2.x_coordinate
        result2 = self.y_coordinate * param2.y_coordinate
        final_result = result + result2
        return Vectors(final_result)


    def magnitude(self):
        """Class method for finding out the magnitude """
        result = (self.x_coordinate*2 + self.y_coordinate*2)*.5
        return Vectors(result)




#main

v1 = Vectors(2,2)
v2 = Vectors(5,8)


print("v1 is equal to",v1)
print("v2 is equal to",v2)

print("\n Test Addition.....")
v3 = v1 + v2
print("v1 + v2")
print(v3)

print("\nTest multiplication.....")
print("v1 * v2")
print(v1*v2)
print("v1 * 3")
print(v1 * 3)

print("\nTest magnitude........")

print("v1 magnitude", v1.magnitude())

print("\nTest Substraction .....")
print("v1 - v2")
print(v1 - v2)
