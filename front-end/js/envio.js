document.addEventListener('DOMContentLoaded', () => {
    const listaProductosCompradosElement = document.getElementById('lista-productos-comprados');
    const orderIdSpan = document.getElementById('order-id');
    const subtotalValueSpan = document.getElementById('subtotal-value');
    const shippingValueSpan = document.getElementById('shipping-value');
    const totalValueSpan = document.getElementById('total-value');
    const volverProductosButton = document.getElementById('volver-a-productos');
    const infoEnvioContainer = document.getElementById('info-envio-container');

    const loadingProductsState = document.getElementById('loading-products');
    const loadingShipmentState = document.getElementById('loading-shipment');
    const emptyShipmentState = document.getElementById('empty-shipment');

    // URLs for your APIs
    const apiUrlReview = 'http://localhost:8080/api/v1/review/';
    // This URL for shipment should typically take an ID, e.g., /api/v1/shipment/{id}
    const apiUrlShipmentBase = 'http://localhost:8080/api/v1/shipment/';

    // Function to format the date (optional)
    function formatDate(dateString) {
        if (!dateString) return 'N/A';
        const date = new Date(dateString);
        // Add 1 day to the date if it's consistently off by one due to timezone issues
        // date.setDate(date.getDate() + 1); 
        const options = { year: 'numeric', month: 'long', day: 'numeric' };
        return date.toLocaleDateString('es-CO', options);
    }

    // --- Product and Order Details Handling ---
    function mostrarDetallesCompra(compra) {
        loadingProductsState.style.display = 'none'; // Hide loading state for products

        if (compra && compra.items && compra.items.length > 0) {
            listaProductosCompradosElement.innerHTML = ''; // Clear existing content
            let subtotal = 0;
            const shippingCost = 5.00; // Example shipping cost

            compra.items.forEach(item => {
                const productoItem = document.createElement('div');
                productoItem.classList.add('producto-comprado-item');

                productoItem.innerHTML = `
                    <img src="${item.imagenUrl || 'https://via.placeholder.com/80?text=Producto'}" alt="${item.name}">
                    <div class="producto-comprado-info">
                        <h4>${item.name}</h4>
                        <p>Precio unitario: $${parseFloat(item.price).toFixed(2)}</p>
                    </div>
                    <span class="producto-comprado-cantidad">Cantidad: ${item.quantity}</span>
                    <button class="btn-primary calificar-btn" data-product-id="${item.id}">Calificar</button>
                `;
                listaProductosCompradosElement.appendChild(productoItem);

                subtotal += parseFloat(item.price) * parseInt(item.quantity);
            });

            subtotalValueSpan.textContent = subtotal.toFixed(2);
            shippingValueSpan.textContent = shippingCost.toFixed(2);
            totalValueSpan.textContent = (subtotal + shippingCost).toFixed(2);
            orderIdSpan.textContent = `Pedido #${compra.orderId || 'Desconocido'}`;

            // Add event listeners for "Calificar" buttons
            document.querySelectorAll('.calificar-btn').forEach(button => {
                button.addEventListener('click', (event) => {
                    const productId = event.target.dataset.productId;
                    mostrarFormularioCalificacion(productId);
                });
            });

        } else {
            listaProductosCompradosElement.innerHTML = `
                <div class="empty-state">
                    <span class="empty-icon"><i class="fas fa-box-open fa-3x"></i></span>
                    <h3>No hay productos en esta compra.</h3>
                    <p>Parece que este pedido no tiene productos asociados.</p>
                </div>
            `;
            subtotalValueSpan.textContent = '0.00';
            shippingValueSpan.textContent = '0.00';
            totalValueSpan.textContent = '0.00';
            orderIdSpan.textContent = 'Pedido #N/A';
        }
    }

    // --- Review Form Handling ---
    function mostrarFormularioCalificacion(productId) {
        const existingForm = document.querySelector('.formulario-calificacion-overlay');
        if (existingForm) {
            existingForm.remove(); // Remove any existing form to prevent duplicates
        }

        const overlay = document.createElement('div');
        overlay.classList.add('formulario-calificacion-overlay'); // Add a class for styling the overlay

        const formularioCalificacion = document.createElement('div');
        formularioCalificacion.classList.add('formulario-calificacion-modal');
        formularioCalificacion.innerHTML = `
            <h3>Calificar Producto</h3>
            <div class="form-group">
                <label for="calificacion-${productId}">Calificación (1-5):</label>
                <input type="number" id="calificacion-${productId}" min="1" max="5" value="5">
            </div>
            <div class="form-group">
                <label for="comentario-${productId}">Comentario:</label>
                <textarea id="comentario-${productId}" rows="4" placeholder="Comparte tu opinión sobre el producto..."></textarea>
            </div>
            <div class="form-actions">
                <button class="btn-primary" id="enviar-calificacion-btn">Enviar Calificación</button>
                <button class="btn-secondary" id="cerrar-calificacion-btn">Cerrar</button>
            </div>
        `;
        overlay.appendChild(formularioCalificacion);
        document.body.appendChild(overlay); // Add the form to the body

        // Event listeners for the modal
        document.getElementById('enviar-calificacion-btn').addEventListener('click', () => {
            enviarCalificacion(productId);
        });

        document.getElementById('cerrar-calificacion-btn').addEventListener('click', () => {
            overlay.remove();
        });

        overlay.addEventListener('click', (e) => {
            if (e.target === overlay) {
                overlay.remove();
            }
        });
    }

    // This function is called by the 'Enviar Calificación' button
    window.enviarCalificacion = function(productId) {
        const calificacionInput = document.getElementById(`calificacion-${productId}`);
        const comentarioInput = document.getElementById(`comentario-${productId}`);

        if (calificacionInput && comentarioInput) {
            const qualification = parseInt(calificacionInput.value);
            const comment = comentarioInput.value;

            if (qualification >= 1 && qualification <= 5) {
                const newReview = {
                    qualification: qualification,
                    comment: comment,
                    date: new Date().toISOString().split('T')[0], // Format YYYY-MM-DD
                    id_product: productId,
                    id_user: 123 // You need actual user ID from session/auth
                };

                fetch(apiUrlReview, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(newReview)
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
                    const formulario = document.querySelector('.formulario-calificacion-overlay');
                    if (formulario) {
                        formulario.remove(); // Remove the form after sending
                    }
                    // Optional: Update the list of purchased products or simply provide feedback
                })
                .catch(error => {
                    console.error('Error al enviar la calificación:', error);
                    alert('Hubo un error al enviar tu calificación. Por favor, inténtalo de nuevo.');
                });
            } else {
                alert('Por favor, ingresa una calificación entre 1 y 5.');
            }
        }
    };

    // --- Shipment Information Handling ---
    function mostrarInformacionEnvio(shipmentId) {
        loadingShipmentState.style.display = 'flex'; // Show loading state for shipment
        emptyShipmentState.style.display = 'none'; // Hide empty state

        // Simulate fetching shipment data
        const simulatedShipmentData = {
            "id_shipment": 1,
            "address": "Dirección de Envío Completa, Ciudad, País",
            "state": true,
            "companyShipping": "Nombre de la Empresa de Envío",
            "shippingDate": "2025-05-06",
            "deliveryDate": "2025-05-10"
        };

        setTimeout(() => { // Simulate network delay
            loadingShipmentState.style.display = 'none'; // Hide loading state

            const shipment = simulatedShipmentData; // Use the simulated data

            if (shipment) {
                const infoEnvioDiv = document.createElement('div');
                infoEnvioDiv.classList.add('info-envio-card'); // Use a new class for styling
                infoEnvioDiv.innerHTML = `
                    <h3>Información de Envío</h3>
                    <p><strong>ID de Envío:</strong> ${shipment.id_shipment}</p>
                    <p><strong>Dirección:</strong> ${shipment.address}</p>
                    <p><strong>Empresa de Envío:</strong> ${shipment.companyShipping}</p>
                    <p><strong>Fecha de Envío:</strong> ${formatDate(shipment.shippingDate)}</p>
                    <p><strong>Fecha de Entrega Estimada:</strong> ${formatDate(shipment.deliveryDate)}</p>
                    <p><strong>Estado del Envío:</strong> 
                        <span class="estado-envio ${shipment.state ? 'enviado' : 'pendiente'}">
                            ${shipment.state ? 'Enviado' : 'Pendiente'}
                        </span>
                    </p>
                `;
                infoEnvioContainer.innerHTML = ''; // Clear loading/empty states
                infoEnvioContainer.appendChild(infoEnvioDiv);
            } else {
                emptyShipmentState.style.display = 'flex'; // Show empty state for shipment
            }
        }, 1500); // Simulate 1.5-second delay

        /*
        // Uncomment this block and remove the simulated data above to use a real API
        fetch(`${apiUrlShipmentBase}${shipmentId}`)
            .then(response => {
                if (!response.ok) {
                    if (response.status === 404) {
                        console.warn(`No shipment found for ID: ${shipmentId}`);
                        return null;
                    }
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(shipment => {
                loadingShipmentState.style.display = 'none'; // Hide loading state
                if (shipment) {
                    const infoEnvioDiv = document.createElement('div');
                    infoEnvioDiv.classList.add('info-envio-card');
                    infoEnvioDiv.innerHTML = `
                        <h3>Información de Envío</h3>
                        <p><strong>ID de Envío:</strong> ${shipment.id_shipment}</p>
                        <p><strong>Dirección:</strong> ${shipment.address}</p>
                        <p><strong>Empresa de Envío:</strong> ${shipment.companyShipping}</p>
                        <p><strong>Fecha de Envío:</strong> ${formatDate(shipment.shippingDate)}</p>
                        <p><strong>Fecha de Entrega Estimada:</strong> ${formatDate(shipment.deliveryDate)}</p>
                        <p><strong>Estado del Envío:</strong> 
                            <span class="estado-envio ${shipment.state ? 'enviado' : 'pendiente'}">
                                ${shipment.state ? 'Enviado' : 'Pendiente'}
                            </span>
                        </p>
                    `;
                    infoEnvioContainer.innerHTML = ''; // Clear loading/empty states
                    infoEnvioContainer.appendChild(infoEnvioDiv);
                } else {
                    emptyShipmentState.style.display = 'flex'; // Show empty state
                }
            })
            .catch(error => {
                loadingShipmentState.style.display = 'none'; // Hide loading state
                console.error('Error al obtener la información de envío:', error);
                infoEnvioContainer.innerHTML = `
                    <div class="empty-state">
                        <span class="empty-icon"><i class="fas fa-exclamation-triangle fa-3x"></i></span>
                        <h3>Error al cargar la información de envío.</h3>
                        <p>Por favor, inténtalo de nuevo más tarde.</p>
                    </div>
                `;
            });
        */
    }

    // --- Initial Page Load Logic ---
    // Simulate initial product data (this would come from a server or localStorage)
    const simulatedProductData = {
        orderId: 'XYZ12345',
        shipmentId: 1, // This ID will be used to fetch shipment details
        items: [
            { id: 101, name: 'Laptop Pro X', price: 1200.00, quantity: 1, imagenUrl: 'https://via.placeholder.com/80/6366f1/ffffff?text=Laptop' },
            { id: 102, name: 'Monitor UltraWide', price: 350.00, quantity: 2, imagenUrl: 'https://via.placeholder.com/80/10b981/ffffff?text=Monitor' },
            { id: 103, name: 'Teclado Mecánico', price: 80.00, quantity: 1, imagenUrl: 'https://via.placeholder.com/80/f59e0b/ffffff?text=Teclado' }
        ]
    };

    // Use a delay to simulate loading products initially
    loadingProductsState.style.display = 'flex'; // Show product loading
    setTimeout(() => {
        mostrarDetallesCompra(simulatedProductData);
        // Once product details are loaded, trigger shipment info
        if (simulatedProductData.shipmentId) {
            mostrarInformacionEnvio(simulatedProductData.shipmentId);
        }
    }, 1000); // Simulate 1-second delay for product loading

    // Button to go back to products
    volverProductosButton.addEventListener('click', () => {
        window.location.href = 'productos.html';
    });
});