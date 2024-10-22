// 5

// 두개의 숫자에 대해.
// 두 수 사이에 속한 모든 정수의 합을 구하시오.
// (ex. 2와 5를 입력받는다면 2 + 3 + 4 + 5 = 14)

let a = 5;
let b = 2;

if (a > b) {
  let tmp = a;
  a = b;
  b = tmp;
}

let sum = 0;

while (a !== b + 1) {
  sum += a;
  a++;
}

console.log(sum);

//

let num1 = 5
let num2 = 2

// num1이 num2보다 크다는 조건이 없음!
// 그러면 어떻게 해야할까?
if (num1 > num2) {
  // num1의 값을 임시로 저장
  let tmp = num1
  // num2의 값을 num1에 넣고
  num1 = num2;
  // num2에 num1의 예전 값을 넣습니다.
  num2 = tmp;
}

let total = 0

for (let num = num1; num <= num2; num++) {
  total += num;
}

console.log(total);
