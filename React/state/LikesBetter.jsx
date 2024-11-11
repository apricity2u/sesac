import { useState } from 'react';

export default function Likes() {
  // isLiked에 좋아요 상태를 담음 (true / false)
  const [isLiked, setLikes] = useState(false);

  return (
    <button
      onClick={() => {
        // 버튼을 클릭하면 isLiked의 상태가 반전됨

        // toggle처럼 작동함 => boolean 형태로 state 변수를 만들어주면 됨
        // 좋아요 -> text : 좋아요 취소 & class : yellow
        // 좋아요 취소 -> text : 좋아요 & class : pink
        setLikes((isLiked) => !isLiked);
      }}

      // isLiked의 상태에 따라 클래스 부여 (삼항연산자 사용)
      // 백틱 사용하는 이유는 className에는 string 형태로 전달해야 하기 때문
      className={`${isLiked ? 'yellow' : 'pink'}`}

      // 마찬가지로 스타일도 toggle 형태로 조정할 수 있다
      style={{color : isLiked ? "red" : "gray"}}
    >
      {/* isLiked의 상태에 따라 텍스트가 변경됨 (삼항연산자 사용) */}
      {isLiked ? '좋아요 취소' : '좋아요'}
    </button>
  );
}
