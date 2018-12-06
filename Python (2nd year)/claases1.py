class Student(object):
    def __init__(self, first='',last='',id=0):
        self.firstname = first
        self.lastname = last
        self.id = id
    def update(self, first='',last='',id=0):
        if first:
            self.firstname = first
        if last:
            self.lastname = last
        if id:
            self.id = id
    def __str__(self):
        return "{} {}, ID:{}".\
            format(self.firstname,self.lastname,self.id)

first = Student("maciek","skrzypczynski",10)

print(first)

first.update('','john',20)

print(first)