# radio button = similar to checkbox, but you can only select one from a group
from tkinter import *

food = ["pizza","hamburger","hotdog"]

def order():
    if(x.get()==0):
        print("You ordered pizza!")
    elif(x.get()==1):
        print("You ordered a hamburger!")
    elif(x.get()==2):
        print("You ordered a hotdog!")
    else:
        print("huh?")


window = Tk()

x = IntVar()
for index in range(len(food)):
    radiobutton = Radiobutton(window, 
                              text=food[index],
                              variable=x,
                              value=index,
                              command=order)
    radiobutton.pack()
window.mainloop()