import React from "react";
import { Navigate, useParams } from "react-router-dom";

export default function NovelGenre() {
  const { genre } = useParams();

  // 이상한 주소로 접근한 경우 웹툰 메인 페이지로 이동하기
  const genreData = new Set(["modern", "mystery", "sf", "fantasy"]);
  if (!genreData.has(genre)) {
    return <Navigate to="/novel" replace></Navigate>;
  } else {
    return <div>{genre}</div>;
  }
}
