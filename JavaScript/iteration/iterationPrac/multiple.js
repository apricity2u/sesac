const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]

// 모든 object를 담을 수 있음

for (let index in nums) {
  const num = nums[index];
  console.log(` 3 * ${num} = ${3 * num}`);
}

console.log('--------------------')

// value 값만 가져올 때 사용 (iterable object만 가능)
// array, string, set
// 키 값을 활용하는 것이 아니라,바로 value로 접근 가능

for (let num of nums) {
  console.log(` 3 * ${num} = ${3 * num}`);
}