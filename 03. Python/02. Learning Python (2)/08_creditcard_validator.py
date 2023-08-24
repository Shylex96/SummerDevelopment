# Python credit card validator program

# 1. Remove any '-' or ' '
# 2. Add all digits in the odd places from right to left
# 3. Double every second digit from right to left.
#        (If result is a two-digit number,
#        add the two-digit number together to get a single digit.)
# 4. Sum the totals of steps 2 & 3
# 5. If sum is divisible by 10, the credit card # is valid

# TEST CREDIT CARD ACCOUNT NUMBERS:

# American Express 378282246310005 
# American Express 371449635398431
# American Express Corporate 378734493671000
# Australian Bankcard 5610591081018250
# Diners Club 30569309025904
# Diners Club 38520000023237
# Discover 6011111111111117
# Discover 6011000990139424
# JCB 3530111333300000
# JCB 3566002020360505
# MasterCard 5555555555554444
# MasterCard 5105105105105100
# Visa 4111111111111111
# Visa 4012888888881881

sum_odd_digits = 0
sum_even_digits = 0
total = 0

# Step 1
card_number = input("Enter a credit card #: ")
card_number = card_number.replace("-", "")
card_number = card_number.replace(" ", "")
card_number = card_number[::-1]

# Step 2
for x in card_number[::2]:
    sum_odd_digits += int(x)

# Step 3
for x in card_number[1::2]:
    x = int(x) * 2
    if x >= 10:
        sum_even_digits += (1 + (x % 10))
    else:
        sum_even_digits += x

# Step 4
total = sum_odd_digits + sum_even_digits

# Step 5
if total % 10 == 0:
    print("VALID")
else:
    print("INVALID")