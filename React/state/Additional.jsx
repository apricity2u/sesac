import React, { useState } from "react";

export default function Additional() {

  // const twoValue -> object (object 형태만 state로 관리한다.)
  // object -> x: 0, y: 0 (참조)  
  const [twoValue, setTwoValue] = useState({
    x: 0,
    y: 0,
  });
  return (
    <>
      <button
        onClick={() => {
          // x 값에 1이 더해지지만, setter 사용x -> 렌더링 되지 않음
          twoValue.x += 1;
        }}
      >
        x +, 작동 X
      </button>
      <button
        onClick={() => {
          // x 값 하나만 변경하고 싶다고 해서 setTwoValue({x: twoValue.x + 1})로 쓰면 안됨
          // 위 경우 y 속성이 존재하지 않기 때문에 사용할 수 없음

          // x 값에 1이 더해지고, setter 사용o -> 렌더링 됨
          setTwoValue({
            x: twoValue.x + 1,
            y: twoValue.y
          });
        }}
      >
        x +, 작동 O
      </button>
      <button
        onClick={() => {
          // 그럼 object 안의 key : value가 여러개인데, 하나의 값만 변경해야한다면?
          // spread 연산자로 twoValue object 내부 key: value를 복사 + 변경사항 적기
          setTwoValue({
            ...twoValue,
            x: twoValue.x + 1,
          });
        }}
      >
        x +, 작동 O, spread
      </button>
      <button onClick={() => console.log(twoValue)}>출력</button>
      <div>x : {twoValue.x}</div>
      <div>y : {twoValue.y}</div>
    </>
  );
}
