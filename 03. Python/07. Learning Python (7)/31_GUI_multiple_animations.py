from tkinter import *
from ball import *
import time

window = Tk()

WIDTH = 500
HEIGHT = 400

canvas = Canvas(window,width=WIDTH,height=HEIGHT)
canvas.pack()

background_photo = PhotoImage(file='D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)\\resources\\space.png')
background = canvas.create_image(0, 0, image=background_photo, anchor=NW)

volley_ball = Ball(canvas,0,0,100,1,1,"white")
tennis_ball = Ball(canvas,0,0,50,4,3,"yellow")
basket_ball = Ball(canvas,0,0,125,3,5,"orange")
bowling_ball = Ball(canvas,0,0,75,2,1,"black")

while True:
    volley_ball.move()
    tennis_ball.move()
    basket_ball.move()
    bowling_ball.move()
    window.update()
    time.sleep(0.01)

window.mainloop()