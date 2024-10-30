// 2. 배열 원소 거꾸로 출력

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

for (let i = 0; i <= arr.length; i++) {
  console.log(arr[arr.length - i]);
}

// 배열의 길이 활용 '-'

for (let i = arr.length - 1; i >= 0; i--) {
  console.log(arr[i]);
}

// reverse 활용

for (let num of arr.reverse()) {
  console.log(num);
}
