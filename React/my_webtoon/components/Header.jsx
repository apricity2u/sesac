import React from "react";
import { Link, useParams } from "react-router-dom";

export default function Header() {

  return (
    <header>
      <nav>
        <ul className="homeNav">
          <li>
            <Link to="/"><h1>NAVER</h1></Link>
          </li>
          <li>
            <Link to="/webtoon"><h2>웹툰</h2></Link>
          </li>
          <li>
            <Link to="/novel"><h2>웹소설</h2></Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}
