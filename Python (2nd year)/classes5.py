class Module:
    def __init__(self,name):
        self.__name =name
        self.__student = []

    def get_module_name(self):
        return self.__name


    def add_student(self, p):
        self.__student.append(p)

    def get_student(self,):
        return self.__student

    def print_students(self):
        if self.__student == []:
            print("No Students")
        else:
            for i in range (len(self.__student)):
                print(self.__student[i])

class Student():
    def __init__(self, name, st_number):
        self.__name = name
        self.__st_number = st_number

    def __str__(self):
        return 'Student name '+self.__name+" st N:"+str(self.__st_number)


s1 = Student("john", "c17339163")
s2 = Student("bob", "3423422")

m = Module ("OOP")

m.add_student(s1)
m.add_student(s2)

print("Course: "+m.get_module_name())

students = m.get_student()

m.print_students()