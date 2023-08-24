# format specifiers = {value:flags} format a value based on what flags are inserted

price1 = 3.14159
price2 = -987.65
price3 = 12.34
price4 = -3875.123

print(f"Price 1 is ${price1:.3f}")
print(f"Price 2 is ${price2:.3f}")
print(f"Price 3 is ${price3:.3f}")

# We can also use:
#print(f"Price 1 is ${price1:^10}")
#print(f"Price 1 is ${price1:>10}")
#print(f"Price 1 is ${price1:<10}")
#print(f"Price 1 is ${price1:10}")
#print(f"Price 1 is ${price1: }")
#print(f"Price 1 is ${price1:+}")
#print(f"Price 4 is ${price4:,}")

# So doing this we can do stuff like:
print(f"Price 4 is ${price4:+,.2f}")
