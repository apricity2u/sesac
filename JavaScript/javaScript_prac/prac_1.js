// 1

let let_variable = 'Hello World';
const const_variable = 'Hello World';

console.log(let_variable);
console.log(const_variable);

// 2

let number_variable = 1;
let string_variable = '1';

console.log(typeof number_variable);
console.log(typeof string_variable);

// 3

let variable = '상수형 변수에는 재할당 할 수 없다.';
variable = '재할당';
console.log(variable);

// 4

let name = '박하은';
let hello = `안녕하세요. ${name}입니다.`;
console.log(hello);

// 5

let number1 = 100;
let number2 = 200;

console.log('덧셈:', number1 + number2);
console.log('뺄셈:', number1 - number2);
console.log('곱셈:', number1 * number2);
console.log('나눗셈:', number1 / number2);

// 6

let number3 = 2;
let number4 = 1;

console.log('number3를 2로 나눈 나머지:', number3 % 2);
console.log('number4를 2로 나눈 나머지:', number4 % 2);

// 7

let number_arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

console.log(number_arr[0]);
console.log(number_arr[2]);
console.log(number_arr[8]);
console.log(number_arr[9]);

// 8

let arr = [];

arr.push(10);
arr.push(20);
arr.push(30);
arr.push(40);
arr.push(50);

console.log(arr);

// 9

let todo = {
  userId: 1,
  id: 1,
  title: 'delectus aut autem',
  completed: false,
};

console.log(todo.userId);
console.log(todo.id);
console.log(todo.title);
console.log(todo.completed);

// 10

let person = {
  name_2: '박하은',
  age: 20,
  city: '서울',
  location: '성동',
  language: ['HTML', 'CSS', 'JavaScript'],
};

console.log(person);
