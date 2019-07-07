import random

ID = 10001
num = 200
wfile = open("E:/graderes.txt","a")

newline = ""
for _ in range(num):
    newID = ID+_
    newchgrade = random.randint(0,100)
    newmagrade = random.randint(0,100)
    newengrade = random.randint(0,100)
    newline = newline + str(newID) + "\t"+str(newchgrade) +"\t"+str(newmagrade)+"\t"+str(newengrade)+"\n"
wfile.write(newline)
wfile.close() 
