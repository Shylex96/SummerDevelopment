from tkinter import *

# label = an area widget that holds text and/or an image within a window

window = Tk()
window.title("Test Window v1")
window.geometry("350x300")

photo = PhotoImage(file='D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)\\resources\\person.png')

label = Label(window,
              text="Hey, this is a test",
              font=('Arial',20,'bold'),
              fg='#FFFFFF',
              bg='black',
              relief='raised',
              # bd = border
              bd=10,
              # padx & pady are the padding (x,y)
              padx=20,
              pady=40,
              image=photo,
              compound='bottom')


# Pack by default center the content
label.pack()
# Other option is using 'place' so we can 
#   set where exactly we want an element.
# label.place(x=0,y=0)

window.mainloop()