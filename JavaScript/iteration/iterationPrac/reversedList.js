const nums = [10, 6, 8, 5, 4];

const reversedNums = [];

// 1
for (let num of nums) {
  reversedNums.unshift(num);
}

console.log(reversedNums);

// 2
const reversedNums2 = [];

for (let index in nums) {
  let newIndex = nums.length - 1;
  let newValue = nums[newIndex];
  reversedNums2.push(newValue);
}

console.log(reversedNums2);
