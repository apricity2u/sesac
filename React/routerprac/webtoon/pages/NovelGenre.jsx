import React from "react";
import { useLocation, useParams } from "react-router-dom";

export default function NovelGenre() {
  const { genre } = useParams();
  const location = useLocation();

  const { novel } = location.state;

  return (
    <>
      <h3>{novel.genre}</h3>
    </>
  );
}
