// 2. 1 ~ 100 중에 7의 배수의 개수를 출력하세요.

let cnt = 0;

for (let num = 1; num <= 100; num++) {
  if (num % 7 === 0) {
    cnt++;
  }
}

console.log(cnt);

let cnt2 = 0;
for (let num = 1; num <= 100; num++) {
  if (num % 7) continue; 
  // 7로 나눈 나머지가 0이 아니면! (= 7로 나누어 떨어지지 않으면!)
  // 반복문을 계속 돈다!
  cnt2++;  
}

console.log(cnt2);

// 7로 나눈 몫
let count = Math.floor(100 / 7);

console.log(count);
