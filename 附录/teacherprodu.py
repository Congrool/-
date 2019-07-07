import random

course = ["语文","数学","英语","历史","人文","地理","政治","物理","化学","生物"]
cl = len(course)
first_name = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄"
fl = len(first_name)
file = open("E:/name.txt")
second_name = file.read()
sl = len(second_name)

teachername = []
teachernum = 20
for _ in range(teachernum):
    name = ""
    name = first_name[random.randint(0,fl)]+second_name[random.randint(0,sl)]
    teachername.append(name)

num = 100
cnt = 0
newline = ""
wfile = open("E:/teacherres.txt",'w')
for _ in range(cl):
    if(_*20 > num):
        break
    for __ in range(20):
        newcourse = course[_]
        if __ == 0:
            newclass = __+1
        else:
            newclass = __
        newteacher = teachername[cnt]
        cnt = cnt+1
        cnt = cnt%teachernum
        newline = newline + str(newclass) + "\t" + str(newcourse) + "\t" + str(newteacher) + "\n"
wfile.write(newline)
wfile.close()