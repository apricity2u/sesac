// arr가 텅 빌 때까지 el를 출력하고 싶음.

// 1. el을 하나씩 제거한다.
// 2. el을 텅 비기 전까지는 계속 실행.
// 3. arr가 텅 비면 멈춤.

const arr = [2, 3, 5, 1, 3];

while (arr.length) {
  let el = arr.pop();
  console.log(el);
}

