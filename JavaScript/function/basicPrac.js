// 1. 2를 곱하는 함수를 만들어보자

function multipleTwo(num) {
  let multipleTwoNum = num * 2;

  return multipleTwoNum;
}

console.log(multipleTwo(3));

// 2. 소수를 판별하는 함수를 만들어보자

function checkPrime(num) {
  let isPrime = true;

  for (i = 2; i < num; i++) {
    if (num % i === 0) {
      isPrime = false;
      return isPrime; // 함수의 기능을 끝내기 위해 return 을 입력
      // 이렇게 해도 문제가 없음..!
    }
  }

  return isPrime;
}

console.log(checkPrime(4));

// 3. 구구단 중 n단을 return하는 함수를 만들어보자.

function nDan(n) {
  const bigArrayMultiple = [];

  for (let i = 1; i <= 9; i++) {
    let arrayMultiple = [];

    for (let j = 1; j <= 9; j++) {
      let num = i * j;
      arrayMultiple.push(num);
    }

    bigArrayMultiple.push(arrayMultiple);
  }

  return bigArrayMultiple[n - 1];
}

console.log(nDan(9));

console.log();

// nDan 함수를 활용해서 구구단 만들기
const gugudan = [];

for (let i = 1; i <= 9; i++) {
  gugudan.push(nDan(i));
}

console.log(gugudan);
