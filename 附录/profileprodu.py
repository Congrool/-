import random

file = open("E:/name.txt",'r')
first_name = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄"
second_name = file.read()
file.close()

fnl = len(first_name)
snl = len(second_name)
ID = 10001
num = 200
wfile = open("E:/res.txt",'a')
newline = ""
for _ in range(num):
    newid = ID + _
    fr = random.randint(0,fnl-1)
    nl = random.randint(1,2)
    newname = ""+first_name[fr]
    for __ in range(nl):
        sr = random.randint(0,snl-1)
        newname = newname+second_name[sr]
    newclass = random.randint(1,20)
    newline = newline+str(newid)+"\t"+str(newname)+"\t"+str(newclass)+"\t\n"
wfile.write(newline)
wfile.close()
    