import { useState } from "react";

export default function Form() {
  const [person, setPerson] = useState({
    firstName: "Barbara",
    lastName: "Hepworth",
    email: "bhepworth@sculpture.com",
  });

  function handleChange(e) {
    setPerson(
      // state는 새로운 객체를 전달해야 안에 있는 값이 변경된다
      {
        ...person,
        [e.target.name]: e.target.value,
        // spread 연산자로 person의 key : value를 얕은 복사하기
        // key 값은 항상 string 형태로 들어가기 때문에,
        // 변수를 key 값으로 쓰고 싶다면 대괄호를 사용한다.
    });
  }

  return (
    <>
      <label>
        First name:
        <input
          // name은 그저 key 값을 반복해서 가져오기 위해 작성한 것
          name="firstName"
          value={person.firstName}
          onChange={handleChange}
        />
      </label>
      <label>
        Last name:
        <input
          name="lastName"
          value={person.lastName}
          onChange={handleChange}
        />
      </label>
      <label>
        Email:
        <input name="email" value={person.email} onChange={handleChange} />
      </label>
      <p>
        {person.firstName} {person.lastName} ({person.email})
      </p>
    </>
  );
}
