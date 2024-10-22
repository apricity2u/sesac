const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];

let sum = 0;

for (let index in nums) {
  sum += nums[index];
}

console.log(sum);


// 

// for (const num of nums) {
//   total += num;
// }