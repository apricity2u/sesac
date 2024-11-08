import { useState } from "react";

export default function MovingDot() {
  const [position, setPosition] = useState({
    // 두 개의 변수(x, y)를 하나의 state 변수(position)로 사용할 수 있다
    x: 0,
    y: 0,
  });
  return (
    <div
      onPointerMove={(e) => {
        setPosition({
          // e.clientX : X 좌표 값 e.clientY : Y 좌표 값
          x: e.clientX,
          y: e.clientY,
        });
      }}
      style={{
        position: "relative",
        width: "100vw",
        height: "100vh",
      }}
    >
      <div
        style={{
          position: "absolute",
          backgroundColor: "red",
          borderRadius: "50%",
          transform: `translate(${position.x}px, ${position.y}px)`,
          left: -10,
          top: -10,
          width: 20,
          height: 20,
        }}
      />
    </div>
  );
}
