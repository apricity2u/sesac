const nums = [10, 6, 8, 5, 4, 2, 3, 11];

// let minNum = Infinity;
let minNum = nums[0];

for (let index in nums) {
  if (minNum > nums[index]) {
    minNum = nums[index];
  }
}

console.log(minNum);

// const nums = [];
// 최솟값 불가능하다는 오류 핸들링을 해줘야함

let maxNum = -Infinity;

for (let num of nums) {
  if (maxNum < num) {
    maxNum = num;
  }
}

console.log(maxNum);