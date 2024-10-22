// 6
// 2의 배수 혹은 3의 배수를 제외하고 1~30까지 숫자를 출력하시오.
// 1 5 7 11 13 17 19 23 25 29

for (let num = 1; num <= 30; num++) {
  if (!(num % 2)) continue;
  // if (num % 2 === 0) continue;

  if (!(num % 3)) continue;
  
  console.log(num);

}


for (let num = 1; num <= 30; num++) {
  // 2와 3으로 나누었을 때 나머지가 존재하면 2와 3의 배수가 아니다!
  // 2와 3의 배수였으면 나머지가 0이었을거니까!
  if (num % 2 && num % 3) { 
    console.log(num);
  }  
}

