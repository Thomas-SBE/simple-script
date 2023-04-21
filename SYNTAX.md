### Simplescript language syntax

#### Available types:

```
int
bool
int[]
bool[]
```

#### Declaring variables:
```typescript
var a: bool;
var b: int = 2;
var c: int[5];
var d: bool[5] = [true, false, false, true, true];
```

#### Variable assignments:
```typescript
a = true;
b = 5;
c[2] = 5;
d[2] = true;
```

#### Conditionnal:
```typescript
if(a) => {} else => {}
if(a) => print(a); else => {}
```

#### Loops:
```typescript
while(a) => {}
while(a) => print(a);

for(var x : int = 0; x < 2; x++;) => {}
for(var x : int = 0; x < 2; x++;) => print(x);
```

#### Operations:
```typescript
a + b   [int + int]: int
a - b   [int - int]: int
a * b   [int * int]: int
a / b   [int * int]: int
a && b  [int / int]: int
a || b  [bool || bool]: bool
a < b   [int < int]: bool
a <= b  [int <= int]: bool
a > b   [int > int]: bool
a >= b  [int >= int]: bool
a == b  [int == int]: bool | [bool == bool]: bool
a != b  [int != int]: bool | [bool != bool]: bool

!a      [bool]: bool
-a      [int]: int
+a      [int]: int
```

#### Incrementation:
```typescript
a++;
a--;

if(a++ > 10) => {} else => {}

print(a++);
print(a--);
```

#### Operation embedding:
```typescript
if((a > 2) && (b > 2)) => {}
if((c[0] == c[1]) && (c[1] == c[2])) => print(c[0]);
```