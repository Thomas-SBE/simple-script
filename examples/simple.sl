var x: int = 2;
var y: int = 3;
var result: bool;

function add(a: int, b: int): int => return a + b;

function main(): bool => {
    if(add(x, y) >= 2) => {
        result = true;
    } else => {
        result = false;
    }
    return result;
}