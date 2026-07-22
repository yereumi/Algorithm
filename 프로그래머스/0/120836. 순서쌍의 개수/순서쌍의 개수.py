def solution(n):
    cnt = 1
    for i in range(1, n//2+1):
        if n%i==0:
            cnt += 1
    return cnt