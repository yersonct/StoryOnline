(function() {
    const currentPage = window.location.pathname;
    const apiUrlBase = 'http://localhost:8080/api/v1'; // Define la base de la URL de la API

    // Lógica para la página principal de productos (productos.html)
    if (currentPage.includes('productos.html')) {
        const listaProductosElement = document.getElementById('lista-productos');

        function mostrarListadoProductos() {
            fetch(`${apiUrlBase}/product/`) // Reemplaza con la URL correcta de tu API de productos
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`HTTP error! status: ${response.status}`);
                    }
                    return response.json();
                })
                .then(data => {
                    if (listaProductosElement) {
                        data.forEach(producto => { // Asumiendo que la API devuelve un array directamente
                            const productoDiv = document.createElement('div');
                            productoDiv.classList.add('producto-item');

                            const imagenProducto = document.createElement('img');
                            imagenProducto.src = producto.imagenUrl || 'placeholder.png';
                            imagenProducto.alt = producto.name_product; // Usar name_product

                            const nombreProductoH3 = document.createElement('h3');
                            nombreProductoH3.textContent = producto.name_product; // Usar name_product

                            const precioProductoSpan = document.createElement('span');
                            precioProductoSpan.classList.add('precio');
                            precioProductoSpan.textContent = `$${producto.price}`;

                            const seleccionarButton = document.createElement('button');
                            seleccionarButton.textContent = 'Seleccionar';
                            seleccionarButton.addEventListener('click', () => agregarProductoAlCarrito(producto.id_product)); // Modificado a agregar al carrito

                            productoDiv.appendChild(imagenProducto);
                            productoDiv.appendChild(nombreProductoH3);
                            productoDiv.appendChild(precioProductoSpan);
                            productoDiv.appendChild(seleccionarButton);
                            listaProductosElement.appendChild(productoDiv);
                        });
                    }
                })
                .catch(error => {
                    console.error('Error al obtener los productos:', error);
                    if (listaProductosElement) {
                        listaProductosElement.textContent = 'Error al cargar los productos.';
                    }
                });
        }

        function agregarProductoAlCarrito(productoId) {
            const carrito = localStorage.getItem('carrito') ? JSON.parse(localStorage.getItem('carrito')) : [];
            const productoExistente = carrito.find(item => item.id === productoId);

            if (productoExistente) {
                productoExistente.cantidad++;
            } else {
                carrito.push({ id: productoId, cantidad: 1 });
            }

            localStorage.setItem('carrito', JSON.stringify(carrito));
            alert(`Producto con ID ${productoId} agregado al carrito.`);
        }

        document.addEventListener('DOMContentLoaded', mostrarListadoProductos);
    }

    // Lógica para la página del carrito (carrito.html)
    if (currentPage.includes('carrito.html')) {
        const listaCarritoElement = document.getElementById('lista-carrito');
        const totalCarritoElement = document.getElementById('total-carrito');
        const volverProductosButton = document.getElementById('volver-a-productos');

        function mostrarCarrito() {
            const carritoItems = localStorage.getItem('carrito') ? JSON.parse(localStorage.getItem('carrito')) : [];

            if (carritoItems.length > 0) {
                const productIds = carritoItems.map(item => item.id);

                fetch(`${apiUrlBase}/product/selected`, { // Reemplaza con la URL correcta para obtener productos por IDs
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({ ids: productIds }),
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`HTTP error! status: ${response.status}`);
                    }
                    return response.json();
                })
                .then(productos => {
                    if (listaCarritoElement && totalCarritoElement) {
                        listaCarritoElement.innerHTML = '';
                        let total = 0;

                        carritoItems.forEach(itemCarrito => {
                            const producto = productos.find(p => p.id_product === itemCarrito.id);
                            if (producto) {
                                const itemCarritoDiv = document.createElement('div');
                                itemCarritoDiv.classList.add('carrito-item');

                                const nombreProductoH3 = document.createElement('h3');
                                nombreProductoH3.textContent = producto.name_product;

                                const precioProductoSpan = document.createElement('span');
                                precioProductoSpan.classList.add('precio');
                                precioProductoSpan.textContent = `$${producto.price} x ${itemCarrito.cantidad}`;

                                const subtotal = producto.price * itemCarrito.cantidad;
                                total += subtotal;

                                const subtotalSpan = document.createElement('span');
                                subtotalSpan.textContent = `Subtotal: $${subtotal.toFixed(2)}`;

                                itemCarritoDiv.appendChild(nombreProductoH3);
                                itemCarritoDiv.appendChild(precioProductoSpan);
                                itemCarritoDiv.appendChild(subtotalSpan);
                                listaCarritoElement.appendChild(itemCarritoDiv);
                            }
                        });

                        totalCarritoElement.textContent = `Total del carrito: $${total.toFixed(2)}`;
                    }
                })
                .catch(error => {
                    console.error('Error al obtener los detalles del carrito:', error);
                    if (listaCarritoElement) {
                        listaCarritoElement.textContent = 'Error al cargar los productos del carrito.';
                    }
                    if (totalCarritoElement) {
                        totalCarritoElement.textContent = '';
                    }
                });
            } else if (listaCarritoElement) {
                listaCarritoElement.textContent = 'El carrito está vacío.';
                if (totalCarritoElement) {
                    totalCarritoElement.textContent = '';
                }
            }
        }

        if (volverProductosButton) {
            volverProductosButton.addEventListener('click', () => {
                window.location.href = 'productos.html';
            });
        }

        document.addEventListener('DOMContentLoaded', mostrarCarrito);
    }
})();