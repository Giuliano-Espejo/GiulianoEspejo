import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { getById } from "../servicio/ProductoServicio";

export default function Producto() {
  const { id } = useParams();

  const [producto, setProducto] = useState([]);

  useEffect(() => {
    const request = async () => {
      try {
        const response = (await getById(id)).data.producto;
        setProducto(response);
      } catch (e) {
        console.log("Ocurrio un error ",e);
      }
    };

    request();
  }, [id]);

  return (
    <div className="container">
      <div
        className="rounded p-2"
        style={{ overflow: "hidden", marginTop: "7%" }}
      >
        <div className="">
          <div style={{ float: "left", width: "32%" }}>
            <img
              src={producto.imagen}
              style={{
                width: "100%",
                height: "auto",
                borderRadius: "2%",
              }}
              alt={producto.titulo}
            />
          </div>
          <div style={{ marginLeft: "37%" }}>
            <h5>{producto.titulo}</h5>
            <hr />
            <p>{producto.descripcion}</p>
          </div>
        </div>
      </div>
      <hr />
      <div className="container">
        <h1>Informacion del Usuario</h1>
      </div>
    </div>
  );
}
