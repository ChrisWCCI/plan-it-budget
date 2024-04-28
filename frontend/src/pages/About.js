import React from "react";
import "./About.css";

function About() {
  return (
    <div className="aboutContainer">
      <article>
        <h1 id="about">About Us</h1>
        <p id="intro">
          Welcome to our budgeting site! Behind the scenes, a dedicated team of
          web developers is working tirelessly to bring you an intuitive and
          effective platform for managing your finances. Meet the minds that
          power our site:
        </p>
        <header>
          <img
            className="profilePhoto"
            src="./images/picture3.jpeg"
            alt="profile"
          />
          <h3 className="profileName">Kristina Cuevas</h3>
        </header>
        <section className="profileAbout">
          <p>
            My experience as a catering director has developed my strong
            customer service skills. It has also taught me that hard work,
            meticulous attention to detail, and communication, are the keys to
            great customer service. I was introduced to the world of technology
            and coding by my adult children, who have been an integral
            motivation in my decision to change the trajectory of my life and
            pursue a career in technology. I am looking forward to transitioning
            my love of customer service and working as part of a team, into a
            successful new career as a software developer. I am currently
            enrolled in a highly intensive coding boot camp, and will finish my
            training in a few more weeks. I am genuinely excited for what the
            future holds.
          </p>
        </section>
        <div>
          <h3 className="profileContact">Contact Information</h3>
          <section className="profileContactInfo">
            <a href="https://www.linkedin.com/in/kristina-cuevas-b13bb92a8/">
              <img src="./images/Linkedin.png" alt="LinkedIn" id="LI1" />
            </a>
            <a href="https://github.com/tlc67">
              <img src="./images/Github.png" alt="Github" id="GH1" />
            </a>
          </section>
        </div>
        <hr className="borderLine"></hr>
        <header>
          <img
            className="profilePhoto"
            src="./images/Collert_Tarrah 10814 (1).jpg"
            alt="profile"
          />
          <h3 className="profileName">Tarrah Collert</h3>
        </header>
        <section className="profileAbout">
          <p>
            I started working in banking back in 2007, and since then, I've had
            the chance to develop and deepen my expertise over the past 17
            years. Currently, I serve as a Compliance Officer, specializing in
            ensuring that both internal and external regulations and policies
            are followed. With the experience I've gained throughout my career
            and the additional skills I've acquired through further education,
            I'm eager to transition into Software Development. I take pride in
            staying informed about the latest advancements in my field and
            continuously seeking more efficient ways to excel in my profession.
            Transitioning into Software Development presents me with a fresh
            challenge and an exciting opportunity to explore creativity and
            innovation.
          </p>
        </section>
        <div>
          <h3 className="profileContact">Contact Information</h3>
          <section className="profileContactInfo">
            <a href="https://www.linkedin.com/in/tarrah-collert-472777141/">
              <img src="./images/Linkedin.png" alt="LinkedIn" id="LI2" />
            </a>
            <a href="https://github.com/tcollert">
              <img src="./images/Github.png" alt="Github" id="GH2" />
            </a>
          </section>
        </div>
        <hr className="borderLine"></hr>
        <header>
          <img
            className="profilePhoto"
            src="./images/hiitsme.jpg"
            alt="profile"
          />
          <h3 className="profileName">Donald Fletcher</h3>
        </header>
        <section className="profileAbout">
          <p>
            My name is Donald Fletcher. I am a native of Las Vegas, NV. I served
            in the U.S. Army from 2008-2016. After serving honorably in the
            military, I have worked as a financial analyst and also have a
            Bachelor of Science in Business from the University of Phoenix. I am
            currently transitioning to a career as a Full Stack Java Developer.
          </p>
        </section>
        <div>
          <h3 className="profileContact">Contact Information</h3>
          <section className="profileContactInfo">
            <a href="https://www.linkedin.com/in/donald-r-fletcher-jr-javafullstackdeveloper/">
              <img src="./images/Linkedin.png" alt="LinkedIn" id="LI3" />
            </a>
            <a href="https://github.com/donaldfletcher11">
              <img src="./images/Github.png" alt="Github" id="GH3" />
            </a>
          </section>
        </div>
        <hr className="borderLine"></hr>
        <header>
          <img
            className="profilePhoto"
            src="./images/Adrian.jpg"
            alt="profile"
          />
          <h3 className="profileName">Adrian Graham</h3>
        </header>
        <section className="profileAbout">
          <p>
            Hello, I have over a decades worth of background in logistics and
            customer service. I am working towards changing my career path with
            the skills I learned from WeCanCodeIt towards being a Software
            developer. Learning to utilize my strong attention to details and my
            problem solving skills through different formats of coding and their
            associated programs. In my free time I enjoy building furniture from
            scratch in my garage for my home and for my friends, maintaining and
            updating my home with different projects, video games, and
            collecting memorabilia.
          </p>
        </section>
        <div>
          <h3 className="profileContact">Contact Information</h3>
          <section className="profileContactInfo">
            <a href="https://www.linkedin.com/in/adrian-graham-b9750419/">
              <img src="./images/Linkedin.png" alt="LinkedIn" id="LI4" />
            </a>
            <a href="https://github.com/ProgramWithGraham/ProgramWithGraham.github.io">
              <img src="./images/Github.png" alt="Github" id="GH4" />
            </a>
          </section>
        </div>
        <hr className="borderLine"></hr>
        <div>
          <p id="outro">
            Together, our team is committed to helping you achieve financial
            success by providing a platform that's not only functional but also
            enjoyable to use. We're excited to be part of your financial
            journey!
          </p>
        </div>
      </article>
    </div>
  );
}
export default About;
