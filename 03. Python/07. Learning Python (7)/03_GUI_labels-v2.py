from tkinter import *

def center_window(window, width, height):
    screen_width = window.winfo_screenwidth()
    screen_height = window.winfo_screenheight()
    x = (screen_width - width) // 2
    y = (screen_height - height) // 2
    window.geometry(f"{width}x{height}+{x}+{y}")

window = Tk()
window.title("Test Window v2")

# Define dimensions and center the window on the screen
window_width = 350
window_height = 400
center_window(window, window_width, window_height)

photo = PhotoImage(file='D:\\VSCDevelopment\\03. Python\\07. Learning Python (7)\\resources\\person.png')

# Create global widget (label)
label = Label(window,
              text="Hey, this is a test",
              font=('Arial', 14, 'bold'),
              fg='#FFFFFF',
              bg='black',
              relief='raised',
              bd=10,
              padx=20,
              pady=10,
              image=photo,
              compound='top')  # Show image above text

label.pack(fill='both', expand=True, padx=10, pady=10)  # Fill space and expand itself

window.mainloop()
