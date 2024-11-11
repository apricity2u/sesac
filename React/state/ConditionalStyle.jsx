import React from "react";

export default function ConditionalStyle() {
  const isRed = true;
  const value = isRed ? "red" : "blue";
  // 연산자 => 계산을 해서 값을 얻는 다
  // value란 녀석은 'red' 또는 'blue'라는 값을 가지는 string
  const style1 = {
    backgroundColor: value,
  };

  const style2 = {
    backgroundColor: isRed ? "red" : "blue",
  };

  return (
    <>
      <div style={style1}>ConditionalStyle</div>
      <div style={style2}>ConditionalStyle</div>
      <div style={{ backgroundColor: isRed ? "red" : "blue" }}>
        ConditionalStyle
      </div>
    </>
  );
}
