var a: int = 10;

function double(a: int): int => return 2 * a;

var b: int = a;
while(b < 100) => {
    if(b / 2 > 50) => b = double(a);
    else => b = double(double(a));
}