import React from "react";

export default function ApparelMainMore() {
  const data = [
    {
      imgUrl: "assets/mail.png",
      name: "email adress",
      value: "a@example.com",
    },
    {
      imgUrl: "assets/mail.png",
      name: "email adress",
      value: "a@example.com",
    },
    {
      imgUrl: "assets/mail.png",
      name: "email adress",
      value: "a@example.com",
    },
    {
      imgUrl: "assets/mail.png",
      name: "email adress",
      value: "a@example.com",
    },
  ];

  const dataTag = data.map((el) => {
    const { imgUrl, name, value } = el;
    return (
      <li>
        <div>
          <img src={imgUrl} alt="" />
          <div>{name}</div>
        </div>
        <div>{value}</div>
      </li>
    );
  });

  return (
    <section className="more">
      <h2 className="section-title">more</h2>
      <ul className="more-info">{dataTag}</ul>
    </section>
  );
}
