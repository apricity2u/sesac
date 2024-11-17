import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useParams } from "react-router-dom";

export default function PostDetail() {
  const { postId } = useParams();
  const posts = useSelector((state) => state.posts)
  
  // post 라는 데이터는 디테일에서만 사용하기 때문에 state로 관리
  const [post, setPost] = useState()
  // 렌더링이 된 다음에 실행해!
  // 무한루프 도는 것을 막음
  useEffect(()=>{
  // find : true인 것 하나만 가져옴
  setPost(posts.find((post) => post.id === parseInt(postId)))
  }, [])

  return (
    <div>
      {/* 옵셔널체이닝 '?' : undefined일 때 에러가 안나게 함 */}
      {/* post를 정의하지 않았기 때문에 post가 없는 상태 */}
      {/* 나중에 비동기로 데이터를 가져올 것이기 때문임! => 첫 화면은 빈 화면인거임 */}
      <h3>{post?.title}</h3>
      <p>{post?.content}</p>
    </div>
  );
}
