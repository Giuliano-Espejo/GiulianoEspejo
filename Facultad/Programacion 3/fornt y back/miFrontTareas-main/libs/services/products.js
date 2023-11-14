export function getAllProducts() {
    return fetch('http://localhost:3000/tasks')
    .then(res=>res.json())
    .then(json=>json)
}
 // Busca en la base de datos un registro por su ID - Lo llama detalle js
export function getOneProduct(id){
    return fetch(`http://localhost:3000/tasks/${id}`)
    .then(res=>res.json())
    .then(json=>json)
}

// Se busca por el estdo
export function getProductInCategory(estado){
    return fetch(`http://localhost:3000/tasks?estado=${estado}`)
    .then(res=>res.json())
    .then(json=>json)
}

export function deleteProduct(id){
    return fetch(`http://localhost:3000/tasks/${id}`,{
        method: 'DELETE'
    })
    .then(res=>res.json())
    .then(json=>json)
}

//Usamos PATCH para actualizar solo un campo
export function updateStateProduct(id, newState){
    
    return fetch(`http://localhost:3000/tasks/${id}`,{
        method: 'PATCH',
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            estado: newState
        })
    })
    .then(res=>res.json())
    .then(json=>{
        return json
    })
    .catch(error=> error)
}

//Usamos POST PARA AGREGAR UN PRODUCTO A LA BASE DE DATOS
export function addProduct({
    titulo,
    descripcion,
    tiempo,
    imagen,
    responsable,
    estado
}){
    return fetch(`http://localhost:3000/tasks/`,{
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        },

        body: JSON.stringify({
            titulo:titulo,
            descripcion,
            tiempo,
            imagen,
            responsable,
            estado
        })
    })
    .then(res=>res.json())
    .then(json=>json)

    .catch(error=> error)
}