import sys

N = int(sys.stdin.readline())
num = [i for i in range(N + 1)]

M = int(sys.stdin.readline())

city = [[0] * (N + 1)]
for _ in range(N):
    city.append([0] + list(map(int, sys.stdin.readline().split())))

plan = list(map(int, sys.stdin.readline().split()))

def union(i, j):
    if (find(i) != find(j)):
        num[find(j)] = find(i)

def find(i):
    if (i == num[i]):
        return i
    else:
        num[i] = find(num[i])
        return num[i]

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if (city[i][j] == 1):
            union(i, j)

check = True
for i in range(1, len(plan)):
    if (find(plan[0]) != find(plan[i])):
        check = False
        break

if (check):
    print('YES')
else:
    print('NO')