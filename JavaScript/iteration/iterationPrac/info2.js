// names = ['jun', 'beemo', 'ken']
// ages = [18, 28, 37] 일 때,
//
// 18살 jun
// 28살 beemo
// 37살 ken
// 을 출력하시오.

names = ['jun', 'beemo', 'ken'];
ages = [18, 28, 37];

// for

for (let i = 0; i < names.length; i++) {
  // i가 같으니까 활용하면 된다!
  const name = names[i]; // 인덱스 0, 1, 2
  const age = ages[i]; // 인덱스 0, 1, 2

  console.log(`${age}살 ${name}`);
}

console.log('-------------------');

// while

let a = 0;

while (a < names.length) {
  const name = names[a];
  const age = ages[a];

  console.log(`${age}살 ${name}`);
  a++;
}
