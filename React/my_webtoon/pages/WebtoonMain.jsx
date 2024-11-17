import { useState } from "react";
import { Link } from "react-router-dom";

export default function WebtoonMain() {
  const [webtoons, webtoonsState] = useState([
    {
      id: "mon",
      day: "월요일",
    },
    {
      id: "tue",
      day: "화요일",
    },
    {
      id: "wed",
      day: "수요일",
    },
    {
      id: "thr",
      day: "목요일",
    },
  ]);

  return (
    <>
      <h3>weboon main</h3>
      <ul>
        {webtoons.map((webtoon) => (
          <li key={webtoon.id}>
            <Link to={`/webtoon/${webtoon.id}`} state={{ webtoon }}>
              <h3>{webtoon.day}</h3>
            </Link>
          </li>
        ))}
      </ul>
    </>
  );
}
