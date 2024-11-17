import React from "react";
import { Navigate, useParams } from "react-router-dom";

export default function WebtoonDay() {
  const { day } = useParams();
  // day를 가지고 fetch(`localhost/webtoon/${day}`)의 data를 보여줌

  // 이상한 주소로 접근한 경우 웹툰 메인 페이지로 이동하기
  const weekData = new Set(["mon", "tue", "wed", "thu", "fri", "sat", "sun"])
  if (!weekData.has(day)) {
    return <Navigate to="/webtoon" replace></Navigate>

  }else {
    return <div>{day}</div>
  }
}