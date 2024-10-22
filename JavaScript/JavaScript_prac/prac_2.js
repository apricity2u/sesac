// 1

let number_1 = 3;
console.log(number_1);

if (number_1 < 10) {
  console.log('number_1은 10보다 작다.');
}

// 2

let number_2 = 4;
console.log(number_2);

if (number_2 % 2 === 0) {
  console.log('짝수');
}

// 3

let variable = 2;
console.log(variable);

// 자료형 확인 시 작은 따옴표 사이에 입력하기!
if (typeof variable === 'number') {
  console.log('숫자형');
}

// 4

let number_3 = 8;
console.log(number_3);

if (number_3 < 10) {
  console.log('number_3는 10보다 작다. ');
} else if (number_3 > 10) {
  console.log('number_3는 10보다 크다. ');
}

// 5

let score = 55;
console.log(score);

if (score >= 60) {
  console.log('합격');
} else {
  console.log('불합격');
}

// 6

let number_4 = 10;
console.log(number_4);

if (number_4 < 10) {
  console.log('number_4는 10보다 작다. ');
} else if (number_4 > 10) {
  console.log('number_4는 10보다 크다. ');
} else {
  console.log('number_4는 10이다. ');
}

// 7

let number_5 = '안녕';
console.log(number_5);

if (typeof number_5 === 'number') {
  if (number_5 < 10) {
    console.log('number_5는 10보다 작다. ');
  } else if (number_5 > 10) {
    console.log('number_5는 10보다 크다. ');
  } else {
    console.log('number_5는 10이다. ');
  }
} else {
  console.log('숫자가 아니다.');
}

// 8

let number_6 = 0;
console.log(number_6);

if (number_6 === 0) {
  console.log('영');
} else if (number_6 % 2 === 0) {
  console.log('짝수');
} else {
  console.log('홀수');
}

// 9
let username = 'sesac';
let password = 'sesac1234';

console.log(username);
console.log(password);

if (username === 'sesac' && password === 'sesac1234') {
  console.log('로그인 성공');
} else {
  console.log('로그인 실패');
}

// 10

let number_7 = 2;
let number_8 = 2;

console.log(number_7);
console.log(number_8);

if (number_7 > number_8) {
  console.log(number_7);
} else if (number_7 < number_8) {
  console.log(number_8);
} else {
  console.log('같다');
}

// 11

let number_9 = 3;

console.log(number_9);

if (number_9 % 2 === 0 && number_9 % 3 === 0) {
  console.log('6의 배수');
} else if (number_9 % 2 === 0) {
  console.log('2의 배수');
} else if (number_9 % 3 === 0) {
  console.log('3의 배수');
} else {
  console.log('2의 배수도 아니고, 3의 배수도 아니다.');
}