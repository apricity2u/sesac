import React from 'react'
import { Link } from 'react-router-dom'


export default function WebtoonHeader() {
  return (
    <header>
      <h3>webtoon</h3>
      <ul>
        <li><Link to="/webtoon">웹툰메인으로</Link></li>
        <li><Link to="/webtoon/mon">월요일웹툰으로</Link></li>
        <li><Link to="/webtoon/tue">화요일웹툰으로</Link></li>
        <li><Link to="/webtoon/wed">수요일웹툰으로</Link></li>
        <li><Link to="/webtoon/thr">목요일웹툰으로</Link></li>
      </ul>
    </header>
  )
}
