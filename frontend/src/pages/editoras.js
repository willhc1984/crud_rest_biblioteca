import { useEffect, useState } from "react";
import Footer from "../components/Footer";
import FormEditora from "../components/FormEditora";
import Navbar from "../components/Navbar";
import TableEditora from "../components/TableEditora";

function Editora(){

    const editora = {
        id:'',
        nome:''
    }

    const [editoras, setEditoras] = useState([]);
    const [btnCadastrar, setBtnCadastrar] = useState(true);
    const [objEditora, setObjEditora] = useState(editora);

    //UseEffect - buscar dados
    useEffect(() => {
        fetch('http://localhost:8080/editoras', {
        headers: {
            'Content-type':'application/json',
            'Accept':'application/json',
            }
        })
    .then(retorno => retorno.json())
    .then((retorno_convertido) => setEditoras(retorno_convertido));
    }, []);

    //Cadastrar editora
    const cadastrar = () => {
        fetch("http://localhost:8080/editoras", {
            method: 'post',
            body: JSON.stringify(objEditora),
            headers: {
                'Content-type':'application/json',
                'Accept':'application/json',
            }
        })
        .then(retorno => retorno.json())
        .then(retorno_convertido => {
            if(retorno_convertido.nome){
                alert("Editora cadastrada!");
                setEditoras([...editoras, retorno_convertido])
                limparFormulario();
            }else{
                alert("Erro ao cadastrar!");
            }
            console.log(retorno_convertido);
        })
        .catch((retorno) => {
            alert("Erro: servidor pode estar off-line!");
        })
    }

    //Exluir editora
    const remover = (indice) => {
        fetch('http://localhost:8080/editoras/' + objEditora.id, {
        method: 'delete',
        headers: {
            'Content-type':'application/json',
            'Accept':'application/json'
        }
    })
    .then((response) => {
        console.log(response.status);
    })
    .then((response) => {
        if(response.ok){
            alert('Editora excluida!');
            //Copia vetor de editoras
            let vetorTemp = [...editoras];
            console.log(vetorTemp);
            //Indice
            let indice = vetorTemp.findIndex((p) => {
                return p.id === objEditora.id;
            })
            console.log(indice);
            //Remove editora do vetorTemp
            vetorTemp.splice(indice, 1);
            //Atualiza vetor de editoras
            setEditoras(vetorTemp);
            //Limpa formulario
            limparFormulario();
        }else{
            alert('Erro ao excluir: ' + response);
            console.log(response);
            }
        })
        .catch(e => {
            alert('Erro: servidor off-line!');
        })
    }

    //Selecionar editora na table
    const selecionarEditora = (indice) => {
        console.log(indice);
        setObjEditora(editoras[indice]);
        //console.log(objEditora);
        setBtnCadastrar(false);
    }

    //Obter dados do formulario
    const aoDigitar = (e) => {
        setObjEditora({...objEditora, [e.target.name]:e.target.value});
    }

    //Limpar formulario
    const limparFormulario = () => {
        setObjEditora(editora);
        setBtnCadastrar(true);
    }

    return(
        <div>
            <Navbar />
            <FormEditora btnCadastrar={btnCadastrar} aoDigitar={aoDigitar} objEditora={objEditora} 
                cadastrar={cadastrar} remover={remover} limparFormulario={limparFormulario} />
            <TableEditora vetor={editoras} selecionar={selecionarEditora} />
            <Footer />
        </div>
        
    )
}

export default Editora;