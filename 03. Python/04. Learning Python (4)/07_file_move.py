# BE CAREFUL - WE ARE IMPORTING OS 

import os

source = "C:\\Users\\esteb\\Desktop\\source.txt"
destination = "C:\\Users\\esteb\\Desktop\\Com\\source.txt"

try:
    if os.path.exists(destination):
        print("There is already a file there")
    else:
        os.replace(source,destination)
        print(source+" was moved")
except FileNotFoundError:
    print(source+" was not found")