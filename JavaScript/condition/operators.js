// << 논리연산자 >>

let water = true;
let milk = false;

// && and 연산자
console.log(water === true && milk === true);

// || or 연산자
console.log(water === true || milk === true);

// ! not 연산자
console.log(!water);

let money = 10000;
let hungry = 100;

// 돈이 1000원보다 많으면 돈이 충분하다
console.log(money > 1000);

// 배고픔이 50보다 많으면 배고픈 것
console.log(hungry > 50);

// && and 연산자 => 돈이 충분하고 배가 고픈 것
console.log(money > 1000 && hungry > 50);

// 돈이 충분하지만 배가 고프지 않은 것
console.log(money > 1000 && hungry > 200);

// << 사칙연산자 >>

let a = 3;
let b = 4;

console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(a / b); // 나눗셈
console.log(a % b); // 나머지
console.log(a ** b); // 거듭제곱
console.log(Math.floor(a / b)); // 몫

a++;
console.log(a); // 변수 +1

a--;
console.log(a); // 변수 -1

console.log(++a); // 더하고 출력
console.log(a++); // 출력하고 더하기

// << 할당연산자 >>

console.log((b += 2)); // 6

b = 4;
console.log((b -= 2)); // 2

b = 4;
console.log((b *= 2)); // 8

b = 4;
console.log((b /= 2)); // 2

b = 4;
console.log((b %= 2)); // 0

// << 비교연산자 >>

console.log(a > b); // true
console.log(a < b); // false
console.log(a === b); // false

// << 타입연산자 >>

console.log(typeof a);
console.log(typeof 'Hello');
console.log(water);

let num = NaN; // Not a Number
console.log(typeof num);

num = 100;
console.log(num);

let zero = null;
console.log(typeof zero);
