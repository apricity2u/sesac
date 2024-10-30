// 4. 새로운 배열 만들기
const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

const evenArr = arr.filter((num) => num > 0 && num % 2 === 0);

console.log(evenArr);
