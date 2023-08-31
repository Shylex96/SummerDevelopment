from tkinter import *
from tkinter import filedialog

def openFile():
    print("File has been opened!")
    # try:
        # filepath = filedialog.askopenfilename(initialdir="D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)",
        #                                      title="Select a file to open",
        #                                      filetypes=(("text files", "*.txt"),
        #                                                 ("all files", "*.*")))
        # if filepath:
        #    file = open(filepath, 'r')
        #    print(file.read())
        #    file.close()
    # except Exception as e:
        # print("An error occurred:", e)

def saveFile():
    print("File has been saved!")
def cut():
    print("You cut some text!")
def copy():
    print("You copied some text!")
def paste():
    print("You pasted some text!")

window = Tk()

openImage = PhotoImage(file="D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)\\resources\\file.png")
saveImage = PhotoImage(file="D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)\\resources\\save.png")
exitImage = PhotoImage(file="D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)\\resources\\exit.png")

menubar = Menu(window)
window.config(menu=menubar)

fileMenu = Menu(menubar,tearoff=0,font=("MV Boli",15))
menubar.add_cascade(label="File",menu=fileMenu)
fileMenu.add_command(label="Open",command=openFile,image=openImage,compound='left')
fileMenu.add_command(label="Save",command=saveFile,image=saveImage,compound='left')
fileMenu.add_separator()
fileMenu.add_command(label="Exit",command=quit,image=exitImage,compound='left')

editMenu = Menu(menubar,tearoff=0,font=("MV Boli",15))
menubar.add_cascade(label="Edit",menu=editMenu)
editMenu.add_command(label="Cut",command=cut)
editMenu.add_command(label="Copy",command=copy)
editMenu.add_command(label="Paste",command=paste)

window.mainloop()