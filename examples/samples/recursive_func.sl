function fact(a: int): int => {
    if(a <= 1) => return 1;
    else => return a * fact(a-1);
}

var result: int = fact(5);

print(result * 2);