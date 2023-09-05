# Recursion in python:

# recursion = a function that calls itself from within
#                      helps to visualize a complex problem into basic steps
#                      problems can be solved more easily iteratively or recursively
#                      iterative = faster, complex
#                      recursive = slower, simpler

# ----- EXAMPLE 1 -----

# ITERATIVE
def walk(steps):
    for step in range(1, steps+1):
        print(f"You take step #{step}")

# RECURSIVE
def walk(steps):
    if steps == 0:
        return
    walk(steps - 1)
    print(f"You take step #{steps}")

walk(100)

# ----- EXAMPLE 2 -----

# ITERATIVE
def factorial(x):
    result = 1
    if x > 0:
        for i in range(1, x + 1):
            result *= i
        return result

# RECURSIVE
def factorial(x):
    if x == 1:
        return 1
    else:
        return x * factorial(x - 1)

print(factorial(10))