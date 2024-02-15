import React from "react";
import { Link } from "react-router-dom";

export default function NavBar() {


  return (
    <nav className="navbar navbar-expand-lg bg-dark navbar-dark fixed-top">
      <div className="container-fluid">
        <Link className="navbar-brand" href="/">
          E-Commerce
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav d-flex justify-content-between">
            <div>
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to="/">
                  Inicio
                </Link>
              </li>
            </div>
            <div>
              <li className="nav-item">
                <Link className="nav-link" to="/agregar">
                  Agregar
                </Link>
              </li>
            </div>
          </ul>
        </div>
      </div>
    </nav>
  );
}
