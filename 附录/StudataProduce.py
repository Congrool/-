import random

file = open('/home/ys/桌面/data.txt','w')
upperch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
lowch = "abcdefghijklmnopqrstuvwxyz"
name_size = 8

datasize = 200
stat_id = 10001
class_range = 20
s = ""

i = 0
while i < datasize:
    name = ""
    cnt = 0
    name = name + str(upperch[random.randint(0,25)])
    j = 0
    while j < 8:
        name = name + str(lowch[random.randint(0,25)])
        j = j+1
    classnum = str(random.randint(1,class_range))
    chinese = str(random.randint(1,100))
    math = str(random.randint(1,100))
    english = str(random.randint(1,100))
    avg = ""
    sum = str(int(chinese)+int(math)+int(english))
    s = str(s+str(stat_id)+"\t"+name+"\t"+classnum+"\t"+chinese+"\t"+math+"\t"+english+"\t"+sum+"\t"+"\n")
    i = i+1
    stat_id = stat_id+1
s = s.encode("UTF-8")
file.write(str(s.decode('UTF-8')))
file.close()
        