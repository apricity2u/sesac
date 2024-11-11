const arr = [1, 2, 3];

const newArr1 = [arr];
const newArr2 = [...arr];

// console.log(newArr1);
// console.log(newArr2);

const obj = {
  x: 1,
  y: 2,
  z: 3,
};

// 객체에 key : value 복사
const newObj = { ...obj };
console.log(newObj);

// 객체에 key:value 추가
const newObj2 = { ...obj, a: 4 };
console.log(newObj2);

// 객체에 value 값 정정
const newObj3 = { ...obj, x: 100 };
newObj.x = 100;
console.log(newObj3);
