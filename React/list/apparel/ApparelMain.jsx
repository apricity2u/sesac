import React from "react";
import ApparelMainMore from "./ApparelMainMore";
export default function Main() {
  return (
    <main>
      <section className="about">
        <img src="assets/apparel2.jpg" alt="" />
        <div>
          <h2 className="section-title">About Our Company</h2>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam
            aliquam in iure odit, accusantium officia incidunt quaerat, sit quis
            voluptas provident, similique rem quisquam ipsa repellendus sint ex
            quos quibusdam.
          </p>
        </div>
      </section>
      <section className="contact">
        <h2 className="section-title">contact us</h2>
        <div>
          <form className="contact-form">
            <label htmlFor="username">Username</label>
            <input
              type="text"
              placeholder="Username"
              id="username"
              name="username"
            />
            <label htmlFor="email">Email</label>
            <input type="email" placeholder="Email" id="email" name="email" />
            <input type="submit" defaultValue="send" />
          </form>
          <img src="assets/apparel3.jpg" alt="" />
        </div>
      </section>
      <ApparelMainMore></ApparelMainMore>
    </main>
  );
}
