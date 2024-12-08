import React from "react";
import { Outlet } from "react-router-dom";
import Header from "../components/Header";

export default function RootLayout() {
  return (
    <>
      <Header></Header>
      <Outlet></Outlet>
      <footer>copyright NAVER WEBTOON</footer>
    </>
  );
}