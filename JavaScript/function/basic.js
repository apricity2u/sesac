// function 함수이름(입력값) {
//   입력값을 사용한 기능

//   return 출력값
// }

// *** 숫자를 입력 받아서, 1을 더하는 기능을 만들고 싶어요 ***

function plusOne(num) {
  // 매개변수 num
  let plusOneNumber = num + 1;

  return plusOneNumber;
}

let x = 10; // y -> 11
let y = plusOne(x); // 인자 x : 10

console.log(y);
