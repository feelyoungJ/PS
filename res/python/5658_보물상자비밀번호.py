T = int(input())

def int16(x):
    return int(x, 16)

for t in range(1, T+1):
    N, K = map(int, input().split())
    number =  input()

    p_length = int(N/4)

    passwords = []

    for j in range(p_length):
        for i in range(4):
            passwords.append(number[p_length*i:p_length*i+p_length])
        number = number[1:] + number[0]

    passwords = set(passwords)
    passwords = list(map(int16, passwords))
    passwords.sort(reverse=True)

    print("#" + str(t) + " " + str(passwords[K-1]))
    



