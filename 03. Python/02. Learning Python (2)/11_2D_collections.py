# WAY 1

print("-------- Way 1: --------")
print()

fruits = ["apple", "orange", "banana", "coconut"]
vegetables = ["celery", "carrots", "potatoes"]
meats = ["chicken", "fish", "turkey"]

groceries = [fruits, vegetables, meats]
print(groceries[0][1])
print(groceries[1][1])

print()
print("-------- Way 2: --------")
print()

groceries = [["apple", "orange", "banana", "coconut"],
             ["celery", "carrots", "potatoes"],
             ["chicken", "fish", "turkey"]]

for collection in groceries:
    print(collection)

print()
print("-------- Separator: --------")
print()

for collection in groceries:
    for food in collection:
        print(food, end=" ")
    print()


print()
print("-------- Num Pad: --------")
print()

num_pad = ((1, 2, 3),
           (4, 5, 6),
           (7, 8, 9),
           ("*", 0, "#"))

for row in num_pad:
    for num in row:
        print(num, end=" ")
    print()

print()
