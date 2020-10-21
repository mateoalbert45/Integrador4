"use strict";
document.querySelector("#submitPostProducto").addEventListener("click", postProducto);
document.querySelector("#submitPutProducto").addEventListener("click", putProducto);
document.querySelector("#deleteProducto").addEventListener("click", deleteProducto);

document.querySelector("#addCliente").addEventListener("click", postCliente);
document.querySelector("#editCliente").addEventListener("click", putCliente);
document.querySelector("#deleteCliente").addEventListener("click", deleteCliente);

document.querySelector("#addCompra").addEventListener("click", postCompra);
document.querySelector("#editCompra").addEventListener("click", putCompra);
document.querySelector("#deleteCompra").addEventListener("click", deleteCompra);

document.querySelector("#addStock").addEventListener("click", postStock);
document.querySelector("#EditStock").addEventListener("click", putStock);
document.querySelector("#deleteStock").addEventListener("click", deleteStock);

document.querySelector("#getClientes").addEventListener("click", getClientes);
document.querySelector("#getComprasXDia").addEventListener("click", getComprasXDia);


document.querySelector("#getProductoMasVendido").addEventListener("click", getProductoMasVendido);

document.querySelector("#verProductos").addEventListener("click", verProductos);


document.querySelector("#addProductoComprar").addEventListener("click", addProductoComprar);
document.querySelector("#finalizarProductoComprar").addEventListener("click", finalizarProductoComprar);


let idProducto = [];


 function postProducto(){ //Método para postear un producto, agarramos los values de los inputs de la pagina, creamos un objeto con esos datos y lo subimos a la base
let id = document.querySelector("#idAddProducto").value;
let nombre = document.querySelector("#idAddNombre").value;
let precio = document.querySelector("#idAddPrecio").value;

let producto = {
      "id": id,
      "nombre": nombre,
       "precio": precio
 };
 console.log(producto);
 let url = "producto/add";
 fetch(url, {
     'method': 'POST',
      'headers': {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
     },
     'body': JSON.stringify(producto)
 })

}
function putProducto(){
  let id = document.querySelector("#idPutProducto").value;
  let nombre = document.querySelector("#idPutNombre").value;
  let precio = document.querySelector("#idPutPrecio").value;
  let producto = {
        "id": id,
        "nombre": nombre,
         "precio": precio,
   };
  let url = "producto/update/" + id;
  fetch(url,{
    "method": "PUT",
    "headers": { "Content-Type": "application/json" },
    "body": JSON.stringify(producto)
  }).then(function(r){
    if(!r.ok){
      console.log("Error")
    }
    return r.json()
  })
  .then(function(json) {
    console.log("ok");
  })
  .catch(function(e){
    console.log(e)
  })
}

function deleteProducto() {
  let id = document.querySelector("#idDeleteProducto").value;
    let url = "stock/delete/" + id;
  fetch(url,{
    "method":"DELETE",
    "headers": { "Content-Type": "application/json" },
    }).then(function(r){
  if(!r.ok){
    console.log("Error")
  }
  return r.json()
})
.then(function(json) {
  console.log("ok");
})
.catch(function(e){
  console.log(e)
  })
}

function postCliente(){ //Método para postear un producto, agarramos los values de los inputs de la pagina, creamos un objeto con esos datos y lo subimos a la base
let id = document.querySelector("#idAddCliente").value;
let nombre = document.querySelector("#nombreAddCliente").value;
let cliente = {
     "id": id,
     "nombre": nombre
};
let url = "cliente/add";
fetch(url, {
    'method': 'POST',
     'headers': {
       'Content-Type': 'application/json',
       'Accept': 'application/json'
    },
    'body': JSON.stringify(cliente)
})
}
function putCliente(){
  let id = document.querySelector("#idPutCliente").value;
  let nombre = document.querySelector("#nombrePutCliente").value;
  let cliente = {
        "id": id,
        "nombre": fecha
   };
   let url = "cliente/update/" + id;
  fetch(url,{
    "method": "PUT",
    "headers": { "Content-Type": "application/json" },
    "body": JSON.stringify(cliente)
  }).then(function(r){
    if(!r.ok){
      console.log("Error")
    }
    return r.json()
  })
  .then(function(json) {
    console.log("ok");
  })
  .catch(function(e){
    console.log(e)
  })
}
function deleteCliente() {
  let id = document.querySelector("#idDeleteCliente").value;
  let url = "cliente/delete/" + id;
  fetch(url,{ //ver XD
    "method":"DELETE",
    }).then(function(r){
  if(!r.ok){
    console.log("Error")
  }
  return r.json()
})
.then(function(json) {
  console.log("ok");
})
.catch(function(e){
  console.log(e)
  })
}

function postCompra(){ //Método para postear un producto, agarramos los values de los inputs de la pagina, creamos un objeto con esos datos y lo subimos a la base
let id = document.querySelector("#idAddCompra").value;
let fecha = document.querySelector("#fechaAddCompra").value;
let url = "compra/add/";

let compra = {
     "id": id,
     "fecha": fecha,
};
fetch(url, {
    'method': 'POST',
     'headers': {
       'Content-Type': 'application/json',
       'Accept': 'application/json'
    },
    'body': JSON.stringify(compra)
})

}
function putCompra(){
  let id = document.querySelector("#idPutCompra").value;
  let fecha = document.querySelector("#fechaPutCompra").value;
  let compra = {
        "id": id,
        "fecha": fecha,
   };
   let url = "compra/update/" + id;
  fetch(url,{
    "method": "PUT",
    "headers": { "Content-Type": "application/json" },
    "body": JSON.stringify(compra)
  }).then(function(r){
    if(!r.ok){
      console.log("Error")
    }
    return r.json()
  })
  .then(function(json) {
    console.log("ok");
  })
  .catch(function(e){
    console.log(e)
  })
}

