// x 가 함수에 들어가는지 아닌지를 판단하는 것
// 결국 boolean 값을 가집니다.

const numbers = [1, 2, 3, 4];

const evenNumbers = numbers.filter((num) => {
  return num % 2 === 0;
  // numbers 안에 있는 원소가 num % 2 === 0 을 충족하면
  // 새로운 배열에 해당 원소를 넣어줍니다.
});

console.log(evenNumbers); // [2, 4]

// filter를 가지고 소수만 모아보기
const nums = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17];

const checkPrime = nums.filter((num) => {
  let isPrime = true; // 처음 기본값을 소수라고 규정합니다.

  for (let i = 2; i < num; i++) {
    if (num % i === 0) {
      // 나누어떨어지면
      isPrime = false; // 소수가 아닙니다.
      return isPrime; // false를 출력합니다. -> 새로운 배열에 넣지 않습니다.
    }
  }

  return isPrime; // for 반복문에 나온 값들은 true 값을 가집니다. -> 새로운 배열에 들어갑니다.
});

console.log(checkPrime);
