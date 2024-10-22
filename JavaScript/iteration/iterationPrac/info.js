// names = ['jun', 'beemo', 'ken']
// ages = [18, 28, 37] 일 때,
//
// 18살 jun
// 28살 beemo
// 37살 ken
// 을 출력하시오.

// array는 특수한 object 입니다.
// length, 등등의 추가적인 key : value

// object의 key값은 string 또는 symbol

names = ['jun', 'beemo', 'ken'];
ages = [18, 28, 37];

// age[0], name[0]
// age[1], name[1]
// age[2], name[2]
// index 출력하면 0, 1, 2 나옴

for (let index in names) {
  let age = ages[index];
  let name = names[index];

  console.log(`${age}살 ${name}`);
}

