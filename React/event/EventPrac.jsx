import React from "react";

export default function App() {
  function alertMessage() {
    alert("버튼 클릭");
  }

  function changebackgroundColor(target, color) {
    target.style.backgroundColor = color;

  }

  return (
    <>
      <button onClick={alertMessage}>ButtonClick</button>
      <div
        className="box"
        onMouseEnter={(e) => {
          changebackgroundColor(e.target, "black");
        }}
        onMouseLeave={(e) => {
          changebackgroundColor(e.target, "white");
        }}
      ></div>
      <input type="text" onChange={(e) => console.log(e.target.value)} />
    </>
  );
}
