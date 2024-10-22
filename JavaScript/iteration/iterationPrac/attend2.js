// 2

const names = ['jun', 'beemo', 'ken', 'lynda'];

// for

for (let i = 0; i < names.length; i++) {
  let name = names[i];
  console.log(`${i + 1}번 ${name}`);
}

console.log('-------------');
// while

let a = 0;

while (a < names.length) {
  let name = names[a];
  console.log(`${a + 1}번 ${name}`);
  a++;
}
