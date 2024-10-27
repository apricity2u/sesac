// 1

let arr = [1, 2, 3, 4, 5];

for (let num of arr) {
  console.log(num);
}

// 2

for (let num of arr) {
  console.log(num ** 2);
  //console.log(num * num);
}

// 3

arr = [0, 1, 2, 3, 4, 5];

for (let num of arr) {
  if (num !== 0 && !(num % 2)) {
    console.log(num);
  }
}

// 4

let person = {
  name: '홍길동',
  age: 30,
  job: '개발자',
};

for (let key in person) {
  console.log(key, person[key]);
}
