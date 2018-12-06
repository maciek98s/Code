class Shape:
    def print_details(self):
        pass

class Circle(Shape):
    def __init__(self, radius):
        self.__radius = radius
    def print_details(self):
        print("This is a circle with radius", self.__radius)
class Rectangle(Shape):
    def __init__(self, width, height):
        self.__width = width
        self.__height = height
    def print_details(self):
        print("This is a rectangle with sides", self.__width, self.__height)


shapes = [Circle(10),Rectangle(3,4), Circle(5)]

for s in shapes:
    s.print_details()
    print(type(s))