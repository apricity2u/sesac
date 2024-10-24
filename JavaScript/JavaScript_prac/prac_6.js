// 1 배열 생성

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

// 2 양수 출력

arr.forEach((num) => {
  if (num > 0) {
    console.log(num);
  }
});

// 3 곱하기 2

const multipleArr = arr.map((num) => {
  return num * 2;
});

console.log(multipleArr);

// 4 양수 홀수 배열
// filter 함수 쓸 때 어차리 boolean 값으로 처리해서 if 안써도 됨됨
const oddNum = arr.filter((num) => {
  return num > 0 && num % 2  // 참인 값만 배열에 담는다.
  }
);

console.log(oddNum);

// 5 첫 번째 5 찾기

const fiveIndex = arr.findIndex((num) => {
  return num === 5;
});

console.log(fiveIndex);

// 6 배열 내 객체 출력하기 1

const todos = [
  {
    todoId: 1,
    content: '예습하기',
    isCompleted: false,
  },
  {
    todoId: 2,
    content: '강의듣기',
    isCompleted: false,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: false,
  },
];

todos.forEach((todo) => {
  console.log(todo);
});

// 7 배열 내 객체 출력하기 2

const todos2 = [
  {
    todoId: 1,
    content: '예습하기',
    isCompleted: false,
  },
  {
    todoId: 2,
    content: '강의듣기',
    isCompleted: true,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: true,
  },
];

// filter 함수 안에 if 없어도 됩니다 
const isCompleted = todos2.filter((todo) => {
  return todo.isCompleted
  }
);

isCompleted.forEach((todo) => console.log(todo))

// 7-2 다른 방법

// todos.forEach((todo) => {
//   if (todo.isCompleted === true) {
//     console.log(todo);
//   }
// });


// 8 이차원 배열 출력

const matrix = [
  [4,2], 
  [3,2], 
  [5,7], 
  [10,1]
]

matrix.forEach((arr) => {
  console.log(arr[1])
})

// 9 이차원 배열의 합

const evenSum = matrix.filter((arr) => {

  // 원소가 2개 뿐이니까 반복문 필요없고
  let sum = arr[0] + arr[1]
  // filter는 어차피 true인 값만 새로운 array에 넣으니까 if도 필요없음
  return !(sum % 2)

})

console.log(evenSum)