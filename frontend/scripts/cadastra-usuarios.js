var form = document.getElementById('form');
var msg = '';


form.addEventListener('submit', function (e) {
    e.preventDefault();
    var nome = document.getElementById('nome').value;
    var telefone = document.getElementById('telefone').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    fetch('http://localhost:8080/usuarios', {
        method: 'POST',
        body: JSON.stringify({
            nome: nome,
            telefone: telefone,
            email: email,
            password: password,
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        }
    })
        .then(function (response) {
            if (response.ok) {
                responseOk();
            } else {
                responseError(msg);
                console.log(response);
                return response.json();
            }
        })
        .then(function (data) {
            console.log(data.errors[3].defaultMessage);
            msg += data.errors[3].defaultMessage;
        }).catch(error => {
            //console.log(error);
        });
});

function responseOk() {
    var temp = '';
    temp += '<div class="alert alert-success alert-dismissible fade show" role="alert">';
    temp += '    <strong> Usuario cadastrado!';
    temp += '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>';
    temp += '</div>';
    document.getElementById("alert").innerHTML = temp;
    document.getElementById("form").reset();
}

function responseError(msg) {
    var temp = "";
    temp += "<div class='alert alert-danger alert-dismissible fade show' role='alert'>";
    temp += "    <strong>Erro de validação! Corrija seus dados.";
    temp += "   <button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button>";
    temp += "</div>";
    document.getElementById("alert").innerHTML = temp;
}

