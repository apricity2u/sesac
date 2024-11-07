const arr4 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
// 를 활용하여
// 짝수만 들어있는 array를 만들어보자.

// 짝수이면서 5이상인 숫자만 들어있는 array를 만들어보자.

const newArr4 = arr4.filter((el) => !(el % 2))
console.log(newArr4)

const newArr5 = arr4.filter((el) => !(el % 2) && el >= 5)
console.log(newArr5)

// const newArr5 = newArr4.filter((el) => el >= 5)

// method를 중첩하여 사용할 수 있다
// const newArr4 = arr4.filter((el) => !(el % 2)).filter((el) => el >= 5)