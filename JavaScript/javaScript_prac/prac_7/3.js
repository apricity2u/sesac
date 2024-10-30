// 3. 양수 출력
const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

for (let num of arr) {
  if (num > 0) {
    console.log(num);
  }
}

// forEach 사용하기

arr.forEach((num) => {
  if (num > 0) console.log(num);
});
