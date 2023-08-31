from tkinter import *

#entry widget = textbox that accepts a single line of user input

def submit():
    username = entry.get()
    print("Hello "+username)

def delete():
    entry.delete(0,END)

def backspace():
    entry.delete(len(entry.get())-1, END)

window = Tk()
window.title("Enter your name")

entry = Entry(window,
              font=("Arial",50),
              fg="#FFFFFF",
              bg="black")

#entry.insert(0,'Laloland')
#entry.config(show="*")
#entry.config(state=DISABLED)

entry.pack(side=LEFT)

submit_button = Button(window,text="Submit",command=submit)
submit_button.pack(side=RIGHT)

delete_button = Button(window,text="Delete",command=delete)
delete_button.pack(side=RIGHT)

backspace_button = Button(window,text="Backspace",command=backspace)
backspace_button.pack(side=RIGHT)

window.mainloop()