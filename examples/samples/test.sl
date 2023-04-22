function fact(a: int): int => {
    if(a <= 1) => return 1;
    else => return a * fact(a-1);
}

print(fact(5) * 2);