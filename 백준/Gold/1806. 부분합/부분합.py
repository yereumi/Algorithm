import sys

N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
arr_sum = [0]
arr_len = []

for i in range(N):
    arr_sum.append(arr_sum[i]+arr[i])
#print(arr_sum)

s = 0
e = 0

while True:
    if s > N or e > N:
        break
    if arr_sum[e]-arr_sum[s] >= S:
        arr_len.append(e-s)
        s += 1
    else:
        e += 1

if len(arr_len) != 0:
    print(min(arr_len))
else:
    print(0)
