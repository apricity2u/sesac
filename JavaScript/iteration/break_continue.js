// break 반복을 멈춘다.

for (let i = 0; i < 10; i = i + 2) {
  console.log(i);

  if (i === 6) {
    break; // break를 사용할 때 {} 생략 가능
  }
}

console.log('------------------')

// continue 아래 코드를 무시하고 다음 반복을 실행

for (let a = 0; a < 10; a++) {
  if (a % 2 !== 0) { // 나머지가 존재하면
    continue;         // 아래 코드 실행하지 말고 다음 반복으로 넘어가
  } 

  console.log(a)
} 