# for loops = execute a block of code a fixed number of times.
#                     You can iterate over a range, string, sequence, etc.
print("------- EXAMPLE 1 --------")
# ---------------- EXAMPLE 1 ----------------

for x in range(1, 11):
   print(x)

print("------- EXAMPLE 2 --------")
# ---------------- EXAMPLE 2 ----------------

for x in reversed(range(1, 11)):
   print(x)

print("Happy New Year!")

print("------- EXAMPLE 3 --------")
# ---------------- EXAMPLE 3 ----------------

for x in range(1, 11, 2):
   print(x)

print("------- EXAMPLE 4 --------")
# ---------------- EXAMPLE 4 ----------------

credit_card = "1234-5678-9012-3456"

for x in credit_card:
   print(x)

print("------- CONTINUE --------")
# ---------------- CONTINUE ----------------

for x in range(1, 21):
   if x == 13:
       continue
   else:
       print(x)

print("------- BREAK --------")
# ---------------- BREAK ----------------

for x in range(1, 21):
   if x == 13:
       break
   else:
       print(x)