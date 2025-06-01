document.addEventListener('DOMContentLoaded', () => {
    const listaMisComentariosElement = document.getElementById('lista-mis-comentarios');
    const volverProductosButton = document.getElementById('volver-a-productos');
    const comentariosCountSpan = document.getElementById('comentarios-count');
    const loadingState = document.getElementById('loading-comments');
    const emptyState = document.getElementById('empty-comments');

    // This URL would typically fetch reviews for the currently logged-in user.
    // For demonstration, we'll use a placeholder and then simulate the JSON data.
    const userIdActual = 123; // Placeholder for the actual user ID
    // In a real application, you would fetch from an API like:
    const apiUrlMisComentarios = `http://localhost:8080/api/v1/review/user/${userIdActual}`;

    // Function to format the date
    function formatDate(dateString) {
        const date = new Date(dateString);
        const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
        return date.toLocaleDateString('es-CO', options);
    }

    // Function to generate star ratings
    function getStarRating(qualification) {
        const maxStars = 5;
        let starsHtml = '';
        for (let i = 0; i < maxStars; i++) {
            if (i < qualification) {
                starsHtml += '<i class="fas fa-star"></i>'; // Filled star
            } else {
                starsHtml += '<i class="far fa-star"></i>'; // Empty star
            }
        }
        return `<span class="stars">${starsHtml}</span>`;
    }

    // Show loading state initially
    loadingState.style.display = 'flex';
    emptyState.style.display = 'none';
    listaMisComentariosElement.innerHTML = ''; // Clear previous content

    // Simulate fetching data with your provided JSON
    const simulatedComentariosData = [
        {
            "id_review": 2,
            "qualification": 5,
            "comment": "Muy buen producto, lo recomiendo.",
            "date": "2025-05-05"
        },
        {
            "id_review": 3,
            "qualification": 4,
            "comment": "Buen producto, pero el envío tardó un poco.",
            "date": "2025-05-10"
        }
        // Add more simulated data if you wish to test with multiple comments
    ];

    // Simulate an API call with a delay
    setTimeout(() => {
        loadingState.style.display = 'none'; // Hide loading state

        const comentarios = simulatedComentariosData; // Use the simulated data directly

        if (comentarios && comentarios.length > 0) {
            comentariosCountSpan.textContent = `${comentarios.length} comentarios`;
            comentarios.forEach(comentario => {
                const comentarioDiv = document.createElement('div');
                comentarioDiv.classList.add('comentario-item');

                comentarioDiv.innerHTML = `
                    <h4 class="calificacion">
                        Calificación: ${comentario.qualification} ${getStarRating(comentario.qualification)}
                    </h4>
                    <p>Comentario: ${comentario.comment}</p>
                    <p class="fecha">Fecha: ${formatDate(comentario.date)}</p>
                `;
                // Removed id_user and id_product as they are not in your provided JSON example

                listaMisComentariosElement.appendChild(comentarioDiv);
            });
        } else {
            comentariosCountSpan.textContent = `0 comentarios`;
            emptyState.style.display = 'flex'; // Show empty state
        }
    }, 1000); // Simulate a 1-second network delay

    // If you want to use the actual fetch uncomment the code below and comment out the simulated data above
    /*
    fetch(apiUrlMisComentarios)
        .then(response => {
            if (!response.ok) {
                if (response.status === 404) { // Handle 404 specifically for no comments
                    return { comments: [] }; // Return an empty array to trigger empty state
                }
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            loadingState.style.display = 'none'; // Hide loading state

            // The API response might directly be an array, or an object containing an array.
            // Adjust this based on your actual API response structure if using real API.
            const comentarios = Array.isArray(data) ? data : data.comments; // Assuming 'comments' is the key if it's an object

            if (comentarios && comentarios.length > 0) {
                comentariosCountSpan.textContent = `${comentarios.length} comentarios`;
                comentarios.forEach(comentario => {
                    const comentarioDiv = document.createElement('div');
                    comentarioDiv.classList.add('comentario-item');

                    comentarioDiv.innerHTML = `
                        <h4 class="calificacion">
                            Calificación: ${comentario.qualification} ${getStarRating(comentario.qualification)}
                        </h4>
                        <p>Comentario: ${comentario.comment}</p>
                        <p class="fecha">Fecha: ${formatDate(comentario.date)}</p>
                    `;
                    // You might want to fetch product details here if you want to display product name
                    // and image instead of just ID. This would require another API call per comment.

                    listaMisComentariosElement.appendChild(comentarioDiv);
                });
            } else {
                comentariosCountSpan.textContent = `0 comentarios`;
                emptyState.style.display = 'flex'; // Show empty state
            }
        })
        .catch(error => {
            loadingState.style.display = 'none'; // Hide loading state
            console.error('Error al obtener tus comentarios:', error);
            listaMisComentariosElement.innerHTML = `
                <div class="empty-state">
                    <span class="empty-icon"><i class="fas fa-exclamation-triangle fa-3x"></i></span>
                    <h3>Error al cargar tus comentarios.</h3>
                    <p>Por favor, inténtalo de nuevo más tarde.</p>
                </div>
            `;
            comentariosCountSpan.textContent = `0 comentarios`;
        });
    */

    volverProductosButton.addEventListener('click', () => {
        window.location.href = 'productos.html'; // Redirige a la página principal de productos
    });
});