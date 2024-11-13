import { useState } from "react";
import { Link } from "react-router-dom";

export default function NovelMain() {

  
  const [novels, novelsState] = useState([
    {
      id: "fantasy",
      genre: "판타지",
    },
    {
      id: "mystery",
      genre: "추리",
    }
  ]);

  return (
    <>
      <h3>novel main</h3>
      <ul>
        {novels.map((novel) => (
          <li key={novel.id}>
            <Link to={`/novel/${novel.id}`} state={{ novel }}>
              <h3>{novel.genre}</h3>
            </Link>
          </li>
        ))}
      </ul>
    </>
  );
}
