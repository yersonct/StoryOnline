document.addEventListener('DOMContentLoaded', () => {
    const infoOrdenElement = document.getElementById('info-orden');
    const volverHistorialButton = document.getElementById('volver-a-historial');
    const apiUrlOrden = 'http://localhost:8080/api/v1/Orders/'; // URL de tu API de órdenes

    // Función para obtener el ID de la orden de la URL (activar si es necesario)
    function getOrderIdFromUrl() {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get('id');
    }

    const orderId = getOrderIdFromUrl(); // Intenta obtener el ID de la URL

    let fetchUrl;
    if (orderId) {
        fetchUrl = `${apiUrlOrden}${orderId}`; // Si hay ID, busca una orden específica
    } else {
        fetchUrl = apiUrlOrden; // Si no hay ID, busca todas las órdenes (ajusta si es necesario)
    }

    fetch(fetchUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // Si se proporcionó un ID, 'data' debería ser un objeto de orden
            if (orderId && data && data.id_order) {
                mostrarDetalleOrden(data);
            }
            // Si no se proporcionó un ID, 'data' debería ser un array de órdenes (ajusta si es necesario)
            else if (!orderId && Array.isArray(data)) {
                // Aquí podrías mostrar una lista de órdenes en lugar del detalle
                console.log("Lista de órdenes:", data);
                infoOrdenElement.textContent = 'Lista de órdenes cargada (revisa la consola).';
                // Si quieres mostrar la primera orden por defecto:
                if (data.length > 0) {
                    mostrarDetalleOrden(data[0]);
                }
            } else {
                infoOrdenElement.textContent = 'No se encontraron órdenes.';
            }
        })
        .catch(error => {
            console.error('Error al obtener la(s) orden(es):', error);
            infoOrdenElement.textContent = 'Error al cargar la(s) orden(es).';
        });

    function mostrarDetalleOrden(orden) {
        infoOrdenElement.innerHTML = `
            <p><strong>Id de la Orden:</strong> ${orden.id_order}</p>
            <p><strong>Fecha:</strong> ${orden.date}</p>
            <p><strong>Total:</strong> $${orden.total.toFixed(2)}</p>
            <p><strong>Estado:</strong> ${orden.state ? 'Completada' : 'Pendiente'}</p>
            ${orden.id_user ? `<p><strong>Usuario ID:</strong> ${orden.id_user}</p>` : ''}
            ${orden.id_payment_method ? `<p><strong>Método de Pago ID:</strong> ${orden.id_payment_method}</p>` : ''}
            ${orden.id_shipment ? `<p><strong>Envío ID:</strong> ${orden.id_shipment}</p>` : ''}
        `;
    }

    volverHistorialButton.addEventListener('click', () => {
        window.location.href = 'historial_ordenes.html'; // Reemplaza con la URL correcta
    });
});