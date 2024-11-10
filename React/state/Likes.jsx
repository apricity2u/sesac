import { useState } from "react";

export default function Likes() {

  // 하나의 컴포넌트는 2개의 state를 가질 수 있다.

  // 좋아요, 좋아요 취소를 관리
  const [likes, setLikes] = useState("좋아요");
  // 좋아요 여부에 따른 배경색상 관리
  const [colors, setColors] = useState("pink");

  function LikesStatus() {
    // likes가 좋아요면 좋아요 취소로 변경. 좋아요 취소는 좋아요로 변경
    setLikes((likes) => (likes === "좋아요" ? "좋아요 취소" : "좋아요"));

    // 동시에 color가 좋아요 기본값인 pink면 좋아요 취소의 기본값인 yellow로 변경. yellow면 pink로 변경
    setColors((colors) => (colors === "pink" ? "yellow" : "pink"));
  }

  return (
    // 버튼을 클릭하면 likesstatus 함수를 실행하고, className에는 colors를 할당한다.
    // likes는 좋아요 혹은 좋아요 취소
    <button onClick={LikesStatus} className={colors}>
      {likes}
    </button>
  );
}
