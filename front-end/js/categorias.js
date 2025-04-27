function mostrarListadoCategorias() {
    const listaCategoriasElement = document.getElementById('lista-categorias');

    fetch('../json/categorias.json') // Reemplaza con la URL de tu API de categorías
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            data.categorias.forEach(categoria => {
                const categoriaDiv = document.createElement('div');
                categoriaDiv.classList.add('categoria-item');
                categoriaDiv.textContent = categoria.name; // Asumiendo que tienes un campo 'name'
                categoriaDiv.addEventListener('click', () => console.log(`Categoría seleccionada: ${categoria.id}`)); // Aquí puedes implementar la lógica para filtrar productos por categoría
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

    fetch('../json/producto.json') // Reemplaza con la URL de tu API de productos
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            data.productos.forEach(producto => {
                const productoDiv = document.createElement('div');
                productoDiv.classList.add('producto-item');
                productoDiv.addEventListener('click', () => mostrarDetalleProducto(producto.id, data.productos));

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

    const producto = productos.find(p => p.id === productoId);

    if (producto) {
        const nombreH2 = document.createElement('h2');
        nombreH2.textContent = producto.name;

        const imagenProducto = document.createElement('img');
        imagenProducto.src = producto.imagenUrl || 'placeholder-detalle.png';
        imagenProducto.alt = producto.name;
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