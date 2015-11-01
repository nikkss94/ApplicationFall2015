points = input("Starting point: ")
string = input("")

count1 = 0
x = ""
y = ""

for number in points:
    if number in "0123456789" and count1 == 0:
        x += number
    if number == ",":
        count1 += 1
    if number in "0123456789"and count1 == 1:
        y += number

x = int(x)
y = int(y)
count = 2

for s in string:
    if s == ">" and count % 2 == 0:
        x += 1
    if s == "<"and count % 2 == 0:
        x -= 1
    if s == "^" and count % 2 == 0:
        y -= 1
    if s == "v" and count % 2 == 0:
        y+= 1
    if s == "~":
        count += 1
    if s == ">" and count % 2 != 0:
        x-=1
    if s == "<" and count % 2 != 0:
        x+=1
    if s == "^" and count % 2 != 0:
        y+= 1
    if s == "v" and count % 2 != 0:
        y+= 1
    
print("(%s , %s)"%(x,y))
