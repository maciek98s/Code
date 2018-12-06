class Store:

    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.items = {}

    # rest of your code here. . .

    def additem(self, item, price):
        self.items[str(item)] = float(price)

    def delitem(self, item):
        del self.items[str(item)]

    def displayinventory(self):
        return self.items




clas = Store('Spar',"maciej")

clas.additem('guns',10)

print(clas.displayinventory())