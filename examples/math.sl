var score: int = 1;
var iterations: int = 0;
var target: int = 512;

function double(a: int): int => return a * 2;

while(score < target) => {
    score = double(score);
    iterations++;
}