from tkinter import *

def create_window():
    new_window = Tk()       #Toplevel() = new window 'on top' of other windows, linked to a 'bottom' window
                            #Tk() = new independent window
    #old_window.destroy()   #close out of old window

old_window = Tk()
old_window.geometry("150x50")

button = Button(old_window,text="create new window",command=create_window)
button.place(x=20, y=10)

old_window.mainloop()