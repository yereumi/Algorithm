def solution(num_list):
    reverse=[]
    for i in range(len(num_list)-1, -1, -1):
        reverse.append(num_list[i])
    return reverse