m, n = map(int, input().strip().split())
dray = [[0] * n] * m
for i in range(m):
    line = input().strip().split()
    lis = list(map(int, line))
    print(line)
    for j in range(n):
        dray[i][j] = lis[j]
print(dray)