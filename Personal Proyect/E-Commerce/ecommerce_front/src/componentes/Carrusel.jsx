import React from "react";

export default function Carrusel() {
  return (
    <div id="carouselExampleCaptions" className="carousel slide mt-5">
      <div className="carousel-indicators">
        <button
          type="button"
          data-bs-target="#carouselExampleCaptions"
          data-bs-slide-to="0"
          className="active"
          aria-current="true"
          aria-label="Slide 1"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselExampleCaptions"
          data-bs-slide-to="1"
          aria-label="Slide 2"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselExampleCaptions"
          data-bs-slide-to="2"
          aria-label="Slide 3"
        ></button>
      </div>
      <div className="carousel-inner">
        <div className="carousel-item active">
          <img 
            src="https://statics-cuidateplus.marca.com/cms/styles/natural/azblob/2022-11/compras-compulsivas_0.jpg.webp?itok=lgDZJ1Zc"
            className="d-block w-100 img-fluid" alt="carrusel" />
        </div>
        <div className="carousel-item">
          <img
            src="https://www.baenegocios.com/__export/1683491030259/sites/cronica/img/2023/05/07/compra_electronica.png_1402874324.png"
            className="d-block w-100 img-fluid" alt="carrusel" />
        </div>
        <div className="carousel-item">
          <img
            src="https://cdn.eliteksolutions.com/wp-content/uploads/2021/02/10120514/mejorar-ecommerce-elitek-1200x675.png"
            className="d-block w-100 img-fluid"
            alt="carrusel"
          />
        </div>
      </div>
      <button
        className="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleCaptions"
        data-bs-slide="prev"
      >
        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Previous</span>
      </button>
      <button
        className="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleCaptions"
        data-bs-slide="next"
      >
        <span className="carousel-control-next-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Next</span>
      </button>
    </div>
  );
}
