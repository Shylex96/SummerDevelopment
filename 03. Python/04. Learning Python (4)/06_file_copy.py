# copyfile() =  copies contents of a file
# copy() =      copyfile() + permission mode + destination can be a directory
# copy2() =     copy() + copies metadata (file’s creation and modification times)

# We need to import shutil module to have these three basic functions above.

import shutil

try:
    shutil.copyfile("D:\\VSCDevelopment\\03. Python\\04. Learning Python (4)\\read_test.txt", "D:\\VSCDevelopment\\03. Python\\04. Learning Python (4)\\copy_test.txt") #src,dst
    print("File has been copied.")
except FileNotFoundError:
    print("Path cant be found.")
except Exception as e:
    print(f"An error occurred: {e}")