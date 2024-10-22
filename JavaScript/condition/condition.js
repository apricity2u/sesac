let money = 10000;

if (money > 1000) {
  // 소괄호 안에는 condition (T F)
  console.log('충분한 돈이 있어'); // condition이 true일 때 실행
}

money = 100;

if (money > 1000) {
  console.log('충분한 돈이 있어');
} else {
  console.log('충분한 돈이 없어'); // conition이 false일 때 실행
}

let temperature = 20;

if (temperature < 22) {
  console.log('보일러 좀 틀어줘');
} else {
  console.log('에어컨 좀 틀어줘');
}

if (money > 10000) {
  console.log('치킨');
} else if (money > 5000) {
  console.log('라면');
} else if (money > 1000) {
  console.log('과자');
} else {
  console.log('사탕');
}
