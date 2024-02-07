import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { create } from "../servicio/ProductoServicio";

export default function Agregar() {
  let navegacion = useNavigate();

  const [producto, setProducto] = useState({
    titulo: "",
    descripcion: "",
    imagen: "",
  });

  const { titulo, descripcion, imagen } = producto;

  const onInputChange = (e) => {
    //spread operator ... (expandir los atributos)
    setProducto({ ...producto, [e.target.name]: e.target.value });
    //si coincide con el atributo empleado se asigna ese valor
  };

  const onSumit = async (e) => {
    e.preventDefault();
    create(producto);
    navegacion("/");
  };

  return (
    <div className="container  " style={{ marginTop: "5%" }}>
      <br />
      <form onSubmit={(e) => onSumit(e)}>
        <div className="mb-3">
          <label for="titulo" className="form-label">
            Titulo
          </label>
          <input
            type="text"
            className="form-control"
            id="titulo"
            name="titulo"
            placeholder="Titulo"
            value={titulo}
            onChange={(e) => onInputChange(e)}
          />
        </div>
        <div className="mb-3">
          <label for="descripcion" className="form-label">
            Descripcion
          </label>
          <textarea
            className="form-control"
            id="descripcion"
            name="descripcion"
            rows="6"
            placeholder="Descripcion"
            required={true}
            value={descripcion}
            onChange={(e) => onInputChange(e)}
          ></textarea>
        </div>
        <div className="mb-3">
          <label htmlFor="imagen" className="form-label">
            Imagen
          </label>
          <input
            type="url"
            id="imagen"
            name="imagen"
            className="form-control"
            rows="3"
            placeholder="URL imagen"
            value={imagen}
            onChange={(e) => onInputChange(e)}
          />
        </div>
        <div className="text-center">
          <button type="submit" className="btn btn-primary">
            Agregar
          </button>
        </div>
      </form>
    </div>
  );
}
