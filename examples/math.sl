var a: int[10] = [1,2,3,4,0,6,7,8,9,10];
var b: bool = false;

for(var x:int = 0; x < 10; x++;) => if(a[x] == 5) => b = true;

print(b);