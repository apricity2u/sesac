import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <header>
      <nav>
        <ul className="homeNav">
          <li>
            <Link to="/">NAVER</Link>
          </li>
          <li>
            <Link to="/webtoon">웹툰</Link>
          </li>
          <li>
            <Link to="/novel">웹소설</Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}
