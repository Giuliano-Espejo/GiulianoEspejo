import { deleteProduct, getOneProduct, getProductInCategory, updateStateProduct } from "../services/products.js";


// La instrucción que proporcionaste se utiliza para obtener el valor de un parámetro llamado "id" de la URL actual en una página web
const id = new URLSearchParams(window.location.search).get("id");
//inicializar elementos

/*
La instrucción que proporcionaste utiliza JavaScript para obtener
 un elemento HTML con un atributo id específico.
 Entonces, en resumen, la instrucción busca y almacena en la 
 variable productoImagen la referencia al elemento HTML que tiene 
 el atributo id igual a "producto-imagen". 
 Una vez que se ejecuta esta línea de código, puedes acceder y manipular el 
 elemento con el id "producto-imagen" en JavaScript utilizando la variable
  productoImagen. Por ejemplo,
  puedes cambiar su contenido, estilo o realizar otras operaciones en ese elemento. 
*/

const productoTitulo = document.getElementById("producto-titulo");
const productoImagen = document.getElementById("producto-imagen");
const productoTiempo = document.getElementById("producto-tiempo");
const productoDescripcion = document.getElementById("producto-descripcion");
const productoResponsable = document.getElementById("producto-responsable")
const btnDelete = document.getElementById("delete-button")
const btnUpdateState = document.getElementById("update-button")
const estadoSelect = document.getElementById("estado")

//TOAST
const _successToast = document.getElementById('successToast')
const _errorToast = document.getElementById('errorToast')


const  productosRelacionadosContainer = document.getElementById("productos-relacionados");


// Función que busca un producto  en función del id seleccionado de la URL
const fillProduct = async () => {
  const producto = await getOneProduct(id);
  if(producto){
      productoImagen.src = producto.imagen;
      productoTitulo.textContent = producto.titulo;
      productoTiempo.textContent = "Tiempo: "+producto.tiempo;
      productoDescripcion.textContent = producto.descripcion;
      productoResponsable.textContent = "Responable: " + producto.responsable;
      estadoSelect.value = producto.estado
    // LLamo a la función Producto relacionado  
      fillProductosRelacionados(producto.estado);

 }
}



//  Función que busca los productos relacionados
const fillProductosRelacionados = async (estado) => {
  // la categoria es el estado
    const products = await getProductInCategory(estado);


    products.forEach(product => {
        //crear elemento
        productosRelacionadosContainer.innerHTML += `
        <div class="col">
          <div class="card h-100 ">
            <img 
              style="min-height:300px;
                    max-height: 300px;"
              class="card-img-top"
                    src="${product.imagen}">
            <div class="card-body p-4">
              <div class="text-center">
                <h5 class="fw-bolder">${product.titulo}</h5>
                <span>${"Tiempo: " + product.tiempo}</span><br>
                <span>${"Responsable: " + product.tiempo}</span>
              </div>
            </div>
            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                <div class="text-center d-flex gap-1 align-items-center justify-content-center">
                    <a href="/detalle.html?id=${product.id}" class="btn btn-outline-secondary mt-auto">Ver más</a>
                </div>
            </div>
          </div>
        </div>
        `;
    })
}

// Sección de oyentes de eventos
// Cuando hago click en el Icono eliminar
btnDelete.addEventListener('click',async (e)=>{
  e.preventDefault()
  const product = await deleteProduct(id)

  
  if (product) {
    location.href = "/"
  }

})

// Cuando hago click en el botón actializar
btnUpdateState.addEventListener('click',async (e)=>{
  e.preventDefault()
  const successToast = bootstrap.Toast.getOrCreateInstance(_successToast)
  const errorToast = bootstrap.Toast.getOrCreateInstance(_errorToast)

  const estado = estadoSelect.value


  if (estado !== '') {
  
    const res = await updateStateProduct(id, estado)
  
    successToast.show()
    return
  }
  
  
  errorToast.show()
})

// Acá comienza el proceso realmente
fillProduct();