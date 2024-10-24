// ? : 옵셔널체이닝

// 객체 속성 접근에서 옵셔널 체이닝

const user = {
  name: "홍길동",
  address: {
    city: "서울",
  },
};

console.log(user?.name); // 홍길동
console.log(user?.address?.city); // 서울
console.log(user?.address?.country);
// undefined (key 값이 없음)
console.log(user?.phone?.number);
// undefined (key값 곧 속성이 없지만 오류 발생 X)

// 배열에서 옵셔널 체이닝

let people = [];

people = [
  {
    name: "홍길동",
    age: 30,
    job: "개발자",
  },
  {
    name: "홍길동",
    age: 30,
    job: "개발자",
  },
];

console.log(people[0]?.name);

// 데이터를 서버에서 가져오는 동안
// 우리는 데이터가 있으나 없으나 people[0]를 바라볼 것
// error가 안 뜨고 undefined가 됨
