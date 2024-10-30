// 7. x보다 큰 값만 모인 배열

const x = 5;
console.log(x);

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

const new_arr = arr.filter((num) => num > 5);

console.log(new_arr);
