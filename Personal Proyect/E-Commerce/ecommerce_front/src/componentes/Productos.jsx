import React, { useEffect, useState } from "react";
import { getAll, search } from "../servicio/ProductoServicio";
import Card from "./Card";
import { Row, Col, Form, Button } from "react-bootstrap";
import Carrusel from "./Carrusel";

export default function Productos() {
  const [productos, setProductos] = useState([]);
  const [busqueda, setBusqueda] = useState("");

  useEffect(() => {
    const request = async () => {
      try {
        const response = await getAll();
        console.log("response", response.data);
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

  const onInputChange = (e) => {
    setBusqueda(e.target.value);
  };

  const onSumit = async (e) => {
    e.preventDefault();
    try {
      const responseB = await search(busqueda);
      console.log("response b ", responseB.data);

      console.log(responseB.data.productos);
      // Asegúrate de que responseB.data sea un array de productos
      if (Array.isArray(responseB.data.productos)) {
        setProductos([]);
        setProductos(
          responseB.data.productos.map((producto) => ({
            id: producto.id,
            titulo: producto.titulo,
            imagen: producto.imagen,
            descripcion: producto.descripcion,
          }))
        );
      } else {
        console.error(
          "La respuesta de búsqueda no contiene un array de productos:",
          responseB.data
        );
      }
      console.log("PRODUCTOS --------> ", productos);
    } catch (error) {
      console.error("Error al realizar la búsqueda:", error);
    }
  };

  return (
    <div>
      <Carrusel />
      <h1
        style={{ textAlign: "center", marginTop: "1rem", marginBottom: "1rem" }}
      >
        Productos
      </h1>
      <div className="container">
        <Form
          className="d-flex mx-4"
          role="search"
          onSubmit={(e) => onSumit(e)}
        >
          <Form.Control
            type="search"
            placeholder="Buscar"
            value={busqueda}
            onChange={(e) => onInputChange(e)}
          />
          <Button variant="outline-success" type="submit">
            Buscar
          </Button>
        </Form>
      </div>
      <Row
        xs={1}
        md={2}
        lg={3}
        xl={4}
        xxl={5}
        className="justify-content-center mx-1"
      >
        {productos.map((producto) => (
          <Col key={producto.id}>
            <Card
              id={producto.id}
              imagen={producto.imagen}
              titulo={producto.titulo}
              descripcion={producto.descripcion}
            />
          </Col>
        ))}
      </Row>
    </div>
  );
}
