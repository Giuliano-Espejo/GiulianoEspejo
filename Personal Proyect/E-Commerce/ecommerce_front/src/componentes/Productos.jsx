import React, { useEffect, useState } from "react";
import { getAll } from "../servicio/ProductoServicio";
import Card from "./Card";
import { Row } from "react-bootstrap";
import Carrusel from "./Carrusel";

export default function Productos() {
  const [productos, setProductos] = useState([]);

  useEffect(() => {
    const request = async () => {
      try {
        const response = await getAll();

        // Verificar si la respuesta tiene la propiedad "productos: " y es un array
        if (response.data && Array.isArray(response.data["productos: "])) {
          const productosData = response.data["productos: "].map(
            (producto) => ({
              id: producto.id,
              titulo: producto.titulo,
              imagen: producto.imagen,
              descripcion: producto.descripcion,
            })
          );

          setProductos(productosData);
          console.log("productos", productosData);
        } else {
          console.log(
            "La respuesta no contiene un array de productos:",
            response.data
          );
        }
      } catch (e) {
        console.log(e);
      }
    };

    request();
  }, []);

  return (
    <div>
      <Carrusel />
      <h1 style={{ textAlign: "center", marginTop: "1rem", marginBottom: "1rem" }}>
        Productos
      </h1>
      <Row
        xs={1}
        md={2}
        lg={3}
        xl={4}
        xxl={5}
        className="justify-content-center mx-1"
      >
        {productos.map((producto) => (
          <Card
            key={producto.id}
            id={producto.id}
            imagen={producto.imagen}
            titulo={producto.titulo}
            descripcion={producto.descripcion}
          />
        ))}
      </Row>
    </div>
  );
}
