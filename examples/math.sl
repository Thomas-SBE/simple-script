var result: int = 0;

function fact(a: int): int => {
    if(a <= 0) => return 1;
    else => return a * fact(a-1);
}

result = fact(5);