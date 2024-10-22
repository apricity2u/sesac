const names = ['jun', 'beemo', 'lynda'];
//              0         1       2

// index로 접근
console.log(names[0]);

// push로 원소 추가
names.push('ken');

console.log(names);

// pop으로 원소 삭제
let popped_el = names.pop();
console.log(popped_el);
console.log(names);

// slice를 통해 index에 따라 자른 새로운 array 생성
const numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8];

console.log(numbers.slice(2, 4));
console.log(numbers.slice(4, 7));

// object
let person = {
  name: 'beemo',
  age: 27,
  handsome: true,
};

console.log(person['name']);
console.log(person.name);

// const는 할당을 금지한 것. 참조된 상태에서 값을 변경하는 것은 가능
const names_2 = ['jun', 'beemo', 'ken'];
names_2.push('lynda');

console.log(names_2);
// names_2 = [1, 2, 3]; //불가능

const names_3 = ['jun', 'beemo', 'ken'];
console.log(names_3[0]);

names_3[0] = 'haha';

console.log(names_3);
// ************************************************************
// names_3와 names_4는 같은 주소를 가리킴
let names_4 = names_3;
console.log(names_4);

names_3[1] = 'hoho';
console.log(names_4); // ['jun', 'hoho', 'ken']
