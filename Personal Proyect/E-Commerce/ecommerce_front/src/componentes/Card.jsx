import React from "react";
import { Link } from "react-router-dom";

export default function Card({ id, imagen, titulo, descripcion }) {
  return (
    <div
      className="card m-2 text-center "
      style={{ width: "16rem", alignItems: "center", height: "24rem" }}
    >
      <img
        src={imagen}
        className="card-img-top"
        alt={titulo}
        style={{
          objectFit: "contain",
          height: "60%",
          width: "100%",
          padding: "0.2rem",
          marginTop: "0.4rem",
        }}
      />
      <div className="card-body">
        <h5 className="card-title">{titulo}</h5>
        <Link to={`/producto/${id}`} className="btn btn-primary">
          Ver más
        </Link>
      </div>
    </div>
  );
}
