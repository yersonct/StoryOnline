document.addEventListener('DOMContentLoaded', function() {
    const registroForm = document.getElementById('registroForm');
    const loginForm = document.getElementById('loginForm');
    const nombreInput = document.getElementById('nombre');
    const emailRegistroInput = document.getElementById('emailRegistro');
    const passwordRegistroInput = document.getElementById('passwordRegistro');
    const confirmPasswordInput = document.getElementById('confirmPassword');
    const emailLoginInput = document.getElementById('emailLogin');
    const passwordLoginInput = document.getElementById('passwordLogin');

    const nombreError = document.getElementById('nombreError');
    const emailRegistroError = document.getElementById('emailRegistroError');
    const passwordRegistroError = document.getElementById('passwordRegistroError');
    const confirmPasswordError = document.getElementById('confirmPasswordError');
    const emailLoginError = document.getElementById('emailLoginError');
    const passwordLoginError = document.getElementById('passwordLoginError');

    const registroDiv = document.querySelector('.formulario.registro');
    const loginDiv = document.querySelector('.formulario.login');
    const mostrarLoginLink = document.querySelector('.mostrar-login');
    const mostrarRegistroLink = document.querySelector('.mostrar-registro');

    // Mostrar el formulario de registro al cargar la página (puedes cambiar esto)
    registroDiv.classList.add('activo');

    mostrarLoginLink.addEventListener('click', function(e) {
        e.preventDefault();
        registroDiv.classList.remove('activo');
        loginDiv.classList.add('activo');
    });

    mostrarRegistroLink.addEventListener('click', function(e) {
        e.preventDefault();
        loginDiv.classList.remove('activo');
        registroDiv.classList.add('activo');
    });

    registroForm.addEventListener('submit', function(e) {
        let isValid = true;

        if (nombreInput.value.trim() === '') {
            nombreError.textContent = 'Por favor, ingresa tu nombre.';
            isValid = false;
        } else {
            nombreError.textContent = '';
        }

        if (!isValidEmail(emailRegistroInput.value.trim())) {
            emailRegistroError.textContent = 'Por favor, ingresa un email válido.';
            isValid = false;
        } else {
            emailRegistroError.textContent = '';
        }

        if (passwordRegistroInput.value.length < 6) {
            passwordRegistroError.textContent = 'La contraseña debe tener al menos 6 caracteres.';
            isValid = false;
        } else {
            passwordRegistroError.textContent = '';
        }

        if (passwordRegistroInput.value !== confirmPasswordInput.value) {
            confirmPasswordError.textContent = 'Las contraseñas no coinciden.';
            isValid = false;
        } else {
            confirmPasswordError.textContent = '';
        }

        if (!isValid) {
            e.preventDefault();
        } else {
            // Aquí iría la lógica para enviar los datos de registro (necesitarías un backend)
            alert('Registro exitoso (simulado)!');
        }
    });

    loginForm.addEventListener('submit', function(e) {
        let isValid = true;

        if (!isValidEmail(emailLoginInput.value.trim())) {
            emailLoginError.textContent = 'Por favor, ingresa tu email.';
            isValid = false;
        } else {
            emailLoginError.textContent = '';
        }

        if (passwordLoginInput.value.trim() === '') {
            passwordLoginError.textContent = 'Por favor, ingresa tu contraseña.';
            isValid = false;
        } else {
            passwordLoginError.textContent = '';
        }

        if (!isValid) {
            e.preventDefault();
        } else {
            // Aquí iría la lógica para verificar el usuario (necesitarías un backend)
            alert('Inicio de sesión exitoso (simulado)!');
        }
    });

    function isValidEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
});