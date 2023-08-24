# PRINTS
print("--------- PRINTS ---------")

age = 26
print("You are " + str(age) + " years old")
print("You are", age, "years old")
print(f"You are {age} years old")

print("--------- INTEGERS ---------")

# INTEGER

players = 2
quantity = 5

print(f"There are {players} players online of {quantity} max players.")

print("--------- FLOAT ---------")

# FLOAT

distance = 2.5
kcal = 130.25

print(f"You ran {distance} km and lost {kcal} kcal.")

print("--------- STRINGS ---------")

# STRING

name = "Eduard"
food = "Pizza"
email = "eduard99gt@gmail.com"

print(f"Hello {name}, you ordered a {food} on this email: {email}")

print("--------- BOOLEAN ---------")

# BOOLEAN

online = True
for_sale = False
running = True

print(f"Are you online?: {online}")
print(f"Is the item for sale?: {for_sale}")
print(f"Game running: {running}")

if running:
    print(f"Game is running")
else:
    print(f"Game is not running")

print("--------- VARIABLES ---------")
print("--------- Way (1) ---------")

# VARIABLES

# You can do it like this: (1)
x = 1
y = 2
z = 3

print(x)
print(y)
print(z)

print("--------- Way (2) ---------")

# or like this: (2)

x, y, z = 1, 2, 3

print(x)
print(y)
print(z)

print("--------- Way (3) ---------")

# If multiple variables to the same value: (3)

x = y = z = 1

print(x)
print(y)
print(z)

# TYPECASTING
# Explicit vs Implicit

print("--------- TYPECASTING ---------")

name = "Esteban"
age = 26
student = True

print(type(age))
print(age)

print("--------- Explicit ---------")

# Casting Explicit
age = float(age)

print(type(age))
print(age)


print("--------- Implicit ---------")

# Casting Implicit
# Here 'x' is an Int
x = 2
y = 2.0
print(x)

# Here is a Float
x = x / y + 1
print(x)
