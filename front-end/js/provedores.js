function mostrarListadoProveedores() {
    const listaProveedoresElement = document.getElementById('lista-proveedores');

    fetch('../json/provedores.json')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            data.proveedores.forEach(proveedor => {
                const proveedorDiv = document.createElement('div');
                proveedorDiv.classList.add('proveedor-item');
                proveedorDiv.textContent = proveedor.nombre;
                proveedorDiv.addEventListener('click', () => mostrarDetalleProveedor(proveedor)); // Pasamos el objeto proveedor completo
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
        nombreH2.textContent = proveedor.nombre;

        const contactoP = document.createElement('p');
        contactoP.textContent = `Contacto: ${proveedor.contacto}`;

        const telefonoP = document.createElement('p');
        telefonoP.textContent = `Teléfono: ${proveedor.telefono}`;

        const emailP = document.createElement('p');
        emailP.textContent = `Email: ${proveedor.email}`;

        detalleProveedorElement.appendChild(nombreH2);
        detalleProveedorElement.appendChild(contactoP);
        detalleProveedorElement.appendChild(telefonoP);
        detalleProveedorElement.appendChild(emailP);

        if (proveedor.productos && proveedor.productos.length > 0) {
            const productosH3 = document.createElement('h3');
            productosH3.textContent = 'Productos:';
            detalleProveedorElement.appendChild(productosH3);

            const productosGrid = document.createElement('div');
            productosGrid.classList.add('productos-grid');

            proveedor.productos.forEach(producto => {
                const productoCaja = document.createElement('div');
                productoCaja.classList.add('producto-caja');

                const nombreProductoH4 = document.createElement('h4');
                nombreProductoH4.textContent = producto.nombre;

                const descripcionProductoP = document.createElement('p');
                descripcionProductoP.textContent = producto.descripcion;

                const precioProductoP = document.createElement('p');
                precioProductoP.textContent = `Precio: $${producto.precio}`;

                productoCaja.appendChild(nombreProductoH4);
                productoCaja.appendChild(descripcionProductoP);
                productoCaja.appendChild(precioProductoP);

                productosGrid.appendChild(productoCaja);
            });

            detalleProveedorElement.appendChild(productosGrid);
        } else {
            const noProductosP = document.createElement('p');
            noProductosP.textContent = 'Este proveedor no tiene productos disponibles.';
            detalleProveedorElement.appendChild(noProductosP);
        }

    } else {
        detalleProveedorElement.textContent = 'Proveedor no encontrado.';
    }
}

document.addEventListener('DOMContentLoaded', mostrarListadoProveedores);