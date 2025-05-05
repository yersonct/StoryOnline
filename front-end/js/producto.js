// --- Funciones para Productos (Mostrar todos los datos menos id_product) ---
function mostrarListadoProductos() {
    const listaProductosElement = document.getElementById('lista-productos');
    const apiUrlProductos = 'http://localhost:8080/api/v1/product/';

    fetch(apiUrlProductos)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            data.forEach(producto => {
                const productoDiv = document.createElement('div');
                productoDiv.classList.add('producto-item');
                productoDiv.addEventListener('click', () => mostrarDetalleProducto(producto)); // Pasamos el objeto completo

                const nombreProductoH3 = document.createElement('h3');
                nombreProductoH3.textContent = producto.name_product;

                const precioProductoSpan = document.createElement('span');
                precioProductoSpan.classList.add('precio');
                precioProductoSpan.textContent = `$${producto.price}`;

                productoDiv.appendChild(nombreProductoH3);
                productoDiv.appendChild(precioProductoSpan);
                listaProductosElement.appendChild(productoDiv);
            });
        })
        .catch(error => {
            console.error('Error al obtener los productos:', error);
            listaProductosElement.textContent = 'Error al cargar los productos.';
        });
}

function mostrarDetalleProducto(producto) {
    const detalleProductoElement = document.getElementById('detalle-producto');
    detalleProductoElement.innerHTML = '';

    if (producto) {
        const nombreH2 = document.createElement('h2');
        nombreH2.textContent = producto.name_product;

        const descripcionP = document.createElement('p');
        descripcionP.textContent = `Descripción: ${producto.description || 'No disponible'}`;

        const precioP = document.createElement('p');
        precioP.classList.add('precio');
        precioP.textContent = `Precio: $${producto.price}`;
        precioP.style.fontSize = '1.2em';
        precioP.style.fontWeight = 'bold';

        detalleProductoElement.appendChild(nombreH2);
        detalleProductoElement.appendChild(descripcionP);
        detalleProductoElement.appendChild(precioP);

        // Puedes añadir más detalles si tu API los proporciona
    } else {
        detalleProductoElement.textContent = 'Producto no encontrado.';
    }
}

// --- Funciones para Proveedores (Mostrar todos los datos menos id_supplier) ---
function mostrarListadoProveedores() {
    const listaProveedoresElement = document.getElementById('lista-proveedores');
    const apiUrlProveedores = 'http://localhost:8080/api/v1/supplier/';

    fetch(apiUrlProveedores)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            data.forEach(proveedor => {
                const proveedorDiv = document.createElement('div');
                proveedorDiv.classList.add('proveedor-item');
                proveedorDiv.textContent = proveedor.name_supplier;
                proveedorDiv.addEventListener('click', () => mostrarDetalleProveedor(proveedor));
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

    } else {
        detalleProveedorElement.textContent = 'Proveedor no encontrado.';
    }
}

// --- Evento para cargar las listas al cargar el DOM ---
document.addEventListener('DOMContentLoaded', () => {
    mostrarListadoProductos();
    mostrarListadoProveedores();
});