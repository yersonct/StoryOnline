function mostrarListadoCategorias() {
    const listaCategoriasElement = document.getElementById('lista-categorias');
    const apiUrlCategorias = 'http://localhost:8080/api/v1/category/'; // URL de tu API de categorías

    fetch(apiUrlCategorias)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            data.forEach(categoria => { // La respuesta ahora es un array directamente
                const categoriaDiv = document.createElement('div');
                categoriaDiv.classList.add('categoria-item');
                categoriaDiv.textContent = categoria.name; // Asumiendo que tienes un campo 'name'
                categoriaDiv.addEventListener('click', () => console.log(`Categoría seleccionada: ${categoria.id_category}`)); // Usar id_category
                listaCategoriasElement.appendChild(categoriaDiv);
            });
        })
        .catch(error => {
            console.error('Error al obtener las categorías:', error);
            listaCategoriasElement.textContent = 'Error al cargar las categorías.';
        });
}

function mostrarListadoProductos() {
    const listaProductosElement = document.getElementById('lista-productos');
    const apiUrlProductos = 'http://localhost:8080/api/v1/product/'; // URL de tu API de productos

    fetch(apiUrlProductos)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            data.forEach(producto => { // La respuesta ahora es un array directamente
                const productoDiv = document.createElement('div');
                productoDiv.classList.add('producto-item');
                productoDiv.addEventListener('click', () => mostrarDetalleProducto(producto.id_product, data)); // Usar id_product

                const imagenProducto = document.createElement('img');
                imagenProducto.src = producto.imagenUrl || 'placeholder.png';
                imagenProducto.alt = producto.name_product; // Usar name_product

                const nombreProductoH3 = document.createElement('h3');
                nombreProductoH3.textContent = producto.name_product; // Usar name_product

                const precioProductoSpan = document.createElement('span');
                precioProductoSpan.classList.add('precio');
                precioProductoSpan.textContent = `$${producto.price}`;

                productoDiv.appendChild(imagenProducto);
                productoDiv.appendChild(nombreProductoH3);
                productoDiv.appendChild(precioProductoSpan);
                listaProductosElement.appendChild(productoDiv);
            });
        })
        .catch(error => {
            console.error('Error al obtener los productos:', error);
            listaProductosElement.textContent = 'Error al cargar los productos.';
        });
}

function mostrarDetalleProducto(productoId, productos) {
    const detalleProductoElement = document.getElementById('detalle-producto');
    detalleProductoElement.innerHTML = '';

    const producto = productos.find(p => p.id_product === productoId); // Usar id_product

    if (producto) {
        const nombreH2 = document.createElement('h2');
        nombreH2.textContent = producto.name_product; // Usar name_product

        const imagenProducto = document.createElement('img');
        imagenProducto.src = producto.imagenUrl || 'placeholder-detalle.png';
        imagenProducto.alt = producto.name_product;
        imagenProducto.style.maxWidth = '100%';
        imagenProducto.style.height = 'auto';
        imagenProducto.style.marginBottom = '15px';

        const descripcionH3 = document.createElement('h3');
        descripcionH3.textContent = 'Descripción:';

        const descripcionP = document.createElement('p');
        descripcionP.textContent = producto.description || 'No hay descripción disponible.';

        const precioH3 = document.createElement('h3');
        precioH3.textContent = 'Precio:';

        const precioP = document.createElement('p');
        precioP.classList.add('precio');
        precioP.textContent = `$${producto.price}`;
        precioP.style.fontSize = '1.5em';
        precioP.style.fontWeight = 'bold';

        const stocksP = document.createElement('p');
        stocksP.textContent = `Stock: ${producto.stocks}`;

        const categoryIdP = document.createElement('p');
        categoryIdP.textContent = `Categoría ID: ${producto.categoryId}`;

        const supplierIdP = document.createElement('p');
        supplierIdP.textContent = `Proveedor ID: ${producto.supplierId}`;

        detalleProductoElement.appendChild(nombreH2);
        detalleProductoElement.appendChild(imagenProducto);
        detalleProductoElement.appendChild(descripcionH3);
        detalleProductoElement.appendChild(descripcionP);
        detalleProductoElement.appendChild(precioH3);
        detalleProductoElement.appendChild(precioP);
        detalleProductoElement.appendChild(stocksP);
        detalleProductoElement.appendChild(categoryIdP);
        detalleProductoElement.appendChild(supplierIdP);

    } else {
        detalleProductoElement.textContent = 'Producto no encontrado.';
    }
}

document.addEventListener('DOMContentLoaded', () => {
    mostrarListadoCategorias();
    mostrarListadoProductos();
});