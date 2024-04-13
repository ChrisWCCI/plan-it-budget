import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-icons/font/bootstrap-icons.css";
import "bootstrap/js/dist/dropdown";
import "./Sidebar.css";

function SidebarMenu() {
  return (
    <div className="containter-fluid">
      <div className="row">
        <div className="bg-dark col-auto col-md-2 min-vh-100 d-flex justify-content between flex column">
          <div>
            <a className="text-decoration-none text-white mt-2 d-none d-sm-inline d-flex ms-3 mt-2">
              <span id="menu" className="ms-1 fs-4 d-none d-sm-inline">
                MENU
              </span>
            </a>
            <hr className="text-secondary d-none d-sm-block" />
            <ul class="nav nav-pills flex-column mt-3 mt-sm-0">
              <li class="nav-item text-white fs-4 my-1 py-2 py-sm-0">
                <a href="#" class="nav-link active1" aria-current="page">
                  <i className="bi bi-house"></i>
                  <span className="ms-3 d-none d-sm-inline">Home</span>
                </a>
              </li>
              <li class="nav-item text-white fs-4 my-1 py-2 py-sm-0">
                <a href="#" class="nav-link active2" aria-current="page">
                  <i className="bi bi-graph-up-arrow"></i>
                  <span className="ms-3 d-none d-sm-inline">Goals</span>
                </a>
              </li>
              <li class="nav-item text-white fs-4 my-1 py-2 py-sm-0">
                <a href="#" class="nav-link active3" aria-current="page">
                  <i className="bi bi-fire"></i>
                  <span className="ms-3 d-none d-sm-inline">Burn Down</span>
                </a>
              </li>
              <li class="nav-item text-white fs-4 my-1 py-2 py-sm-0">
                <a href="#" class="nav-link active4" aria-current="page">
                  <i className="bi bi-tools"></i>
                  <span className="ms-3 d-none d-sm-inline">Resources</span>
                </a>
              </li>
              <li class="nav-item text-white fs-4 my-1 py-2 py-sm-0">
                <a href="#" class="nav-link active5" aria-current="page">
                  <i className="bi bi-person-workspace"></i>
                  <span className="ms-3 d-none d-sm-inline">About</span>
                </a>
              </li>
            </ul>
          </div>
        </div>
        <div class="dropdown open">
          <a
            class="text-decoration-none text-white dropdown-toggle p-3"
            type="button"
            id="triggerId"
            data="bs-toggle-dropdown"
            aria-expanded="false"
          >
            <i className="bi bi-person-circle"></i>
            <span className="ms-2 d-none d-sm-inline"> Yousaf</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="triggerId">
            <a class="dropdown-item" href="#">
              <span className="d-sm-inline">1</span>
              <span className="d-none d-sm-block"> Profile</span>
            </a>
            <a class="dropdown-item" href="#">
              <span className="d-sm-inline">2</span>
              <span className="d-none d-sm-block">Settings</span>
            </a>
          </div>
        </div>
      </div>
    </div>
  );
}

export default SidebarMenu;
