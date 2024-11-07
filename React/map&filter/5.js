const arr5 = [
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
  {
    name: "beemo",
    age: 48,
  },
  {
    name: "lynda",
    age: 8,
  },
];
// 를 활용하여
// age가 30 이하인 사람들의 정보가 담긴 array를 만들어보자.

// 를 활용하여
// age가 30 이하인 사람들의 이름이 담긴 array를 만들어보자.


const newArr6 = arr5.filter((el) => el.age <= 30)
console.log(newArr6)

const newArr7 = newArr6.map((el) => el.name)
console.log(newArr7)

// const newArr6 = arr5.filter((el) => el.age <= 30).map((el) => el.name)