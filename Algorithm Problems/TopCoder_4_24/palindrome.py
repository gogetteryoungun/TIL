def ans(inp):
    inp_rev = inp[::-1]
    for i in range(len(inp)-1):
        if inp[i:] == inp_rev[:len(inp)-i]:
            if i==0:return (len(inp), 'is palindrome already')
            return (len(inp)+i, inp + inp_rev[len(inp)-i:])
    return (len(inp)*2-1, 'all letters are different')
print ans('abcccc')
