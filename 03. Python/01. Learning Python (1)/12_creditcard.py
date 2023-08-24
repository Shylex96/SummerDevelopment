# indexing = accessing elements of a sequence using [] (indexing operator)
#            [start : end : step]
# start (first number) is inclusive but the end (second number) is exclusive

credit_number = "1234-5678-9012-3456"

# print(credit_number[0])

print("--------- Array accessing (1) ---------")
# You can run both and they will do the same
print(credit_number[0:4])
print(credit_number[:4])

print("--------- Array accessing (2) ---------")
# This can also get the rest of numbers
print(credit_number[5:])

print("--------- Array accessing (3) ---------")
# We can also use negative numbers
# This will get the last number (from right to left)
print(credit_number[-1])
# This will get all from begining to the final step by 2
print(credit_number[::2])

print("----------- Useful of this: -----------")
# Useful
last_digits = credit_number[-4:]
print(f"XXXX-XXXX-XXXX-{last_digits}")

print("--------- Reverse the String: ---------")
# Reverse the String
print(f"Current credit number before reverse: {credit_number}")
credit_number = credit_number[::-1]
print(f"Current credit number after reverse: {credit_number}")
