// function 함수이름(매개변수) {
//   입력값을 사용한 기능

//   return 출력값
// }

// a, b 두개를 더하는 함수를 만든다.

function add(a, b) {
  return a+b;
}

console.log(add(1,2));
console.log(add(a=4, b=10))

// 기본값 설정

function greet(name = "Guest") {
  // "Guest 라는 기본값"
  console.log(`안녕하세요, ${name}님!`);
}

greet(); // 안녕하세요, ${Guest}님!

// 나머지 매개변수
// ... 사용 : array처럼 만들어줌

function greetAll(...names) {
  for (name of names){
      console.log(`안녕하세요, ${name}님!`);
  }
}

greet("철수", "영희"); 

// ????
// // function sum(...nums) {
//   console.log(nums);
// }

// sum(1,2,3,4)


// 가변 길이 인자 지원
// 인자를 매개변수보다 많이 받으면, 매개변수만큼만 받고 오류 안남

function greet(name) {
  console.log(`안녕하세요, ${name}님!`);
}

greet("철수", "영희"); // 오류 없이 실행