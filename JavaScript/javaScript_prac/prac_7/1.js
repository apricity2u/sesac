// 1. 배열 원소 출력
const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

// 첫번째 방법
arr.forEach((num) => {
  console.log(num);
});

console.log();

// 두번째 방법
for (let num of arr) {
  console.log(num);
}

console.log();

// 세번째 방법
for (let index = 0; index < 13; index++) {
  console.log(arr[index]);
}
