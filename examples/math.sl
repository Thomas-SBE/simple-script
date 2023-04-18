var result: int = 0;
function double(a:int):int => return a * 2;
for(var x: int = 0; x < 5; x++;) =>
    for(var y: int = 0; y < 5; y++;) => result++;
print(double(result));