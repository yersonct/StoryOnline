// js/categorias.js

function mostrarListadoCategorias() {
    const listaCategoriasElement = document.getElementById('lista-categorias');
    // Muestra el estado de carga para categorías
    listaCategoriasElement.innerHTML = '<div class="loading-state-small"><div class="loading-spinner"></div><p>Cargando categorías...</p></div>';

    const apiUrlCategorias = 'http://localhost:8080/api/v1/category/'; // URL de tu API de categorías

    fetch(apiUrlCategorias)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // Limpia el contenido de carga
            listaCategoriasElement.innerHTML = '';
            if (data.length === 0) {
                listaCategoriasElement.innerHTML = '<p class="empty-message">No hay categorías disponibles.</p>';
                return;
            }

            data.forEach(categoria => {
                const categoriaDiv = document.createElement('div');
                categoriaDiv.classList.add('categoria-item');
                categoriaDiv.setAttribute('data-id', categoria.id_category); // Añade el ID como atributo de dato
                categoriaDiv.textContent = categoria.name;
                categoriaDiv.addEventListener('click', () => {
                    // Puedes añadir lógica para filtrar productos por categoría aquí
                    console.log(`Categoría seleccionada: ${categoria.name} (ID: ${categoria.id_category})`);
                    // Ejemplo: cargarProductosPorCategoria(categoria.id_category);
                });
                listaCategoriasElement.appendChild(categoriaDiv);
            });
        })
        .catch(error => {
            console.error('Error al obtener las categorías:', error);
            listaCategoriasElement.innerHTML = '<p class="error-message">Error al cargar las categorías.</p>';
        });
}

function mostrarListadoProductos() {
    const listaProductosElement = document.getElementById('lista-productos');
    const loadingStateElement = document.getElementById('loading-state');
    const emptyStateElement = document.getElementById('empty-state');
    const productsCountElement = document.getElementById('products-count');

    // Muestra el estado de carga
    loadingStateElement.style.display = 'flex';
    listaProductosElement.innerHTML = ''; // Limpia productos anteriores
    emptyStateElement.style.display = 'none'; // Oculta el estado vacío
    productsCountElement.textContent = 'Cargando productos...';

    const apiUrlProductos = 'http://localhost:8080/api/v1/product/'; // URL de tu API de productos

    fetch(apiUrlProductos)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            // Oculta el estado de carga
            loadingStateElement.style.display = 'none';

            if (data.length === 0) {
                emptyStateElement.style.display = 'flex'; // Muestra el estado vacío
                productsCountElement.textContent = '0 productos';
                return;
            }

            productsCountElement.textContent = `${data.length} productos`;

            data.forEach(producto => {
                const productoDiv = document.createElement('div');
                productoDiv.classList.add('producto-item');
                // Añade el ID del producto como un atributo de dato para fácil acceso
                productoDiv.setAttribute('data-id', producto.id_product);
                
                productoDiv.addEventListener('click', () => mostrarDetalleProducto(producto.id_product, data));

                const imagenProducto = document.createElement('img');
                // Asume que tu JSON tiene un campo 'imageUrl' o similar. Si no, usa un placeholder.
                imagenProducto.src = producto.imageUrl || 'https://via.placeholder.com/150'; 
                imagenProducto.alt = producto.name_product;

                const nombreProductoH3 = document.createElement('h3');
                nombreProductoH3.textContent = producto.name_product;

                const precioProductoSpan = document.createElement('span');
                precioProductoSpan.classList.add('precio');
                precioProductoSpan.textContent = `$${producto.price.toFixed(2)}`; // Formatea el precio

                productoDiv.appendChild(imagenProducto);
                productoDiv.appendChild(nombreProductoH3);
                productoDiv.appendChild(precioProductoSpan);
                listaProductosElement.appendChild(productoDiv);
            });
        })
        .catch(error => {
            console.error('Error al obtener los productos:', error);
            loadingStateElement.style.display = 'none';
            emptyStateElement.style.display = 'flex'; // Muestra el estado vacío en caso de error
            emptyStateElement.querySelector('h3').textContent = 'Error al cargar productos';
            emptyStateElement.querySelector('p').textContent = 'Por favor, inténtalo de nuevo más tarde.';
            productsCountElement.textContent = 'Error al cargar';
        });
}

