document.addEventListener('DOMContentLoaded', () => {
    const listaProductosCompradosElement = document.getElementById('lista-productos-comprados');
    const totalCompraElement = document.getElementById('total-compra');
    const volverProductosButton = document.getElementById('volver-a-productos');
    const apiUrlReview = 'http://localhost:8080/api/v1/review/'; // URL de tu API de reseñas
    const apiUrlShipment = 'http://localhost:8080/api/v1/shipment/'; // URL de tu API de envíos

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

                const calificarButton = document.createElement('button');
                calificarButton.textContent = 'Calificar';
                calificarButton.addEventListener('click', () => mostrarFormularioCalificacion(item.id)); // Asume que cada item tiene un ID

                productoItem.appendChild(imagenProducto);
                productoItem.appendChild(infoProducto);
                productoItem.appendChild(cantidadProductoSpan);
                productoItem.appendChild(calificarButton);
                listaProductosCompradosElement.appendChild(productoItem);

                total += item.price * item.quantity;
            });

            totalCompraElement.textContent = `Total de la compra: $${total.toFixed(2)}`;

            // Opcional: Mostrar información de envío si está disponible en 'detallesCompra'
            if (detallesCompra.shipmentId) {
                mostrarInformacionEnvio(detallesCompra.shipmentId);
            }

        } else {
            listaProductosCompradosElement.textContent = 'No hay productos en tu compra.';
            totalCompraElement.textContent = '';
        }
    }

    function mostrarFormularioCalificacion(productId) {
        const formularioCalificacion = document.createElement('div');
        formularioCalificacion.classList.add('formulario-calificacion');
        formularioCalificacion.innerHTML = `
            <h3>Calificar Producto</h3>
            <label for="calificacion-${productId}">Calificación (1-5):</label>
            <input type="number" id="calificacion-${productId}" min="1" max="5">
            <label for="comentario-${productId}">Comentario:</label>
            <textarea id="comentario-${productId}"></textarea>
            <button onclick="enviarCalificacion(${productId})">Enviar Calificación</button>
        `;
        document.body.appendChild(formularioCalificacion); // Añade el formulario al body o a un contenedor específico
    }

    // Esta función debe ser global para ser accesible desde el onclick del botón
    window.enviarCalificacion = function(productId) {
        const calificacionInput = document.getElementById(`calificacion-${productId}`);
        const comentarioInput = document.getElementById(`comentario-${productId}`);

        if (calificacionInput && comentarioInput) {
            const calificacion = parseInt(calificacionInput.value);
            const comentario = comentarioInput.value;

            if (calificacion >= 1 && calificacion <= 5) {
                const nuevaResena = {
                    qualification: calificacion,
                    comment: comentario,
                    date: new Date().toISOString().split('T')[0], // Formato YYYY-MM-DD
                    id_product: productId // Asume que el item de compra tiene un id
                    // id_user: Obtener el ID del usuario actual (necesitarás lógica para esto)
                };

                fetch(apiUrlReview, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(nuevaResena)
                })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`HTTP error! status: ${response.status}`);
                    }
                    return response.json();
                })
                .then(data => {
                    console.log('Reseña enviada con éxito:', data);
                    alert('Gracias por tu calificación!');
                    const formulario = document.querySelector('.formulario-calificacion');
                    if (formulario) {
                        formulario.remove(); // Elimina el formulario después de enviar
                    }
                    // Opcional: Actualizar la lista de productos comprados
                })
                .catch(error => {
                    console.error('Error al enviar la calificación:', error);
                    alert('Hubo un error al enviar tu calificación.');
                });
            } else {
                alert('Por favor, ingresa una calificación entre 1 y 5.');
            }
        }
    };

    function mostrarInformacionEnvio(shipmentId) {
        fetch(`${apiUrlShipment}${shipmentId}`)
            .then(response => {
                if (!response.ok) {
                    console.error(`Error al obtener la información de envío (ID: ${shipmentId}):`, response.status);
                    return null;
                }
                return response.json();
            })
            .then(shipment => {
                if (shipment) {
                    const infoEnvioDiv = document.createElement('div');
                    infoEnvioDiv.classList.add('info-envio');
                    infoEnvioDiv.innerHTML = `
                        <h3>Información de Envío</h3>
                        <p><strong>ID de Envío:</strong> ${shipment.id_shipment}</p>
                        <p><strong>Dirección:</strong> ${shipment.address}</p>
                        <p><strong>Empresa de Envío:</strong> ${shipment.companyShipping}</p>
                        <p><strong>Fecha de Envío:</strong> ${shipment.shippingDate}</p>
                        <p><strong>Fecha de Entrega Estimada:</strong> ${shipment.deliveryDate}</p>
                        <p><strong>Estado del Envío:</strong> ${shipment.state ? 'Enviado' : 'Pendiente'}</p>
                    `;
                    const contenedorPrincipal = document.querySelector('.contenedor-principal') || document.body; // Ajusta el selector si es necesario
                    contenedorPrincipal.appendChild(infoEnvioDiv);
                }
            })
            .catch(error => {
                console.error('Error al obtener la información de envío:', error);
            });
    }

    if (detallesCompra && detallesCompra.items) {
        mostrarDetallesCompra(detallesCompra);
        // Opcional: podrías también hacer una petición a la API para confirmar los detalles
    } else {
        // Si no hay información en localStorage, intentar obtenerla de la API
        fetch('../json/envio.json') // Reemplaza con la URL correcta para obtener los detalles de la compra (podría incluir el shipmentId)
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
                // Si la información de envío viene con los detalles de la compra:
                if (compra.shipmentId) {
                    mostrarInformacionEnvio(compra.shipmentId);
                }
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