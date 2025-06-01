document.addEventListener('DOMContentLoaded', () => {
    const API_BASE_URL = 'http://localhost:8080/api/v1/Users/'; // Base URL for your API

    const authContainer = document.querySelector('.auth-container');
    const formWrapper = document.querySelector('.form-wrapper');
    const registroForm = document.getElementById('registroForm');
    const loginForm = document.getElementById('loginForm');
    const mostrarLoginLink = document.querySelector('.mostrar-login');
    const mostrarRegistroLink = document.querySelector('.mostrar-registro');
    const togglePasswordButtons = document.querySelectorAll('.toggle-password');
    const passwordRegistroInput = document.getElementById('passwordRegistro');
    const confirmPasswordInput = document.getElementById('confirmPassword');
    const strengthBar = document.getElementById('strengthBar');
    const strengthText = document.getElementById('strengthText');
    const loadingOverlay = document.getElementById('loadingOverlay');
    const indicators = document.querySelectorAll('.indicator');

    // Function to show the Login form
    const showLoginForm = () => {
        if (formWrapper) {
            formWrapper.classList.add('show-login');
        }
        if (indicators.length > 1) {
            indicators[0].classList.remove('active');
            indicators[1].classList.add('active');
        }
        if (authContainer) {
            authContainer.scrollTop = 0;
        }
    };

    // Function to show the Registration form
    const showRegistroForm = () => {
        if (formWrapper) {
            formWrapper.classList.remove('show-login');
        }
        if (indicators.length > 1) {
            indicators[0].classList.add('active');
            indicators[1].classList.remove('active');
        }
        if (authContainer) {
            authContainer.scrollTop = 0;
        }
    };

    // Event Listeners for switching between forms
    if (mostrarLoginLink) {
        mostrarLoginLink.addEventListener('click', (e) => {
            e.preventDefault();
            showLoginForm();
        });
    }

    if (mostrarRegistroLink) {
        mostrarRegistroLink.addEventListener('click', (e) => {
            e.preventDefault();
            showRegistroForm();
        });
    }

    // Event listeners for progress indicators
    indicators.forEach(indicator => {
        indicator.addEventListener('click', () => {
            const formType = indicator.dataset.form;
            if (formType === 'registro') {
                showRegistroForm();
            } else if (formType === 'login') {
                showLoginForm();
            }
        });
    });

    // Function to show/hide password
    togglePasswordButtons.forEach(button => {
        button.addEventListener('click', () => {
            const targetId = button.dataset.target;
            const targetInput = document.getElementById(targetId);
            const icon = button.querySelector('i');

            if (targetInput && icon) {
                if (targetInput.type === 'password') {
                    targetInput.type = 'text';
                    icon.classList.remove('fa-eye');
                    icon.classList.add('fa-eye-slash');
                } else {
                    targetInput.type = 'password';
                    icon.classList.remove('fa-eye-slash');
                    icon.classList.add('fa-eye');
                }
            }
        });
    });

    // Function to check password strength
    const checkPasswordStrength = (password) => {
        let strength = 0;
        let text = 'Muy débil';
        let barClass = 'weak';

        if (password.length > 5) strength++;
        if (password.length > 8) strength++;
        if (/[A-Z]/.test(password)) strength++;
        if (/[a-z]/.test(password)) strength++;
        if (/[0-9]/.test(password)) strength++;
        if (/[^A-Za-z0-9]/.test(password)) strength++;

        if (strength <= 2) {
            text = 'Débil';
            barClass = 'weak';
        } else if (strength <= 4) {
            text = 'Moderada';
            barClass = 'medium';
        } else {
            text = 'Fuerte';
            barClass = 'strong';
        }

        if (strengthBar) {
            strengthBar.dataset.strength = barClass;
        }
        if (strengthText) {
            strengthText.dataset.strength = barClass;
            strengthText.textContent = `Fortaleza: ${text}`;
        }
    };

    // Listen for changes in the registration password to update strength
    if (passwordRegistroInput) {
        passwordRegistroInput.addEventListener('input', (e) => {
            checkPasswordStrength(e.target.value);
        });
    }

    // Function to show error messages
    const showErrorMessage = (inputElement, message) => {
        const inputGroup = inputElement.closest('.input-group');
        const errorMessageSpan = inputGroup ? inputGroup.querySelector('.error-message') : null;
        if (inputGroup && errorMessageSpan) {
            inputGroup.classList.add('invalid');
            errorMessageSpan.textContent = message;
        }
    };

    // Function to hide error messages
    const hideErrorMessage = (inputElement) => {
        const inputGroup = inputElement.closest('.input-group');
        const errorMessageSpan = inputGroup ? inputGroup.querySelector('.error-message') : null;
        if (inputGroup && errorMessageSpan) {
            inputGroup.classList.remove('invalid');
            errorMessageSpan.textContent = '';
        }
    };

    // Basic form validation
    const validateForm = (form) => {
        let isValid = true;
        const inputs = form.querySelectorAll('input[required]');

        inputs.forEach(input => {
            hideErrorMessage(input); // Hide errors when revalidating

            if (input.type === 'email' && !input.value.includes('@')) {
                showErrorMessage(input, 'Por favor, introduce un correo electrónico válido.');
                isValid = false;
            } else if (input.type === 'password') {
                if (input.id === 'passwordRegistro') {
                    if (input.value.length < 6) {
                        showErrorMessage(input, 'La contraseña debe tener al menos 6 caracteres.');
                        isValid = false;
                    }
                } else if (input.id === 'confirmPassword' && passwordRegistroInput && input.value !== passwordRegistroInput.value) {
                    showErrorMessage(input, 'Las contraseñas no coinciden.');
                    isValid = false;
                } else if (input.id === 'passwordLogin' && input.value.length === 0) {
                     showErrorMessage(input, 'La contraseña es obligatoria.');
                    isValid = false;
                }
            } else if (input.value.trim() === '') {
                showErrorMessage(input, 'Este campo es obligatorio.');
                isValid = false;
            }
        });
        return isValid;
    };

    // --- User Registration (Crear Cuenta) ---
    if (registroForm) {
        registroForm.addEventListener('submit', async (event) => {
            event.preventDefault();

            if (!validateForm(registroForm)) {
                return;
            }

            if (loadingOverlay) {
                loadingOverlay.classList.add('active');
            }

            const name = document.getElementById('nombre').value;
            const email = document.getElementById('emailRegistro').value;
            const password = document.getElementById('passwordRegistro').value;

            const userData = {
                name: name,
                email: email,
                password: password,
                address: "", // You might want to add fields for address and phone
                phone: "",
                role: "cliente" // Default role for new registrations
            };

            try {
                const response = await fetch(API_BASE_URL, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(userData),
                });

                if (response.ok) {
                    alert('¡Registro exitoso! Ahora puedes iniciar sesión.');
                    registroForm.reset();
                    showLoginForm(); // Redirect to login form after successful registration
                } else {
                    const errorData = await response.json();
                    alert(`Error en el registro: ${errorData.message || response.statusText}`);
                }
            } catch (error) {
                console.error('Error al registrar usuario:', error);
                alert('Ocurrió un error al intentar registrar el usuario. Por favor, inténtalo de nuevo.');
            } finally {
                if (loadingOverlay) {
                    loadingOverlay.classList.remove('active');
                }
                // Reset floating labels and password strength
                registroForm.querySelectorAll('input').forEach(input => {
                    const label = input.nextElementSibling;
                    if (label && label.tagName === 'LABEL') {
                        if (input.value === '') {
                            label.style.transition = 'none';
                            label.style.top = '50%';
                            label.style.transform = 'translateY(-50%)';
                            label.style.fontSize = '0.9em';
                            label.style.color = 'var(--text-color-light)';
                            setTimeout(() => {
                                label.style.transition = 'all var(--transition-speed) var(--transition-ease)';
                            }, 50);
                        }
                    }
                    hideErrorMessage(input);
                });
                if (passwordRegistroInput) {
                    checkPasswordStrength('');
                }
            }
        });
    }

    // --- User Login (Iniciar Sesión) ---
    if (loginForm) {
        loginForm.addEventListener('submit', async (event) => {
            event.preventDefault();

            if (!validateForm(loginForm)) {
                return;
            }

            if (loadingOverlay) {
                loadingOverlay.classList.add('active');
            }

            const email = document.getElementById('emailLogin').value;
            const password = document.getElementById('passwordLogin').value;

            try {
                const response = await fetch(API_BASE_URL); // Fetch all users to verify credentials
                if (!response.ok) {
                    throw new Error('No se pudo obtener la lista de usuarios.');
                }
                const users = await response.json();

                const user = users.find(u => u.email === email && u.password === password);

                if (user) {
                    // Successful login
                    alert(`¡Bienvenido, ${user.name}! Sesión iniciada correctamente.`);
                    // You might want to store user data in localStorage or sessionStorage here
                    // Example: localStorage.setItem('currentUser', JSON.stringify(user));
                    window.location.href = 'http://127.0.0.1:5500/html/producto.html'; // Redirect to another page
                } else {
                    showErrorMessage(document.getElementById('passwordLogin'), 'Correo electrónico o contraseña incorrectos.');
                    alert('Correo electrónico o contraseña incorrectos. Por favor, inténtalo de nuevo.');
                }
            } catch (error) {
                console.error('Error durante el inicio de sesión:', error);
                alert('Ocurrió un error al intentar iniciar sesión. Por favor, inténtalo de nuevo.');
            } finally {
                if (loadingOverlay) {
                    loadingOverlay.classList.remove('active');
                }
                // Reset floating labels (except for login, usually you'd want to keep input if login failed)
                // For demonstration, we'll clear them on success or error.
                loginForm.querySelectorAll('input').forEach(input => {
                    const label = input.nextElementSibling;
                    if (label && label.tagName === 'LABEL') {
                        if (input.value === '') {
                            label.style.transition = 'none';
                            label.style.top = '50%';
                            label.style.transform = 'translateY(-50%)';
                            label.style.fontSize = '0.9em';
                            label.style.color = 'var(--text-color-light)';
                            setTimeout(() => {
                                label.style.transition = 'all var(--transition-speed) var(--transition-ease)';
                            }, 50);
                        }
                    }
                });
            }
        });
    }

    // Floating label effect initialization and continuous update
    document.querySelectorAll('.input-group input').forEach(input => {
        const label = input.nextElementSibling;

        if (label && label.tagName === 'LABEL') {
            const updateLabelPosition = () => {
                if (input.value.trim() !== '' || input === document.activeElement) {
                    label.style.top = '0';
                    label.style.transform = 'translateY(-50%) scale(0.85)';
                    label.style.fontSize = '0.8em';
                    label.style.color = 'var(--primary-color)';
                } else {
                    label.style.top = '50%';
                    label.style.transform = 'translateY(-50%)';
                    label.style.fontSize = '0.9em';
                    label.style.color = 'var(--text-color-light)';
                }
            };

            setTimeout(() => {
                updateLabelPosition();
            }, 100);

            input.addEventListener('input', updateLabelPosition);
            input.addEventListener('focus', updateLabelPosition);
            input.addEventListener('blur', updateLabelPosition);
        }
    });

    // Initialize password strength on load in case of browser autofill
    if (passwordRegistroInput && passwordRegistroInput.value) {
        checkPasswordStrength(passwordRegistroInput.value);
    }
});