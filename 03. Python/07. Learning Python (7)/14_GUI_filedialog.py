from tkinter import *
from tkinter import filedialog

def openFile():
    try:
        filepath = filedialog.askopenfilename(initialdir="D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)",
                                              title="Select a file to open",
                                              filetypes=(("text files", "*.txt"),
                                                         ("all files", "*.*")))
        if filepath:
            file = open(filepath, 'r')
            print(file.read())
            file.close()
    except Exception as e:
        print("An error occurred:", e)

window = Tk()
button = Button(text="Open", command=openFile)
button.pack()
window.mainloop()
