var res: int = 0;

for(var x:int = 0; x < 5; x++;) =>
    for(var y:int = 0; y < 2; y++;) =>
        res = res+1;

print(res);