function mostrarDetalleProducto(productoId, productos) {
    const detalleProductoElement = document.getElementById('detalle-producto');
    const productDetailPanel = document.getElementById('product-detail-panel');

    // Muestra el panel de detalle
    productDetailPanel.classList.add('open');
    detalleProductoElement.innerHTML = ''; // Limpia el contenido anterior

    const producto = productos.find(p => p.id_product === productoId);

    if (producto) {
        const productContent = `
            <div class="detail-image">
                <img src="${producto.imageUrl || 'https://via.placeholder.com/300'}" alt="${producto.name_product}">
            </div>
            <h2 class="detail-title">${producto.name_product}</h2>
            <p class="detail-description">${producto.description || 'No hay descripción disponible.'}</p>
            <p class="detail-price">Precio: <strong>$${producto.price.toFixed(2)}</strong></p>
            <p class="detail-stock">Stock: ${producto.stocks}</p>
            <p class="detail-category">Categoría ID: ${producto.id_category}</p>
            <p class="detail-supplier">Proveedor ID: ${producto.id_supplier}</p>
            <button class="add-to-cart-btn">Añadir al carrito</button>
        `;
        detalleProductoElement.innerHTML = productContent;

    } else {
        detalleProductoElement.innerHTML = `
            <div class="no-selection">
                <div class="no-selection-icon">
                    <svg width="60" height="60" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5">
                        <path d="M7 7h.01"></path>
                        <path d="M7 3h5c.512 0 1.024.195 1.414.586l7 7a2 2 0 0 1 0 2.828l-7 7a2 2 0 0 1-2.828 0l-7-7A1.994 1.994 0 0 1 3 12V7a4 4 0 0 1 4-4z"></path>
                    </svg>
                </div>
                <h3>Producto no encontrado</h3>
                <p>El producto seleccionado no está disponible.</p>
            </div>
        `;
    }
}

// Event Listeners para la funcionalidad del panel lateral y el filtro móvil
document.addEventListener('DOMContentLoaded', () => {
    mostrarListadoCategorias();
    mostrarListadoProductos();

    const filterToggle = document.getElementById('filter-toggle');
    const sidebarCategorias = document.querySelector('.sidebar-categorias');
    const mobileOverlay = document.getElementById('mobile-overlay');
    const closePanelBtn = document.getElementById('close-panel');
    const productDetailPanel = document.getElementById('product-detail-panel');

    // Toggle para mostrar/ocultar el sidebar de categorías en móvil
    if (filterToggle) {
        filterToggle.addEventListener('click', () => {
            sidebarCategorias.classList.toggle('open');
            mobileOverlay.classList.toggle('active');
        });
    }

    // Cerrar sidebar de categorías al hacer clic en el overlay (para móvil)
    if (mobileOverlay) {
        mobileOverlay.addEventListener('click', () => {
            sidebarCategorias.classList.remove('open');
            mobileOverlay.classList.remove('active');
            productDetailPanel.classList.remove('open'); // También cierra el panel de detalle
        });
    }

    // Cerrar panel de detalle del producto
    if (closePanelBtn) {
        closePanelBtn.addEventListener('click', () => {
            productDetailPanel.classList.remove('open');
            // Si el overlay está activo por el panel de detalle, lo ocultamos
            if (!sidebarCategorias.classList.contains('open')) {
                mobileOverlay.classList.remove('active');
            }
        });
    }

    // Alternar vista de cuadrícula/lista
    const viewToggleButtons = document.querySelectorAll('.view-btn');
    const productsGrid = document.getElementById('lista-productos');

    viewToggleButtons.forEach(button => {
        button.addEventListener('click', () => {
            viewToggleButtons.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');
            const viewType = button.getAttribute('data-view');
            if (viewType === 'grid') {
                productsGrid.classList.remove('products-list');
                productsGrid.classList.add('products-grid');
            } else {
                productsGrid.classList.remove('products-grid');
                productsGrid.classList.add('products-list');
            }
        });
    });

    // Lógica de ordenamiento (a implementar si tienes datos en el frontend o una API que lo soporte)
    const sortSelect = document.getElementById('sort-select');
    if (sortSelect) {
        sortSelect.addEventListener('change', (event) => {
            const sortBy = event.target.value;
            console.log('Ordenar por:', sortBy);
            // Aquí implementarías la lógica para reordenar los productos mostrados
            // o para hacer una nueva llamada a la API con el parámetro de ordenamiento
        });
    }
});

document.addEventListener("DOMContentLoaded",() => {
    const carritoBtn = document.querySelector('.cart-btn');
    carritoBtn.addEventListener('click', () => {
        window.location.href = '../html/carrito.html'; // Redirige al carrito
    })

})