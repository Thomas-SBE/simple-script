var x: int = 2;
var y: int = -3;
var result: bool;

function add(a: int, b: int): int => return a + b;

if(add(x, y) >= 2) => {
    result = true;
    x = y;
    x++;
} else => {
    result = false;
}