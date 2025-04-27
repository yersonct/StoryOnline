(function() {
    const currentPage = window.location.pathname;

    // Lógica para la página principal de productos (productos.html)
    if (currentPage.includes('productos.html')) {
        const listaProductosElement = document.getElementById('lista-productos');

        function mostrarListadoProductos() {
            fetch('/api/productos') // Reemplaza con la URL de tu API de productos
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`HTTP error! status: ${response.status}`);
                    }
                    return response.json();
                })
                .then(data => {
                    if (listaProductosElement) {
                        data.productos.forEach(producto => {
                            const productoDiv = document.createElement('div');
                            productoDiv.classList.add('producto-item');

                            const imagenProducto = document.createElement('img');
                            imagenProducto.src = producto.imagenUrl || 'placeholder.png';
                            imagenProducto.alt = producto.name;

                            const nombreProductoH3 = document.createElement('h3');
                            nombreProductoH3.textContent = producto.name;

                            const precioProductoSpan = document.createElement('span');
                            precioProductoSpan.classList.add('precio');
                            precioProductoSpan.textContent = `$${producto.price}`;

                            const seleccionarButton = document.createElement('button');
                            seleccionarButton.textContent = 'Seleccionar';
                            seleccionarButton.addEventListener('click', () => agregarProductoSeleccionado(producto.id));

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

        function agregarProductoSeleccionado(productoId) {
            const productosSeleccionadosIds = localStorage.getItem('productosSeleccionados');
            let idsArray = productosSeleccionadosIds ? JSON.parse(productosSeleccionadosIds) : [];

            if (!idsArray.includes(productoId)) {
                idsArray.push(productoId);
                localStorage.setItem('productosSeleccionados', JSON.stringify(idsArray));
                alert(`Producto con ID ${productoId} seleccionado.`);
            } else {
                alert(`El producto con ID ${productoId} ya está seleccionado.`);
            }
        }

        document.addEventListener('DOMContentLoaded', mostrarListadoProductos);
    }

    // Lógica para la página de productos seleccionados (productos_seleccionados.html)
    if (currentPage.includes('productos_seleccionados.html')) {
        const listaProductosSeleccionadosElement = document.getElementById('lista-productos-seleccionados');
        const volverProductosButton = document.getElementById('volver-a-productos');

        function mostrarProductosSeleccionados() {
            const productosSeleccionadosIds = localStorage.getItem('productosSeleccionados');
            const idsArray = productosSeleccionadosIds ? JSON.parse(productosSeleccionadosIds) : [];

            if (idsArray.length > 0) {
                fetch('/api/productos/seleccionados', { // Reemplaza con la URL correcta
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({ ids: idsArray }),
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`HTTP error! status: ${response.status}`);
                    }
                    return response.json();
                })
                .then(productos => {
                    if (listaProductosSeleccionadosElement) {
                        listaProductosSeleccionadosElement.innerHTML = '';
                        if (productos && productos.length > 0) {
                            productos.forEach(producto => {
                                const productoDiv = document.createElement('div');
                                productoDiv.classList.add('producto-seleccionado-item');

                                const imagenProducto = document.createElement('img');
                                imagenProducto.src = producto.imagenUrl || 'placeholder.png';
                                imagenProducto.alt = producto.name;

                                const nombreProductoH3 = document.createElement('h3');
                                nombreProductoH3.textContent = producto.name;

                                const precioProductoSpan = document.createElement('span');
                                precioProductoSpan.classList.add('precio');
                                precioProductoSpan.textContent = `$${producto.price}`;

                                productoDiv.appendChild(imagenProducto);
                                productoDiv.appendChild(nombreProductoH3);
                                productoDiv.appendChild(precioProductoSpan);
                                listaProductosSeleccionadosElement.appendChild(productoDiv);
                            });
                        } else {
                            listaProductosSeleccionadosElement.textContent = 'No has seleccionado ningún producto aún.';
                        }
                    }
                })
                .catch(error => {
                    console.error('Error al obtener los productos seleccionados:', error);
                    if (listaProductosSeleccionadosElement) {
                        listaProductosSeleccionadosElement.textContent = 'Error al cargar los productos seleccionados.';
                    }
                });
            } else if (listaProductosSeleccionadosElement) {
                listaProductosSeleccionadosElement.textContent = 'No has seleccionado ningún producto aún.';
            }
        }

        if (volverProductosButton) {
            volverProductosButton.addEventListener('click', () => {
                window.location.href = 'productos.html';
            });
        }

        document.addEventListener('DOMContentLoaded', mostrarProductosSeleccionados);
    }
})();