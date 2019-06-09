file = open("/home/ys/桌面/name.txt",'r')
all_text = file.read()
new_text = ""
i = 0
while i < len(all_text):
    if all_text[i] >= u'\u4e00' and all_text[i] <= u'\u9fa5':
        new_text = new_text+all_text[i]
    i = i+1

nfile = open("/home/ys/桌面/tmp.txt",'w')
nfile.write(new_text)
file.close()
nfile.close()