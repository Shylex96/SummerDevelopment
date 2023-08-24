# INPUTS
print("--------- INPUTS ---------")

name = input("Enter your name: ")
age = (input("Enter your age: "))

print(f"Hello {name}")
print(f"You are {age} years old")

print("--------- CASTING INPUTS (option 1) ---------")

age = int(input("Enter your age: "))
age = age + 1
print(f"You are {age} years old")

print("--------- CASTING INPUTS (option 2) ---------")

age = input("Enter your age: ")
age = int(age)
age = age + 1
print(f"You are {age} years old")

print("--------- A ---------")
