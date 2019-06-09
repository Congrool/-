import random

re = open('/home/ys/桌面/html.txt','r')
cityname = []
cur = re.readline()
while cur != "":
    cityname.append(cur[0:-1])
    cur = re.readline()
re.close()

datasize = 200
pricerange = 600
citysize = len(cityname)
checisign = ['G','D','Q']
tp = ['高铁','动车','汽车']

rec = [[],[],[]]

res = ""
while datasize:
    datasize = datasize - 1

    sth = random.randint(0,22)
    stm = random.randint(0,59)
    addm = random.randint(1,60-stm+60*(24-sth))
    edh = sth+int(addm/60)
    edm = addm%60
    sttime = str(sth)+':'+str(stm)+':'+'00'
    edtime = str(edh)+':'+str(stm)+':'+'00'

    sel = random.randint(0,2)
    checinum = random.randint(1000,9999)
    while rec[sel].count(checinum) >= 1:
        checinum = random.randint(1000,9999)
    checi = checisign[sel]+str(checinum)

    ttp = tp[sel]

    stpn = random.randint(0,citysize-1)
    stp = cityname[stpn]

    edpn = random.randint(0,citysize-1)
    while edpn == stpn:
        edpn = random.randint(0,citysize-1)
    edp = cityname[edpn]

    price = str(random.randint(10,pricerange))

    lastnum = str(random.randint(0,50))

    res = res + checi +"\t" + ttp + "\t" + stp + "\t" + edp + "\t" + sttime + "\t" + edtime + "\t" + price +'\t' + lastnum + '\n'

wr = open('/home/ys/桌面/traindata.in','w')
wr.write(res)
wr.close()