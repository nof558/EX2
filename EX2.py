import json as js
import time
import psutil
import os

# This is the converted Java code from EX1 to python
pyt = []
for i in range(0, 10):
    start = time.time()
    inputFile = open("input.json", 'r')
    arrJ = js.load(inputFile)
    outputFile = open("outPut.txt", 'w')
    ans = []
    for i in arrJ:
        ans.append(str(i['username']) + ": " + str(i['password']))
    dict = {}
    dict["users"] = ans
    outputFile.write(str(dict))
    outputFile.close()
    inputFile.close()
    end = time.time()
    pyt.append(float(end - start))

# this code write the results to txt file
result = open("Python.txt", 'w')
result.write(str(pyt))
result.close()
process = psutil.Process(os.getpid())
print("memory used by bytes: ", process.memory_info().rss)

