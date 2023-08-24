# collection = single "variable" used to store multiple values

#   List  = [] ordered and changeable. Duplicates OK
#   Set   = {} unordered and immutable, but Add/Remove OK. NO duplicates
#   Tuple = () ordered and unchangeable. Duplicates OK. FASTER

fruits = ["apple", "orange", "banana", "coconut", "banana"]
fruits[0] = "pineaple"
# fruits.append("pineaple")
# fruits.remove("apple")
# fruits.insert(0, "pineaple")
# fruits.sort()
# fruits.reverse()
# fruits.clear()
print(fruits.index("pineaple"))
print(fruits.count("banana"))
