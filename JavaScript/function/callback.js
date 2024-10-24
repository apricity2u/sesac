// 콜백함수와 일급객체

function add(x, y) {
  return x + y;
}

const value = add(1, 2);
console.log(value);

//
const func = add;

const value2 = func(1, 2); // add(1,2)에 넣은 것과 같다
console.log(value2); // 3


// 몰라도 됨

const applyOperation = (func, number) => {
  return func(number);
};

const double = (x) => x * 2; // 10
const triple = (x) => x * 3; // 15
const quadra = (x) => x * 4; // 20

console.log(applyOperation(double, 5)); // 10

///// 한 번에 여러 개의 함수의 결과값을 반환할 수 있습니다.
// 1. 함수를 담는 array를 만들어줍니다.
// 2. for ... of 반복문을 활용합니다.
// 3-1. applyOperation(double, 5) -> 10 출력
// 3-2. applyOperation(triple, 5) -> 15 출력
// 3-3. applyOperation(quadra, 5) -> 20 출력

const functions = [double, triple, quadra];

for (let func of functions) {
  const result = applyOperation(func, 5);
  console.log(result);
}

// 10, 15, 20

console.log();

const makeMultiplier = (n) => {
  return (x) => x * n;
};

const doubleNumber = makeMultiplier(2); // x * 2 
const tripleNumber = makeMultiplier(3); // x * 3

console.log(doubleNumber(5)); // 결과: 10
console.log(tripleNumber(5)); // 결과: 15