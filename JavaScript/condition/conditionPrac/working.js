// 주말일과
// 주말 일과시간 무엇을하는지?
//  T       F     자기개발
//  T       T       휴식
//  F       T        일
//  F       F       휴식

const isWeekend = false;
const nowTime = 18;

if (isWeekend) {
  if (nowTime <= 18 && nowTime >= 9) {
    console.log('휴식');
  } else {
    console.log('자기개발');
  }
} else {
  if (nowTime <= 18 && nowTime >= 9) {
    console.log('일');
  } else {
    console.log('휴식');
  }
}

// -----------------------
// 새로운 변수를 만드는 방법!

let isWorkingHour;

if (nowTime >= 9 && nowTime <= 18) {
  isWorkingHour = true;
} else {
  isWorkingHour = false;
}

// let workinghour = (nowTime >= 9 && nowTime <= 18) ? true : false

if (isWeekend) {
  if (isWorkingHour) {
    console.log('휴식');
    // let todo 를 선언해서 정리하는게 나음..!
    // '휴식'이 겹치기 때문에 새로운 변수로 만들어도 됨
  } else {
    console.log('자기개발');
  }
} else {
  if (isWorkingHour) {
    console.log('일');
  } else {
    console.log('휴식');
  }
}

// xor 로도 표현 가능

// xor(isWeekend, isWorkingHour)

// function xor(x, y){
//   return xor에 대한 코드
// }
