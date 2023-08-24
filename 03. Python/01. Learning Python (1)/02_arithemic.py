# OPERATORS

# friends = 10

# friends = friends + 1
# friends += 1
# friends = friends - 2
# friends -= 2
# friends = friends *3
# friends *= 3
# friends = friends / 2
# friends /= 2
# friends = friends ** 2
# friends **= 2
# remainder = friends % 3

# print(friends)

# FUNCTIONS
import math
x = 3.14
y = 4
z = 5

# ROUND
# result = round(x)

# ABSOLUTE
# result = abs(y)

# POW
# result = pow(4, 3)

# MAX & MIN
# result = max(x, y, z)
# result2 = min(x, y, z)
# print(result)
# print(result2)

print("--------- MATH MODULE ---------")

# MATH MODULE
print(math.pi)
print(math.e)

print("--------- SQUARE ROOT FUNC ---------")

# SQUARE ROOT FUNC
x = 9.47
result = math.sqrt(x)
print(result)

print("--------- CEIL & FLOOR ---------")
print("")

# CEIL: will always round a floating point number up
# FLOOR: will always round a floating point number down
print("--------- CEIL ---------")
result = math.ceil(x)
print(f"Number before ceil: {x}")
print(f"After ceil: {result}")

print("--------- FLOOR ---------")
result = math.floor(x)
print(f"Number before floor: {x}")
print(f"After floor: {result}")
