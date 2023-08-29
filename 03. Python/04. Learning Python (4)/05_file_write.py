# If the file is in the project folder we only need the name.
# If the file is your SO, we need the path and also import OS.

# Also if you write:
# with open('test.txt','w') as file: 
# Then it will create a new one on the main folder.

text = "Hello!\nThis is some text\nHave a good one!\n"

with open("D:\\VSCDevelopment\\03. Python\\04. Learning Python (4)\\write_test.txt",'w') as file:
    file.write(text)