# You can check "inheritance.png"

from car import Car

car_1 = Car("Chevy","Corvette",2021,"blue")
car_2 = Car("Ford","Mustang",2022,"red")

car_1.drive()
car_2.stop()

print(f"The first car is a {car_1.color} {car_1.model} made by {car_1.make} at the {car_1.year}")

# Example using class variables instead of instance variables.
print(f"The first car have {car_1.wheels} wheels.")

# If we change the class variable:
Car.wheels = 2
print(f"Now the first car have {car_1.wheels} wheels")