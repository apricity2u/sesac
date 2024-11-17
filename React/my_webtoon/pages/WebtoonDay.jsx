import React from "react";
import { useLocation, useParams } from "react-router-dom";

export default function WebtoonDay() {
  const { day } = useParams();
  const location = useLocation();

  const { webtoon } = location.state;

  return (
    <>
      <h3>{webtoon.day}</h3>
    </>
  );
}
