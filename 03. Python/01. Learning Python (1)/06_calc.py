# CALCULATOR - PROGRAM -

print("")
print("CALCULATOR PROGRAM")
print("---------------")
print("")

print("Do you want to calc an area (a) or a volume (v)?")
letterPressed = input()

if letterPressed == 'a':
    length = float(input("Enter the length of a rectangle: "))
    width = float(input("Enter the width of a rectangle: "))
    area = length * width
    print(f"The are is: {area} cm^2")
elif letterPressed == 'v':
    length = float(input("Enter the length of a rectangle: "))
    width = float(input("Enter the width of a rectangle: "))
    height = float(input("Enter the height of a rectangle: "))

    volume = length * width * height
    print(f"The volume is: {volume} cm^3")
else:
    print("The letter pressed wasn't an 'a' or 'v'")
