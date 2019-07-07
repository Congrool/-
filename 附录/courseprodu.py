import random

wfile = open("E:/courseres.txt","a")

ID = 10001
num = 200

newline = ""
for _ in range(num):
    newid = ID+_
    courseList = []
    for __ in range(7):
        courseList.append(random.randint(0,1))
    newline = newline + str(newid) +"\t"
    for __ in range(7):
        newline = newline + str(courseList[__])+"\t"
    newline = newline[:-1]
    newline = newline + "\n"
wfile.write(newline)
wfile.close()