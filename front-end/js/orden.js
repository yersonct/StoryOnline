document.addEventListener('DOMContentLoaded', () => {
    const infoOrdenElement = document.getElementById('info-orden');
    const volverHistorialButton = document.getElementById('volver-a-historial');

    // Función para obtener el ID de la orden de la URL
    // function getOrderIdFromUrl() {
    //     const urlParams = new URLSearchParams(window.location.search);
    //     return urlParams.get('id');
    // }

    // const orderId = getOrderIdFromUrl();

    // if (orderId) {
        fetch(`../json/orden.json`) // Reemplaza con la URL correcta para obtener los detalles de la orden por su ID
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(orden => {
                if (orden && orden.Id) {
                    infoOrdenElement.innerHTML = `
                        <p><strong>Id de la Orden:</strong> ${orden.Id}</p>
                        <p><strong>Fecha:</strong> ${orden.Date}</p>
                        <p><strong>Total:</strong> $${orden.Total.toFixed(2)}</p>
                        <p><strong>Estado:</strong> ${orden.State}</p>
                        <p><strong>Usuario ID:</strong> ${orden.UserId}</p>
                        `;
                } else {
                    infoOrdenElement.textContent = 'No se encontró la orden con ese ID.';
                }
            })
            .catch(error => {
                console.error('Error al obtener los detalles de la orden:', error);
                infoOrdenElement.textContent = 'Error al cargar los detalles de la orden.';
            });
    // } else {
    //     infoOrdenElement.textContent = 'No se especificó un ID de orden.';
    // }

    volverHistorialButton.addEventListener('click', () => {
        window.location.href = 'historial_ordenes.html'; // Reemplaza con la URL de tu página de historial de órdenes
    });
});