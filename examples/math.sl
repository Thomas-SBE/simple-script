var a: int[10] = [1,2,3,4,5,6,7,8,9,10];

for(var i:int = 0; i < 2; i++;) => for(var j: int = 0; j < 5; j++;) => a[(i*5)+j] = i;

print((a[6]*2));