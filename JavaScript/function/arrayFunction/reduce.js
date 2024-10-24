// reduce 는 순차적으로 누적하여 하나의 값으로 반환합니다

const nums = [1, 2, 3, 4, 5, 6, 7];

// accumulator : 누적값
// currentValue : 배열 원소 값
const mulNums = nums.reduce((acc, cur) => {
  console.log(acc, cur);
  return acc * cur;
}, 1); // 여기서 1은 초기 값을 뜻합니다. (초기값은 지정할 수 있습니다.)

// 누적값 초기값
// 1 1
// 1 2
// 2 3
// 6 4
// 24 5
// 120 6
// 720 7

console.log(mulNums);
//

// minValue를 reduce를 통해 계산하시오.
const numbers = [5, 8, 2, 5, 9, 4];

const minValue = numbers.reduce((acc, cur) => {
  if (acc > cur) {
    acc = cur;
  }
  return acc;
}, Infinity);

console.log(minValue);

//삼항 연산자로 표현하는 방법

const minValue2 = numbers.reduce(
  (acc, cur) => (acc > cur ? cur : acc),
  Infinity
);
// {}, return 생략
// 삼항 연산자 겉에 소괄호는 프리티어가 해준겁니다..!

console.log(minValue2);
