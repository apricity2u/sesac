import React from "react";
import { Link } from "react-router-dom";

export default function NovelHeader() {
  const novels = [
    {
      id: "fantasy",
      genre: "판타지",
    },
    {
      id: "mystery",
      genre: "추리",
    },
    {
      id: "modern",
      genre: "현대",
    },
    {
      id: "sf",
      genre: "공상과학",
    },
  ];

  return (
    <header>
      <ul className="webtoonNav">
        <li>
          <Link to="/novel">
            <h3>메인</h3>
          </Link>
        </li>
        {novels.map((novel) => (
          <li key={novel.id}>
            <Link to={`/novel/${novel.id}`} state={{ novel }}>
              <h3>{novel.genre}</h3>
            </Link>
          </li>
        ))}
      </ul>
    </header>
  );
}
