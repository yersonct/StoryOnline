function mostrarListadoProveedores() {
    const listaProveedoresElement = document.getElementById('lista-proveedores');
    const apiUrl = 'http://localhost:8080/api/v1/supplier/'; // URL de tu API de proveedores

    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            data.forEach(proveedor => { // La respuesta ahora es un array directamente
                const proveedorDiv = document.createElement('div');
                proveedorDiv.classList.add('proveedor-item');
                proveedorDiv.textContent = proveedor.name_supplier; // Mostrar el nombre en la lista
                proveedorDiv.addEventListener('click', () => mostrarDetalleProveedor(proveedor)); // Pasar el objeto completo
                listaProveedoresElement.appendChild(proveedorDiv);
            });
        })
        .catch(error => {
            console.error('Error al obtener los proveedores:', error);
            listaProveedoresElement.textContent = 'Error al cargar los proveedores.';
        });
}

function mostrarDetalleProveedor(proveedor) {
    const detalleProveedorElement = document.getElementById('detalle-proveedor');
    detalleProveedorElement.innerHTML = '';

    if (proveedor) {
        const nombreH2 = document.createElement('h2');
        nombreH2.textContent = proveedor.name_supplier;

        const contactoP = document.createElement('p');
        contactoP.textContent = `Contacto: ${proveedor.contact_supplie || 'No disponible'}`;

        const telefonoP = document.createElement('p');
        telefonoP.textContent = `Teléfono: ${proveedor.phone || 'No disponible'}`;

        detalleProveedorElement.appendChild(nombreH2);
        detalleProveedorElement.appendChild(contactoP);
        detalleProveedorElement.appendChild(telefonoP);

        // Aquí puedes añadir lógica adicional para mostrar los productos del proveedor
        // si tu API devuelve esa información dentro del objeto proveedor.
        // Por ejemplo:
        // if (proveedor.productos && Array.isArray(proveedor.productos)) {
        //     const productosH3 = document.createElement('h3');
        //     productosH3.textContent = 'Productos:';
        //     detalleProveedorElement.appendChild(productosH3);
        //     const productosListaUl = document.createElement('ul');
        //     proveedor.productos.forEach(producto => {
        //         const productoLi = document.createElement('li');
        //         productoLi.textContent = producto.name || producto.name_product || 'Sin nombre';
        //         productosListaUl.appendChild(productoLi);
        //     });
        //     detalleProveedorElement.appendChild(productosListaUl);
        // }
    } else {
        detalleProveedorElement.textContent = 'Proveedor no encontrado.';
    }
}

document.addEventListener('DOMContentLoaded', mostrarListadoProveedores);