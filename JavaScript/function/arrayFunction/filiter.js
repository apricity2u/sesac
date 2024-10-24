// x 가 함수에 들어가는지 아닌지를 판단하는 것

const numbers = [1, 2, 3, 4];

const evenNumbers = numbers.filter((num) => {
  return num % 2 === 0;
});

console.log(evenNumbers); // [2, 4]

// filter를 가지고 소수만 모아보기
const nums = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];

const isPrime = nums.filter((num) => {

    for (let i = 2; i < num; i++) {
      return num % i !== 0
    }
   
    return num
});

console.log(isPrime)