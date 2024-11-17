import React from "react";

export default function Header() {
  return (
    <header className="header">
      <nav>
        <h1>
          <a href=""> apparel shop </a>
        </h1>
        <ul>
          <li>
            <a href="">HOME</a>
          </li>
          <li>
            <a href="">PRODUCTS</a>
          </li>
        </ul>
      </nav>
      <img src="assets/apparel.png" alt="" />
    </header>
  );
}
