let num = 20;

// 나머지의 존재 유무
if (!(num % 2)) {
  console.log('짝수');
} else {
  console.log('홀수');
}

// 나머지가 0이 아닐 때

if (num % 2 != 0) {
  console.log('홀수');
} else {
  console.log('짝수');
}

// status 라는 새로운 변수를 설정

const number = 20;
let num_status;

if (number % 2) {
  num_status = '홀수';
} else {
  num_status = '짝수';
}

console.log(num_status);

// 삼항연산자 condition ? true : false

let num_status2 = number % 2 ? '홀수' : '짝수';