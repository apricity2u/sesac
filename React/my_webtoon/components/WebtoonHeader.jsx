import React from "react";
import { Link } from "react-router-dom";

export default function WebtoonHeader() {
  const webtoons = [
    {
      id: "mon",
      day: "월",
    },
    {
      id: "tue",
      day: "화",
    },
    {
      id: "wed",
      day: "수",
    },
    {
      id: "thu",
      day: "목",
    },
    {
      id: "fri",
      day: "금",
    },
    {
      id: "sat",
      day: "토",
    },
    {
      id: "sun",
      day: "일",
    },
  ];

  return (
    <header>
      <nav>
        <ul className="webtoonNav">
          <li>
            <Link to={"/webtoon"}>
              <h3>메인</h3>
            </Link>
          </li>
          {webtoons.map((webtoon) => (
            <li key={webtoon.id}>
              <Link to={`/webtoon/${webtoon.id}`}>
                <h3>{webtoon.day}</h3>
              </Link>
            </li>
          ))}
        </ul>
      </nav>
    </header>
  );
}
