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
                responseError();
            }
            return response.json();
        })
        .then(function (data) {
            console.log(data);
            msg = '' + data.errors[0];

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
}

function responseError() {
    var temp = "";
    temp += "<div class='alert alert-danger alert-dismissible fade show' role='alert'>";
    temp += "    <strong>Erro de validação!";
    temp += "   <button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button>";
    temp += "</div>";
    document.getElementById("alert").innerHTML = temp;
}

