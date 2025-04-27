document.addEventListener('DOMContentLoaded', () => {
    const listaProductosCompradosElement = document.getElementById('lista-productos-comprados');
    const totalCompraElement = document.getElementById('total-compra');
    const volverProductosButton = document.getElementById('volver-a-productos');

    // Simulación de obtener los detalles de la compra desde localStorage
    const compraString = localStorage.getItem('detallesCompra');
    const detallesCompra = compraString ? JSON.parse(compraString) : null;

    function mostrarDetallesCompra(compra) {
        listaProductosCompradosElement.innerHTML = '';
        let total = 0;

        if (compra && compra.items && compra.items.length > 0) {
            compra.items.forEach(item => {
                const productoItem = document.createElement('div');
                productoItem.classList.add('producto-comprado-item');

                const imagenProducto = document.createElement('img');
                imagenProducto.src = item.imagenUrl || 'placeholder.png';
                imagenProducto.alt = item.name;

                const infoProducto = document.createElement('div');
                infoProducto.classList.add('producto-comprado-info');
                const nombreProductoH4 = document.createElement('h4');
                nombreProductoH4.textContent = item.name;
                const precioProductoP = document.createElement('p');
                precioProductoP.textContent = `Precio unitario: $${item.price}`;
                infoProducto.appendChild(nombreProductoH4);
                infoProducto.appendChild(precioProductoP);

                const cantidadProductoSpan = document.createElement('span');
                cantidadProductoSpan.classList.add('producto-comprado-cantidad');
                cantidadProductoSpan.textContent = `Cantidad: ${item.quantity}`;

                productoItem.appendChild(imagenProducto);
                productoItem.appendChild(infoProducto);
                productoItem.appendChild(cantidadProductoSpan);
                listaProductosCompradosElement.appendChild(productoItem);

                total += item.price * item.quantity;
            });

            totalCompraElement.textContent = `Total de la compra: $${total.toFixed(2)}`;

        } else {
            listaProductosCompradosElement.textContent = 'No hay productos en tu compra.';
            totalCompraElement.textContent = '';
        }
    }

    if (detallesCompra && detallesCompra.items) {
        mostrarDetallesCompra(detallesCompra);
        // Opcional: podrías también hacer una petición a la API para confirmar los detalles
    } else {
        // Si no hay información en localStorage, intentar obtenerla de la API
        fetch('../json/envio.json') // Reemplaza con la URL correcta para obtener los detalles de la compra
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(compra => {
                mostrarDetallesCompra(compra);
                // Opcional: guardar la información en localStorage
                localStorage.setItem('detallesCompra', JSON.stringify(compra));
            })
            .catch(error => {
                console.error('Error al obtener los detalles de la compra:', error);
                listaProductosCompradosElement.textContent = 'Error al cargar los detalles de tu compra.';
                totalCompraElement.textContent = '';
            });
    }

    volverProductosButton.addEventListener('click', () => {
        window.location.href = 'productos.html';
    });
});