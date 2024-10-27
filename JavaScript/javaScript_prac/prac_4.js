// 1

let a = 5;

console.log(a);

for (let i=1; i <= a; i++) {
  console.log(i)
}


console.log('-----------------')
// 2

let b = 5;

console.log(b);

let num = 1

while (num <= b) {
  console.log(num)
  num++;
}


console.log('-----------------')
// 3

let c = 5;
let total = 0;

console.log(c);

for (let i = 1; i <= 5; i++) {
  total += i;
}

console.log(total)


console.log('-----------------')
// 4


let d = 5;
total = 0;

console.log(d)

for (let i = 1; i <= 5; i++) {
  if (!(i % 2)) {
    total += i
  }
}

console.log(total)

console.log('-----------------')
// 5

let e = 5;
let cnt = 0;

console.log(e)

for (let i = 1; i <= e; i++) {
  if (!(i % 2)) {
    cnt++
  }
}

console.log(cnt)


console.log('-----------------')
// 6

const arr = [1, 9, 3, 11, 4, 5, 2, 7]

for (let num2 of arr) {
  if (!(num2 % 2)) break

  console.log(num2)
}

