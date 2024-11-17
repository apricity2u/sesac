const arr1 = [1, 2, 3, 4, 5];
// 를 활용하여
// const newArr1 = [1, 4, 9, 16, 25];
// 를 만들어보자.

const newArr1 = arr1.map((el) => el**2)

console.log(newArr1)

/*
-함수로 따로 빼기-

function square(num) {
  return num ** 2
}

const newArr1 = arr1.map(square)

-비문-
const newArr1 = arr1.map(square())
함수가 아닌 함수의 결과값은 입력할 수 없다.
*/
