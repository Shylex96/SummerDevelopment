class Car:

    # We don't need this having the init method below.
    # We can erase rows 5 to 8 if we want.
    make = None
    model = None
    year = None
    color = None

    wheels = 4 # class variable

    # Init method: This will construct objects for us (constructor).
    def __init__(self,make,model,year,color):
            self.make = make # instance variable
            self.model = model # instance variable
            self.year = year # instance variable
            self.color = color # instance variable

    def drive(self):
            print("This "+self.model+" is driving")

    def stop(self):
            print("This "+self.model+" is stopped")