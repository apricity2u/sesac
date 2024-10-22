// 7
// 자연수 n이 주어졌을 때, n이 소수인지 판단하시오.

// 소수란 무엇인가?
// 1과 자기 자신으로만 나누어 떨어지는 수

// 그렇다면 소수가 아닌 수는?
// 1과 자기 자신뿐만 아니라 다른 수로도 나누어 떨어지는 수

// 어떤 수가 존재할 때, 넌 소수가 맞아.
// 2 ~ n~1로 나누어 볼게. 혹시 나누어 떨어지면 넌 소수가 아니야.

let n = 2;
let isPrime = true; // 처음 시작을 소수로 규정!

for (i = 2; i < n; i++) {
  if (n % i === 0) { // 자연수 n을 i로 나누었을 때 나머지가 0이면 = 나누어 떨어지면
    isPrime = false; // 0으로 나누어 떨어지면 넌 소수가 아니야!
  }
}

console.log(isPrime);



// 내 풀이
// let n = 4;

// if (n === 2) {
//   console.log('소수입니다');
// }

// for (i = 2; i < n; i++) {
//   if (n % i === 0) {
//     console.log('소수가 아닙니다.');
//     break;
//   } else {
//     console.log('소수입니다.');
//     break;
//   }
// }




