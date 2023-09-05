from tkinter import *

def button_press(num):
    global equation_text
    equation_text = equation_text + str(num)
    equation_label.set(equation_text)

def equals():
    global equation_text
    try:
        total = str(eval(equation_text))
        equation_label.set(total)
        equation_text = total
    except SyntaxError:
        equation_label.set("Syntax Error")
        equation_text = ""
    except ZeroDivisionError:
        equation_label.set("Arithmetic Error")
        equation_text = ""

def clear():
    global equation_text
    equation_label.set("")
    equation_text = ""

window = Tk()
window.title("Calculator Program")
window.geometry("300x400")
window.configure(background="#f0f0f0")

equation_text = ""
equation_label = StringVar()

label = Label(
    window, textvariable=equation_label, font=("Helvetica", 18), bg="white", bd=10, relief="raised", anchor="e"
)
label.pack(fill="both", expand=True, padx=10, pady=10)

button_frame = Frame(window)
button_frame.pack()

buttons = [
    ("7", 1, 0), ("8", 1, 1), ("9", 1, 2), ("/", 1, 3),
    ("4", 2, 0), ("5", 2, 1), ("6", 2, 2), ("*", 2, 3),
    ("1", 3, 0), ("2", 3, 1), ("3", 3, 2), ("-", 3, 3),
    ("0", 4, 0), (".", 4, 1), ("=", 4, 2), ("+", 4, 3)
]

for (text, row, column) in buttons:
    if text == "=":
        btn = Button(
            button_frame, text=text, font=("Helvetica", 14),
            width=4, height=2, command=equals
        )
    else:
        btn = Button(
            button_frame, text=text, font=("Helvetica", 14),
            width=4, height=2, command=lambda t=text: button_press(t)
        )
    btn.grid(row=row, column=column, padx=2, pady=2)

# Clear button
clear_btn = Button(window, text="Clear", font=("Helvetica", 12), command=clear)
clear_btn.pack(fill="both", padx=10, pady=5)

window.mainloop()
