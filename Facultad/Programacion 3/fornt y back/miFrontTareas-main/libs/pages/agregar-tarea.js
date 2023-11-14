import { addProduct } from "../services/products.js";

// Obtener valores
const _titulo = document.getElementById('titulo');
const _descripcion = document.getElementById('descripcion');
const _tiempo = document.getElementById('tiempo'); 
const _imagen = document.getElementById('imagen');
const _responsable = document.getElementById('responsable');
const _estado = document.getElementById('estado');
//TOAST
const _successToast = document.getElementById('successToast')
const _errorToast = document.getElementById('errorToast')

// Obtener el formulario
const form = document.querySelector('form');

// Manejador submit
form.addEventListener('submit', async (e)=> {

    // Prevenir envío 
    e.preventDefault();
    
    const successToast = bootstrap.Toast.getOrCreateInstance(_successToast)
    const errorToast = bootstrap.Toast.getOrCreateInstance(_errorToast)

    // Obtener valores
    const titulo = _titulo.value;
    const descripcion = _descripcion.value;
    const tiempo = _tiempo.value;
    const imagen = _imagen.value;
    const responsable = _responsable.value;
    const estado = _estado.value;

      // Validación
        if(
            titulo === '' || 
            descripcion === '' ||
            tiempo === '' ||
            imagen === '' ||
            responsable === '' ||
            estado === ''
        ) {
            errorToast.show()
            return;
        }

    //Realizar petición a la API
    const res = await addProduct({
        titulo,
        descripcion,
        tiempo,
        imagen,
        responsable,
        estado
    })
    

    successToast.show()
});