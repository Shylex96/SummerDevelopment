from tkinter import *

window = Tk()

def store_data():
    data = {
        "First name": firstNameEntry.get(),
        "Last name": lastNameEntry.get(),
        "Email": emailEntry.get()
    }

    print("Stored Data:")
    for key, value in data.items():
        print(f"{key}: {value}")

titleLabel = Label(window, text="Enter your info", font=("Arial", 25))
titleLabel.grid(row=0, column=0, columnspan=2)

firstNameLabel = Label(window, text="First name:", width=20, bg="red")
firstNameLabel.grid(row=1, column=0)
firstNameEntry = Entry(window)
firstNameEntry.grid(row=1, column=1)

lastNameLabel = Label(window, text="Last name:", width=20, bg="green")
lastNameLabel.grid(row=2, column=0)
lastNameEntry = Entry(window)
lastNameEntry.grid(row=2, column=1)

emailLabel = Label(window, text="Email:", width=20, bg="blue")
emailLabel.grid(row=3, column=0)
emailEntry = Entry(window)
emailEntry.grid(row=3, column=1)

submitButton = Button(window, text="Submit", command=store_data)
submitButton.grid(row=4, column=0, columnspan=2)

window.mainloop()
