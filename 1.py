
import sys
import os
import re

#请完成下面这个函数，实现题目要求的功能
#当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
#******************************开始写代码******************************


def  divingBoard(a, b, k):


#******************************结束写代码******************************


_a = int(input())

_b = int(input())

_k = int(input())

def divingBoard(a,b,k):
    se = set()
    for i in range(k):
        l = a*i+b*(k-i)
        if not l in se:
            se.add(l)
    lse = list(se)
    lse.sort()
    return lse
            
            


  
res = divingBoard(_a, _b, _k)

for res_cur in res:
    print(str(res_cur) + "\n")