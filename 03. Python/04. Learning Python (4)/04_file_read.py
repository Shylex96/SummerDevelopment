# If the file is in the project folder we only need the name.
# If the file is your SO, we need the path and also import OS.

try:
    with open("D:\\VSCDevelopment\\03. Python\\04. Learning Python (4)\\read_test.txt") as file:
        print(file.read())
except FileNotFoundError:
    print("That file was not found :(")