function deleteCompra() {
  let id = document.querySelector("#idDeleteCompra").value;
  let url = "compra/delete/" + id;
  fetch(url,{
    "method":"DELETE",
    }).then(function(r){
  if(!r.ok){
    console.log("Error")
  }
  return r.json()
})
.then(function(json) {
  console.log("ok");
})
.catch(function(e){
  console.log(e)
  })
}

function postStock(){ //Método para postear un producto, agarramos los values de los inputs de la pagina, creamos un objeto con esos datos y lo subimos a la base
let id = document.querySelector("#idAddStock").value;
let producto = document.querySelector("#idProductoStock").value;
let cantidad = document.querySelector("#idCantidadStock").value;
let url = "stock/add/" + producto;
let stock = {
     "id": id,
     "cantidad": cantidad
};
fetch(url, {
    'method': 'POST',
     'headers': {
       'Content-Type': 'application/json',
       'Accept': 'application/json'
    },
    'body': JSON.stringify(stock)
})

}

function putStock(){
  let id = document.querySelector("#idAddStock").value;
  let producto = document.querySelector("#idProductoStock").value;
  let cantidad = document.querySelector("#idCantidadStock").value;
  let url = "stock/update/" + id;
  let stock = {
        "id": id,
        "producto": producto,
        "cantidad" : cantidad
   };
  fetch(url,{
    "method": "PUT",
    "headers": { "Content-Type": "application/json" },
    "body": JSON.stringify(stock)
  }).then(function(r){
    if(!r.ok){
      console.log("Error")
    }
    return r.json()
  })
  .then(function(json) {
    console.log("ok");
  })
  .catch(function(e){
    console.log(e)
  })
}

function deleteStock() {
  let id = document.querySelector("#idDeleteStock").value;
  let url = "stock/delete/" + id;
  fetch(url,{
    "method":"DELETE",
    }).then(function(r){
  if(!r.ok){
    console.log("Error")
  }
  return r.json()
})
.then(function(json) {
  console.log("ok");
})
.catch(function(e){
  console.log(e)
  })
}



async function getClientes(){
  let  url = "cliente/reporteCompras";
let r = await fetch(url, {
     'method': 'GET',
      'mode':'cors'
 });
let json = await r.json();
console.log(json);
let contenedor = document.querySelector("#contenedorClientes");
contenedor.innerHTML = JSON.stringify(json);
}

async function getComprasXDia(){
  let  url = "compra/reporteComprasPorDia";
let r = await fetch(url, {
     'method': 'GET',
      'mode':'cors'
 });
let json = await r.json();
console.log(json);
let contenedor = document.querySelector("#contenedorCompras");
contenedor.innerHTML = JSON.stringify(json);
}

function comprar() {
  let id = document.querySelector("#idDeleteStock").value;
  let url = "stock/delete/" + id;
  let productos = document.querySelectorAll("#insertarComentario");
  botoncrearcomentario.forEach();
  fetch(url,{
    "method":"DELETE",
    }).then(function(r){
  if(!r.ok){
    console.log("Error")
  }
  return r.json()
})
.then(function(json) {
  console.log("ok");
})
.catch(function(e){
  console.log(e)
  })
}


async function getProductoMasVendido(){
  let  url = "producto/masVendido";
let r = await fetch(url, {
     'method': 'GET',
      'mode':'cors'
 });
let json = await r.json();
console.log(json);
let contenedor = document.querySelector("#contenedorProducto");
contenedor.innerHTML = JSON.stringify(json);
}

async function verProductos(){
  let  url = "producto/getAll";
let r = await fetch(url, {
     'method': 'GET',
      'mode':'cors'
 });
let json = await r.json();
console.log(json);
let contenedor = document.querySelector("#contenedorProductos");
contenedor.innerHTML = JSON.stringify(json);
}

function addProductoComprar(){
  let id = document.querySelector("#idProductoComprar");
  idProducto.push(id);
}

function replacer(key, value) {
  // Filtrando propiedades
  if (typeof value === "string") {
    return undefined;
  }
  return value;
}


async function getProductoMasVendido(){
  let  url = "producto/masVendido";
let r = await fetch(url, {
     'method': 'GET',
      'mode':'cors'
 });
let json = await r.json();
console.log(json);
let contenedor = document.querySelector("#contenedorProducto");
contenedor.innerHTML = JSON.stringify(json);
}


function finalizarProductoComprar(){
  let idCliente = document.querySelector("#idClienteComprar").value;
  let idCompra = document.querySelector("#idCompraComprar").value;
  let today = new Date();
  let date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
  let foo = [
    {"id":1,"nombre":"Cepita","precio":75.0},
    {"id":2,"nombre":"Arroz","precio":15.0}
            ];

    let compra = {
                 "id": idCompra,
                 "fechaDeCompra": today,
                 "productos" :    [ {
         "id":2,
         "nombre":"Arroz",
         "precio":15.0
       }]

            };
  console.log(compra);

  let  url = "cliente/comprar/" +idCliente;
  fetch(url, {
      'method': 'POST',
       'headers': {
         'Content-Type': 'application/json',
         'Accept': 'application/json'
      },
      'body': JSON.stringify(compra)
  })



  // fetch(url, {
  //     'method': 'POST',
  //      'headers': {
  //        'Content-Type': 'application/json',
  //        'Accept': 'application/json'
  //     },
  //     'body': JSON.stringify(stock)
  // })
}
