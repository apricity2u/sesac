// 1 더하기 함수

function add(x1, x2) {
  let addNum = x1 + x2;

  return addNum;
}

let num1 = 2;
let num2 = 5;

console.log(num1);
console.log(num2);
console.log(add(num1, num2));

console.log();
// 2 크기 비교 함수

function compare(x1, x2) {
  if (x1 > x2) {
    return x1;
  } else if (x1 < x2) {
    return x2;
  } else {
    return null;
  }
}

let num3 = 3;
let num4 = 3;

console.log(num3);
console.log(num4);
console.log(compare(num3, num4));

console.log();
// 3 양수, 음수, 0

function determine(x) {
  if (x > 0) {
    return 1;
  } else if (x < 0) {
    return -1;
  } else {
    return 0;
  }
}

let num5 = -10;
console.log(num5);
console.log(determine(num5));

console.log();
// 4 가장 큰 값

function maxNumber(arr) {
  let max = -Infinity;

  for (let num of arr) {
    if (num > max) {
      max = num;
    }
  }

  return max;
}

const maxArray = [10, 25, 36, 99, 58];
console.log(maxArray);
console.log(maxNumber(maxArray));

console.log();
// 5 가장 작은 값

function minNumber(arr) {
  let min = Infinity;

  for (let num of arr) {
    if (num < min) {
      min = num;
    }
  }

  return min;
}

const minArray = [10, 25, 36, 99, 58];
console.log(minArray);
console.log(minNumber(minArray));

console.log();
// 6 짝수

function evenNumber(arr) {
  let new_arr = [];

  for (let num of arr) {
    if (!(num % 2)) {
      new_arr.push(num);
    }
  }

  return new_arr;
}

const evenArray = [10, 25, 36, 99, 58];
console.log(evenArray);
console.log(evenNumber(evenArray));
