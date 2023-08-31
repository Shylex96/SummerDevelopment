from tkinter import *

# button = you click it, then it does stuff

count = 0

def click():
    global count
    count+=1
    print(count)

window = Tk()
window.title("CK")

photo = PhotoImage(file='D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)\\resources\\person.png')

button = Button(window,
                text="Click me!",
                command=click,
                font=("Comic Sans",30),
                fg="#00FF00",
                bg="black",
                activeforeground="#00FF00",
                activebackground="black",
                state=ACTIVE,
                image=photo,
                compound='bottom')
button.pack()

window.mainloop()