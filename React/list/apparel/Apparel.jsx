import React from "react";
import ApparelHeader from "./ApparelHeader";
import ApparelMain from "./ApparelMain";

export default function apparel() {
  return (
    <>
      <>
        <ApparelHeader></ApparelHeader>
        <div className="container">
          <ApparelMain></ApparelMain>
          <hr />
          <footer>all rights reserved</footer>
        </div>
      </>
    </>
  );
}
