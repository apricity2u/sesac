// 5. 배열 원소의 곱

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

let multiple = 1;

for (let num of arr) {
  multiple *= num;
}

console.log(multiple);


// reduce 함수 사용

const product = arr.reduce((acc, cur) => acc * cur, 1)

console.log(product)