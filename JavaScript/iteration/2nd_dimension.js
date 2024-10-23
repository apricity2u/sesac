const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

// 1 ~ 9 까지 순서대로 출력해보자.

// nums[0][0] nums[0][1] nums[0][2]
// nums[1][0] nums[1][1] nums[1][2]
// nums[2][0] nums[2][1] nums[2][2]

for (const num_box of nums) {
  for (const num of num_box) {
    console.log(num);
  }
}

console.log();

for (let i in nums) {
  let arr = nums[i];
  for (let j in arr) {
    let num = arr[j];
    // console.log(num);
    // console.log(arr[j]);
    console.log(nums[i][j]);
  }
}

console.log();

const n = nums.length; // 행의 크기
const m = nums[0].length; // 열의 크기

for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    console.log(nums[i][j]);
  }
}

// 행들의 합의 값으로 리스트를 만드세요.

// nums[0][0] + nums[0][1] + nums[0][2]
// nums[1][0] + nums[1][1] + nums[1][2]
// nums[2][0] + nums[2][1] + nums[2][2]

console.log();

// 내 풀이

let arraySum = [];

for (let i = 0; i < n; i++) {
  let sum = 0;

  for (let j = 0; j < m; j++) {
    sum += nums[i][j];
  }

  arraySum.push(sum);
}

console.log(arraySum);

// 1. 배열을 만든다.
// 2. 각 원소의 합계를 만든다. (6, 15, 21)
// 3. 배열에 넣는다.

// 추가 풀이

console.log();

let result = [];

for (let arr of nums) {
  let sum = 0;
  for (let num of arr) {
    sum += num;
  }
  result.push(sum);
}

console.log(result);

console.log();
// 추가 풀이 lodash 사용

var _ = require('lodash');

const result2 = [];

for (let arr of nums) {
  result2.push(_.sum(arr));
}

console.log(result);

// 모든 원소들의 합을 구하시오

// nums[0][0] + nums[0][1] + nums[0][2]
// + nums[1][0] + nums[1][1] + nums[1][2]
// + nums[2][0] + nums[2][1] + nums[2][2]

console.log();

let total = 0;

for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    total += nums[i][j];
  }
}

console.log(total);

console.log();
// 추가풀이

let total2 = 0;

for (let arr of nums) {
  for (let num of arr) {
    total2 += num;
  }
}

console.log(total2);

console.log();

// 열들의 합의 값으로 리스트를 만드세요
// nums[i][j] 의 형태는 항상 유지할 예정.
// 헷갈리지 말라고

// const n = nums.length; // 행의 크기 (세로 (배열의 길이))
// const m = nums[0].length; // 열의 크기 (가로 (배열 안 배열의 길이))

const arrayColumnSum = [];

for (let j = 0; j < m; j++) {
  let column_sum = 0;

  for (let i = 0; i < n; i++) {
    column_sum += nums[i][j];
  }

  arrayColumnSum.push(column_sum);
}

console.log(arrayColumnSum);

console.log();
