getData();

async function getData() {
    const response = await fetch('http://localhost:8080/usuarios');
    console.log(response);
    const data = await response.json();
    console.log(data);
    length = data.length;
    //console.log(data);
    var temp = "<tbody>";
    temp += "<tr>";
    temp += "<td>ID</td>";
    temp += "<td>Nome</td>";
    temp += "<td>Telefone</td>";
    temp += "<td>Email</td>";
    temp += "<td>Editar</td>";
    temp += "<td>Excluir</td>";
    temp += "<td>Visualizar</td>";
    temp += "</tr>";


    for (i = 0; i < length; i++) {
        temp += "<tr>";
        temp += "<td>" + data[i].id + "</td>";
        temp += "<td>" + data[i].nome + "</td>";
        temp += "<td>" + data[i].telefone + "</td>";
        temp += "<td>" + data[i].email + "</td>";
        temp += "<td><a href='#'><i class='bi-pencil'></i></a></td>";
        temp += "<td><a href='#'><i class='bi-trash'></a></td>";
        temp += "<td><a href='#'><i class='bi-search'></a></td>";
    }

    temp += "<tbody>";

    document.getElementById("tb_usuarios").innerHTML = temp;

}
