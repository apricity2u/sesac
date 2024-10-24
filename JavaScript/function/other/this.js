// this 키워드

// 여기서 this는 전역 객체(global)를 가리킵니다.
console.log(this); // 출력값 : {}

// 일반 함수에서는 전역 객체를 가리킵니다.
function showThis() {
  console.log(this);
  // 브라우저 환경에서는 window 객체를 참조한다.
  // node.js 환경에서는 global 객체를 참조한다.
}

showThis(); // 출력값 : {}

// 메서드 내부의 this
// 점 앞의 객체가 무엇인지가 중요합니다.

const person = {
  name: '철수',
  greet() {
    console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
    // 안녕하세요. 저의 이름은 철수 입니다.
    // this는 객체 person을 참조한다.
  },
};

person.greet();