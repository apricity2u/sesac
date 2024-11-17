import React from 'react'
import { Link } from 'react-router-dom'

export default function NovelHeader() {
  return (
    <header>
    <h3>novel</h3>
    <ul>
      <li><Link to="/novel">소설메인으로</Link></li>
      <li><Link to="/novel/fantasy">판타지소설으로</Link></li>
      <li><Link to="/novel/mystery">추리소설으로</Link></li>
    </ul>
  </header>
  )
}
