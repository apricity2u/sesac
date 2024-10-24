// 논리 연산자에서, 
// 해당 값이 정확히 무엇인지 판단할 수 있을 때의 값이 반환된다.
// T 인지 F 인지를 인지한 순간의 값을 출력

console.log(1 || 2); // 1
console.log(3 || 2); // 3
console.log(0 || 2); // 2

console.log(1 && 2); // 2
console.log(0 && 2); // 0
console.log(2 && 0); // 0

// OR 논리연사자 || 과 비교

let number = 0;
let defaultNumber = 10;

let resultOr = number || defaultNumber; // 0은 false로 평가되어 기본값 적용 O 
console.log(resultOr); // 10

let resultNullish = number ?? defaultNumber; 
// 0은 nullish가 아니므로 기본값 적용 X
// 결국 null이나 undefined가 아니기 때문에 기본값 적용 안함
console.log(resultNullish); // 0

// 옵셔널 체이닝과 Nullish 병합 연산자 활용

const user = {
  name: '홍길동',
  address: {},
};

let defaultCity = '서울';

let city = user?.address?.city ?? defaultCity;
// user -> address -> 속성 city가 없기 때문에 undefined 반환
// undefined에 대해 기본값 적용

console.log(city);
