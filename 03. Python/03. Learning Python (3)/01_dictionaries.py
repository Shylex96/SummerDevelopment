# dictionary =  a collection of {key:value} pairs
#                       ordered and changeable. No duplicates

print("-------- Dictionaries: --------")
capitals = {"USA": "Washington D.C.",
                    "India": "New Delhi",
                    "China": "Beijing",
                    "Russia": "Moscow"}

# print(dir(capitals))
# print(help(capitals))
print(capitals.get("Japan"))

print()

if capitals.get("Russia"):
    print("That capital exists")
else:
    print("That capital doesn't exist")

capitals.update({"Germany": "Berlin"})
# capitals.update({"USA": "Detroit"})
# capitals.pop("China")
# capitals.popitem()
# capitals.clear()

print("-------- ONLY COUNTRIES: --------")
print()

keys = capitals.keys()
for key in capitals.keys():
   print(key)

print()
print("-------- COUNTRY + CAPITAL: --------")
print()
# values = capitals.values()
# for value in capitals.values():
# print(value)

items = capitals.items()
for key, value in capitals.items():
    print(f"{key}: {value}")