from tkinter import *
from time import *

def update():
    time_string = strftime("%I:%M:%S %p")
    time_label.config(text=time_string)

    day_string = strftime("%A")
    day_label.config(text=day_string)

    date_string = strftime("%B %d, %Y")
    date_label.config(text=date_string)

    window.after(1000,update)


window = Tk()

time_label = Label(window,font=("Arial",50),fg="#FFFFFF",bg="black")
time_label.pack()

day_label = Label(window,font=("Arial",25,"bold"))
day_label.pack()

date_label = Label(window,font=("Arial",30))
date_label.pack()

update()

window.mainloop()