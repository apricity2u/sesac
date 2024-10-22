let dust = 80;
// 0의 정수인지 && 너무 큰 값이 들어가도 되는지

if (dust > 250) {
  console.log('매우나쁨');
} else if (dust > 100) {
  console.log('나쁨');
} else if (dust > 50) {
  console.log('보통');
} else {
  console.log('좋음');
}

let micro_dust = 35;

if (micro_dust <= 30) {
  if (dust > 250) {
    console.log('매우나쁨');
  } else if (dust > 100) {
    console.log('나쁨');
  } else if (dust > 50) {
    console.log('보통');
  } else {
    console.log('좋음');
  }
} else {
  console.log('매우나쁨');
}
