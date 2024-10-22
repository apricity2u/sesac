// 4
// 1 ~ 9 까지의 자연수 중 제곱한 수가
// 10 이상 50 이하인 자연수의 리스트를 출력해보세요.

const num_list = [];

for (let num = 1; num <= 9; num++) {
  let multiple_num = num ** 2;

  if (multiple_num >= 10 && multiple_num <= 50) {
    num_list.push(num);
  }
}

console.log(num_list);
