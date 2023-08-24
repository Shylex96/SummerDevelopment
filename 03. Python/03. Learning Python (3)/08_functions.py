print("------- EXAMPLE 0 -------")
# ---------  EXAMPLE 0  --------- 
def happy_birthday(name, age):
   print(f"Hello {name}")
   print(f"You are {age} years old")

happy_birthday("Esteban", 26)
happy_birthday("María", 22)

print()

print("------- EXAMPLE 1 -------")
# ---------  EXAMPLE 1  --------- 
def display_invoice(username, amount, due_date):
   print(f"Hello {username}")
   print(f"Your bill of ${amount:.2f} is due: {due_date}")

display_invoice("Esteban", 42.50, "01/02")
display_invoice("María", 100.99, "02/03")

print()

print("------- EXAMPLE 2 -------")
# ---------  EXAMPLE 2  --------- 
def create_name(first, last):
    first = first.capitalize()
    last = last.capitalize()
    return first + " " + last

full_name = create_name("spongebob", "squarepants")
print(full_name)