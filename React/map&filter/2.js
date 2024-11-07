const arr2 = ["1", "2", "3", "4", "5"];
// 를 활용하여
// const newArr2 = [1, 2, 3, 4, 5];
// 를 만들어보자.

const newArr2 = arr2.map((el) => parseInt(el))

console.log(newArr2)