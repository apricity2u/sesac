// 하고 싶은 것
// 1~9 까지의 숫자를 사용하고 싶다.

// 1. 초기값 설정
// 2. num을 하나씩 증가
// 3. num이 9가 되면 멈춤
// 4. 9가 되기 전까지는 계속 실행

// while -> 특정 조건에서 반복을 멈춥니다.

// while (true일 때 아래 코드를 실행 : condition) {
//   반복될 코드
// }

let num = 1;

while (num <= 9) {
  console.log(num);
  num++;
}

// 2, 4, 6, 8, 10 을 출력하고 싶다.
// while : 언제까지 쭉 반복해.

let num2 = 1;

while (num2 <= 5) {
  console.log(num2 * 2);
  num2++;
}

let num3 = 1;

while (true) {
  // 조건부가 true일 때
  console.log(num3);
  num3 += 2;

  // 10일 때 멈춰.
  if (num3 === 10) {
    break;
  }
}

// 어떤 걸 반복하고 싶은가?

// while :
// condition이 true이면 계속 진행
// condition이 false이면 멈춰.
// condition에는 반드시 변수가 필요함
// -> conition이 언젠가 바뀌어야 하기 때문에
// while문의 body안에서 변수가 바뀌고, 바뀌면서 언젠가는 false로 변함
