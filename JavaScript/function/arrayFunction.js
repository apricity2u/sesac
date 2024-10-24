const numbers = [1, 2, 3, 4];

console.log('일반적인 사용법');
// 콜백함수에 요소를 인풋하는 역할만 함

numbers.forEach(
  // forEach를 사용하려면 numbers가 배열이어야함
  (num) => {
    // 화살표 함수 사용 - num 을 입력하면 (여기서 num은 array 안에 있는 요소)
    console.log(num); // num 을 출력한다. => 1, 2, 3, 4
  }
);

console.log('위의 코드를 분해한 코드');

const numPrint = (num) => {
  // 화살표함수 사용 numPrint라는 함수는 num 을 입력하면 num을 출력한다.
  console.log(num);
};

numbers.forEach(numPrint); // 인자 값으로 함수가 들어감.
// numPrint라는 함수가 작동됨
// numPrint는 매개변수 num에 인자값을 넣으면 num을 출력한다.
// num에 넣을 인자값은 뭔데? num은 array 안에 있는 요소들을 인자값으로 받는다

// numbers.forEach(
//   numPrint() // 괄호가 있으면 실행이 되기 때문에 undefined가 뜸
// )

console.log('forEach는 아래 코드와 같은 의미.');

console.log(
  'array에서 직접 실행 가능한 메서드 => array를 입력 받는 함수로 변경된 코드'
);
function myForEach(arr, func) {
  for (let value of arr) {
    func(value);
  }
}

myForEach([1, 2, 3, 4], numPrint); // [1,2,3,4] 는 arr & numPrint는 함수

console.log('콜백함수의 function자리 input값으로 call이 들어가면 안됨');

// numbers.forEach();
// numPrint() // 괄호가 있으면 함수의 결과값을 넘기는 것
              // numPrint의 return 값이 없기 때문에 에러가 뜸
