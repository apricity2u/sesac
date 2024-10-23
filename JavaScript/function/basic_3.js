// 함수 선언식
// 선언부가 끌어올려지는 호이스팅 발생
// 이런 호이스팅은 괜찮을지도...? (프로젝트 내에서는 통일!)

// console.log(add(2, 4))

function add(x, y) {
  return x + y;
}

// 함수 표현식
// 익명함수가 add2에 할당되며, const와 같은 효력
// add2 에 새로운 함수를 할당할 수 없음

const add2 = function (x, y) {
  return x + y;
};

// 화살표 함수
// 장점 : this에 대한 바인딩이 없음 (나중에!)

const add3 = (x, y) => {
  return x + y;
};


// 객체는 value 값으로 함수도 가질 수 있다. (함수가 일급 객체이기 때문)

const person = {
  name: '철수',
  greet: function () {
      console.log('안녕하세요. 반갑습니다.');
  },
  // greet를 축약한 방식이 greet2
  greet2() {
    console.log('안녕하세요. 반갑습니다.');
    console.log(`${this.name}`) // this는 나 (객체)
},
};

person.greet();
person.greet2();