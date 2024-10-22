// 3
// const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7] 일 때,
// 원소가  1, 4, 5, 7인 경우를 제외하고 출력하세요

const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7];

let i = 0;

while (i < arr.length) {
  let num = arr[i];

  if (num !== 1 && num !== 4 && num !== 5 && num !== 7) {
    console.log(num);
  }

  i++;
}

//

for (let num of arr) {
 if (num === 1 || num === 4 || num === 5 || num === 7) {
   continue;
 }
 console.log(num)
 }

//

const notLogSet = new Set([1, 4, 5, 7]);
// 1, 4, 5, 7 중에 해당되는지를 확인하면 됨!

for (let num of arr) {
  // if (num set에 들어있어?) continue
  if (notLogSet.has(num)) continue; // 1, 4, 5, 7 중에 있으면 반복문 계속 실행

  console.log(num);
}