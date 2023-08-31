from tkinter import *
from tkinter import colorchooser

def click():
    color = colorchooser.askcolor()
    colorHex = color[1]
    window.config(bg=colorHex)

window = Tk()
window.geometry("420x420")
button = Button(text='Click me', command=click)
button.place(x=170, y=350)
button.config(padx=20, pady=10)
#button.pack()
window.mainloop()