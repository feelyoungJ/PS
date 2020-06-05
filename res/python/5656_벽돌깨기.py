from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


def bomb(w):
    global H, board

    stack = []
    for i in range(H):
        if board[i][w]!=0:
            stack.append([i, w, board[i][w]])
            break
    
    while stack:
        s = stack.pop()
        board[s[0]][s[1]] = 0
        for i in range(4):
            for j in range(1, s[2]):
                ny = s[0] + dy[i] * j
                nx = s[1] + dx[i] * j
                
                if 0<=ny<H and 0<=nx<W:
                    if board[ny][nx] > 1:
                        stack.append([ny, nx, board[ny][nx]])
                    board[ny][nx] = 0
                    
def down():
    global board

    rot_board = []
    for b in zip(*board):
        tmp = [0 for _ in range(H)]
        h = H - 1
        for block in reversed(b):
            if block>0:
                tmp[h] = block
                h -= 1
        
        rot_board.append(tmp)

    board = [list(z) for z in zip(*rot_board)]
    

def dfs(n, tmp):
    global N, board, result, comb
    if result==0:
        return
    
    if n==N:
        tmp = [b[:] for b in board]
        
        for c in comb:
            bomb(c)
            down()
            
        count = 0
        for b in board:
            #print(b)
            for block in b:
                if block>0:
                    count += 1
        result = min(result, count)
        board = tmp
        
        return
        
    for i in range(W):
        comb[n] = i
        dfs(n+1, tmp)        
        
        

    
T = int(input())

for tc in range(1, T+1):
    N, W, H = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(H)]
    comb = [-1 for _ in range(N)]
    
    result = float("inf")
    dfs(0, board)
    print("#%s %s" % (tc, result))
