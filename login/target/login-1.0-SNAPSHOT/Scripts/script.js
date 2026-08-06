window.onload = function() { //cargar todo antes del código
const parametros = new URLSearchParams(window.location.search);
if (parametros.get('error') === '1') { //Mensaje al ingresar datos incorrectos
                alert("Correo o contraseña incorrectos. Intente nuevamente.");
}
if (parametros.get('mensaje') === 'registrado') { //mensaje al registrar correctamente
                alert("Usuario registrado correctamente.");
}
};
