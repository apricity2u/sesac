// 8
//- 주어진 테이블의 데이터를 "people" 변수에 저장하시오.
let people = [
  {
    name: 'jun',
    age: 15,
    gender: 'M',
  },
  {
    name: 'ken',
    age: 26,
    gender: 'F',
  },
  {
    name: 'alex',
    age: 37,
    gender: null,
  },
];

//- 사람에 대한 정보를 각각 출력하시오(형식은 자유롭게)
for (let person of people) {
  // console.log(person)
  // 위에처럼 하면 object 형태로 출력됨
  for (let key in person) {
    let value = person[key];
    console.log(key, value);
    // 이렇게 하면 key & value 형태로 볼 수 있다
  }
}

console.log('---------------');

//- 이름이 alex인 사람에 대한 정보를 출력하시오
//people에 들어있는 사람 한 명씩 확인한다.
for (let person of people) {
  const name = person.name;
  // 확인한 사람의 이름이 alex인지 확인한다.
  if (name === 'alex') {
    console.log(person);
  }
}

console.log('---------------');

//- 이름이 alex인 사람의 나이를 출력하시오

for (let person of people) {
  const name = person.name;
  const age = person.age;

  if (name === 'alex') {
    console.log(age);
  }
}

console.log('---------------');

//- 이름을 활용하여 각 사람의 데이터에 쉽게 접근할 수 있도록 people 변수를 수정하시오.
// key 와 value 형태로 바꾸기

let newPeople = {};

for (let person of people) {
  const name = person.name;
  newPeople[name] = person;
}

console.log(newPeople);
