// 6. 마지막 홀수

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

let last_odd = 0;

for (let num of arr) {
  if (!(num % 2) || num < 0) {
    continue;
  } else {
    last_odd = num;
  }
}

console.log(last_odd);



// 배열을 거꾸로 도는 reverse 함수 사용하기

let last_odd_2;

for (let num of arr.reverse()) {
  if (num % 2 && num > 0) {
    last_odd_2 = num
    break
  }
}

console.log(last_odd_2)