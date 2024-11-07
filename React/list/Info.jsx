export default function Info() {

  const users = [
    { id: 1, name: '김철수', age: 25, hobby: '독서' },
    { id: 2, name: '이영희', age: 28, hobby: '요리' },
    { id: 3, name: '박민수', age: 23, hobby: '게임' }
  ];

  return (
    <ul>{users.map((user) => {
      return <li>
        <div>id:{user.id}</div>
        <div>name:{user.name}</div>
        <div>age:{user.age}</div>
        <div>hobby:{user.hobby}</div>
      </li>
    })}</ul>
  )
}


// 컴포넌트로 따로 빼는 방식
/*
export default function Info() {
const userItems = users.map((user) => {
  const {id, name, age, hobby} = user

  return <UserItem id={id} name={name} age={age} hobby={hobby}></UserItem>
})
}

function UserItem(id, name, age, hobby) {
  return <li>
  <div>id:{id}</div>
  <div>name:{name}</div>
  <div>age:{age}</div>
  <div>hobby:{hobby}</div>
</li>
}
*/