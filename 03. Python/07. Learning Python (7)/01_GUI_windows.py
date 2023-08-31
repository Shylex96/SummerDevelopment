from tkinter import *

# widgets = GUI elements: buttons, textboxes, labels, images..
# windows = servers as a container to hold or contain these widgets

window = Tk() #instantiate an instance of a window
window.geometry("420x420")
window.title("First GUI program")
icon = PhotoImage(file='D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)\\resources\\gear.png')
window.iconphoto(True,icon)
window.config(background="#403C3B")

window.mainloop() #place window on computer screen, listen for events