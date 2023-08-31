from tkinter import *

x_pos = 0
y_pos = 0

def update_position(dx, dy):
    global x_pos, y_pos
    x_pos += dx
    y_pos += dy
    window.after(50, show_position, dx, dy)  # Call show_position after 50 ms

def clickUp():
    update_position(0, 1)
    print("You moved 1 step up.")

def clickLeft():
    update_position(-1, 0)
    print("You moved 1 step left.")

def clickRight():
    update_position(1, 0)
    print("You moved 1 step right.")

def clickDown():
    update_position(0, -1)
    print("You moved 1 step down.")

def show_position(dx=0, dy=0):
    horizontal = f"{abs(x_pos)} {'horizontal' if x_pos > 0 else 'horizontal'}"
    vertical = f"{abs(y_pos)} {'vertical' if y_pos > 0 else 'vertical'}"
    print(f"Position: {vertical}, {horizontal}")
    print("-----------------------------------")

window = Tk()

frame = Frame(window, bg="black", bd=5, relief=SUNKEN)
frame.pack()

Button(frame, command=clickUp, text="W", font=("Consolas", 25), width=3).pack(side=TOP)
Button(frame, command=clickLeft, text="A", font=("Consolas", 25), width=3).pack(side=LEFT)
Button(frame, command=clickDown, text="S", font=("Consolas", 25), width=3).pack(side=LEFT)
Button(frame, command=clickRight, text="D", font=("Consolas", 25), width=3).pack(side=LEFT)

show_position()

window.mainloop()
