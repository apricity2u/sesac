import { useState } from "react";

export default function InputColor() {
  const [myColor, setColor] = useState(" ");

  // 현재 매개변수 value에는 input한 값이 있다
  function showColor(value) {
    // state변수인 myColor에 value를 할당한다.
    setColor((myColor) => (myColor = value));
  }

  return (
    <>
    {/* 배경색상을 바꾸려면 style로 접근한다 */}
      <div
        style={{
          width: 100,
          height: 100,
          border: "1px solid",
          backgroundColor: myColor
        }}
      ></div>
      {/* input 태그에서 input 값을 입력하면 그 value값을 showColor 함수의 인자로 전달한다. */}
      <input
        type="text"
        onChange={(event) => showColor(event.target.value)}
      />
    </>
  );
}
