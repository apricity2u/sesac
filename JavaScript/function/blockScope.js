let value;
// 가장 밖에서 선언을 해야 for, if 안에서 값을 변경할 수 있음
// 나랑 가장 가까운 것부터 접근

if (true) {
  value = 123;
} else {
  value = 456;
}

console.log(value);

console.log();

let outerValue = '밖';

function func() {
  let outerValue = '안';
  console.log(outerValue);
}

func(); // 안
console.log(outerValue); // 밖

console.log();

// global 환경에 변수 선언 -> 블럭 안에서 사용

const const_1 = 'const_1';
let let_1 = 'let_1';

{
  console.log(const_1);
  console.log(let_1);
}

// global 환경에 변수 선언 -> 블럭 안에서 변경

{
  const const_2 = 'const_2';
  let let_2 = 'let_2';
}

// console.log(const_2) // 불가능
// console.log(let_2) // 불가능

// global 환경에 변수 선언 -> 블럭 안에서 사용 -> global에서 사용

const const_3 = 'const_3_outer';
let let_3 = 'let_3_outer';

{
  const const_3 = 'const_3_inner'; // 가능
  let let_3 = 'let_3_inner'; // 가능
}

console.log(const_3); // outer
console.log(let_3); // outer

console.log();

let let_4 = 'let_4_outer';

{
  let_4 = 'let_4_inner'; // let_4의 값 재할당
  console.log(let_4); // inner
}

console.log(let_4); // inner

console.log()


for (let i = 0; i < 3; i++) {
  const value = i // 각자 공간에 value 가 있어서 const 가능
  console.log(value)
}