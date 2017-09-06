import matplotlib.pyplot as plt

# This code for reading the execution results from the java.txt
with open("Java.txt") as javaFile:
    array = javaFile.read()
array = array[1:-1].split(', ')
javaResult = []
for i in array:
    javaResult.append(float(i))

# this code is for reading the execution results from the python.txt
with open("Python.txt") as pyFile:
    array = pyFile.read()
array = array[1:-1].split(', ')
pyResult = []
for i in array:
    pyResult.append(float(i))


# this is the code for creating the graph that compare between Java and Python (runtime) ---> OPEN_SOURCE
fig, (ax0, ax1) = plt.subplots(ncols=2, figsize=(8, 4))

ax0.hist(javaResult, bins = [0.000, 0.002, 0.004, 0.006, 0.008, 0.010, 0.012, 0.014], color='r')
ax0.set_title('Java')
ax0.grid(True)

# Create a histogram by providing the bin edges (unequally spaced).
ax1.hist(pyResult, bins = [0.000, 0.002, 0.004, 0.006, 0.008, 0.010, 0.012, 0.014], color='g')
ax1.set_title('Python')
ax1.grid(True)

fig.tight_layout()
plt.show()
