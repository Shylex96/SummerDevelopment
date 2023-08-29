# Scope resolution = (LEGB) Local -> Enclosed -> Global -> Built-in
 
# ----- LOCAL -----

def func1():
    x = 1 #local
    print(x)

def func2():
    x = 2 #local
    print(x)

func1()
func2()

# ----- ENCLOSED -----

def func1():
    x = 1 #enclosed

    def func2():
        print(x)
    func2()

func1()

# ----- GLOBAL -----

def func1():
    print(x)

def func2():
    print(x)

x = 3 #global

func1()
func2()

# ----- BUILT-IN -----

from math import e 

def func1():
    print(e)

func1()