// 구구단이 들어있는 2차원 배열을 만드시오.

// 구구단
// 1단
// 1*1 1*2 1*3 ... 1*9
// 2단 3단 ... 9단까지

// 1단 [1*1, 2*1, 3*1, ... , 9*1]
// 2단 [1*2, 2*2, 3*2, ... , 9*2]

// 1. 전체를 담을 수 있는 container
// 2. 1단을 1번에 2단을 2번에...
// 3. 1단을 어떻게 만들지? 2단을 어떻게 만들지?
// => 계산해서 새로운 컨테이너에 넣음
// 4. 새로운 컨테이너를 전체를 담는 컨테이너에 넣는다

const bigArrayMultiple = [];

for (let i = 1; i <= 9; i++) {
  let arrayMultiple = [];

  for (let j = 1; j <= 9; j++) {
    let num = i * j;
    arrayMultiple.push(num);
  }

  bigArrayMultiple.push(arrayMultiple);
}

console.log(bigArrayMultiple);

console.log();
// n*m 단이 들어있는 2차원 배열을 만드시오.

const n = 3;
const m = 4;

const bigArrayMultiple2 = [];

for (let i = 1; i <= n; i++) {
  let arrayMultiple = [];

  for (let j = 1; j <= m; j++) {
    let num = i * j;
    arrayMultiple.push(num);
  }

  bigArrayMultiple2.push(arrayMultiple);
}

console.log(bigArrayMultiple2);
