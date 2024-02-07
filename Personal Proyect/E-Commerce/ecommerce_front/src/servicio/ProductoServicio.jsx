import axios from "axios";

const urlBase = "http://localhost:8080/ecommerce/";
export async function getAll() {
  console.log("productos service ", await axios.get(urlBase + "productos"));
  return await axios.get(urlBase + "productos");
}

export async function getById(id) {
  return axios.get(urlBase + "producto/" + id);
}

export async function create(producto) {
  console.log("producto en capa service", producto);
  return axios.post(urlBase + "producto", producto);
}
