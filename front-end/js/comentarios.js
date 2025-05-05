document.addEventListener('DOMContentLoaded', () => {
    const listaMisComentariosElement = document.getElementById('lista-mis-comentarios');
    const volverProductosButton = document.getElementById('volver-a-productos');
    const apiUrlMisComentarios = 'http://localhost:8080/api/v1/review/'; // URL para obtener las reseñas del usuario

    // Función para formatear la fecha (opcional)
    function formatDate(dateString) {
        const date = new Date(dateString);
        const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
        return date.toLocaleDateString('es-CO', options);
    }

    // Asumiendo que necesitas filtrar los comentarios por el usuario actual
    // Necesitarás tener el ID del usuario actual disponible (por ejemplo, desde una sesión)
    const userIdActual = 123; // Reemplaza con la forma en que obtienes el ID del usuario

    let fetchUrl = apiUrlMisComentarios;
    if (userIdActual) {
        fetchUrl += `?userId=${userIdActual}`; // Añade un parámetro para filtrar por usuario
    }

    fetch(fetchUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(comentarios => {
            listaMisComentariosElement.innerHTML = '';
            if (comentarios && comentarios.length > 0) {
                comentarios.forEach(comentario => {
                    const comentarioDiv = document.createElement('div');
                    comentarioDiv.classList.add('comentario-item');

                    const calificacionH4 = document.createElement('h4');
                    calificacionH4.textContent = `Calificación: ${comentario.qualification}`;
                    calificacionH4.classList.add('calificacion');

                    const comentarioP = document.createElement('p');
                    comentarioP.textContent = `Comentario: ${comentario.comment}`;

                    const fechaP = document.createElement('p');
                    fechaP.classList.add('fecha');
                    fechaP.textContent = `Fecha: ${formatDate(comentario.date)}`;

                    const userIdP = document.createElement('p');
                    userIdP.textContent = `Usuario ID: ${comentario.id_user}`;

                    const productIdP = document.createElement('p');
                    productIdP.textContent = `Producto ID: ${comentario.id_product}`;

                    comentarioDiv.appendChild(calificacionH4);
                    comentarioDiv.appendChild(comentarioP);
                    comentarioDiv.appendChild(fechaP);
                    comentarioDiv.appendChild(userIdP);
                    comentarioDiv.appendChild(productIdP);

                    listaMisComentariosElement.appendChild(comentarioDiv);
                });
            } else {
                listaMisComentariosElement.textContent = 'No has realizado ningún comentario aún.';
            }
        })
        .catch(error => {
            console.error('Error al obtener tus comentarios:', error);
            listaMisComentariosElement.textContent = 'Error al cargar tus comentarios.';
        });

    volverProductosButton.addEventListener('click', () => {
        window.location.href = 'productos.html'; // Redirige a la página principal de productos
    });
});