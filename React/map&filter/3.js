const arr3 = [
  {
    name: "jun",
    age: 18,
  },
  {
    name: "alex",
    age: 28,
  },
  {
    name: "ken",
    age: 38,
  },
];
// 를 활용하여
// const newArr3 = [18, 28, 38];
// 를 만들어보자.

const newArr3 = arr3.map((el) => el.age)

console.log(newArr3)