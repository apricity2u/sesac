const names = ['jun', 'beemo', 'ken', 'lynda'];

for (let index in names) {
  let my_name = names[index];
  index++; // 숫자일 때만 사용 가능한 연산자 ++
  console.log(`${index}번 ${my_name}`);
}

// 반복문은 변수를 할당
// 변수는 그저 변수일 뿐이라 변경 가능하다 (const여도 바뀜)

// index = index + 1 안되는 이유
// 자바스크립트는 '1' + 1 오류가 나타나지 않고, 11 출력
