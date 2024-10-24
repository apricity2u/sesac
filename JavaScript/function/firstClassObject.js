// 콜백함수와 일급객체

const applyOperation = (func, number) => {
  return func(number);
};

const double = (x) => x * 2; // 10
const triple = (x) => x * 3;
const quadra = (x) => x * 4;

console.log(applyOperation(double, 5));

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
