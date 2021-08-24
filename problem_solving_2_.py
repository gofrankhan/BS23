x = input()
mylist = []

for i in range(int(x)):
    row = input()
    tempList = row.split(" ")
    mylist.append(tempList)

mylist.sort(key=lambda x : x[2], reverse=True)

def cmpValue(info1, info2):
    if(info1[2] > info2[2]):
        return 1
    if(info1[2] == info2[2]):
        if(info1[1] == info2[1]):
            if(info1[0] < info2[0]):
                return 1
            else:
                return -1
        if (info1[1] < info2[1]):
            return 1
        else:
            return -1
    return 0

from functools import cmp_to_key
mylist = sorted(mylist, key=cmp_to_key(cmpValue), reverse=True)
for i in range(int(x)):
    print(mylist[i][1])
