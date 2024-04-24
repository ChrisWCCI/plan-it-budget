import "../App.css";
import "./Resources.css";
import React from 'react';

function Resources() {

  return (
    <>
    <div className="addtlResources">
    <h1 id="resourceName">Resources</h1>
  </div>
    <div className="grid-container">
    <div class="grid-item"> <img id="creditKarma" src="./images/credit-karma.webp" alt="resource1"/> <span class="caption">Credit Karma is a personal finance company that offers free credit scores, credit reports, and personalized financial recommendations. Users can sign up for an account and access tools to track their credit health, explore credit card and loan options, and receive insights and tips for improving their financial well-being. The website also provides educational resources on credit management, monitoring, and identity theft protection.</span>  <a href="https://www.creditkarma.com/">Click Here</a></div>
  

      <div className="grid-item">2</div>
      <div className="grid-item">3</div>  
      <div className="grid-item">4</div>
      <div className="grid-item">5</div>
      <div className="grid-item">6</div>
      <div className="grid-item">7</div>
      <div className="grid-item">8</div>
      <div className="grid-item">9</div>
    </div>
    </>
  );
}

export default Resources;
