// 상금과 차 둘 중에 하나만 가질 수 있음
// 둘 다 갖는 경우는 X
// 둘 다 못 갖는 경우도 X

let money = false;
let car = true;

if (money === car) {
  console.log(false);
} else {
  console.log(true);
}

// 삼항연산자

let status2 = money === car ? false : true
console.log(status2)


// XOR 라는 것은, OR는 OR인데, T-T 쌍인 경우를 제외한 것

console.log((money || car) && !(money && car));
