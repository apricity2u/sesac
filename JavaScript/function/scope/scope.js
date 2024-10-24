// let, const - block scope {} 안에서 사용

if (true) {
  let value = 100;
  console,log(value) // 블록 안에서만 사용 가능함
}

// 사용 불가능함
//console.log(value); 

for (let i = 0; i < 3; i++) {
  let value2 = 123;
}

{
  let value3 = 123
}

// 블록 밖에서 value 값 사용 불가


const outerValue = '밖에 있는 값'

if (true) {
  console.log(outerValue) // 가능
  // const outerValue // 불가능
  const innerValue = '안에 있는 값'
}

const innerValue = '밖에 있는 값' // 가능
console.log(innerValue)