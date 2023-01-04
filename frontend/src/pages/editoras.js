import { useEffect, useState } from "react";
import { json } from "react-router-dom";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import TableEditora from "../components/TableEditora";
import styles from "./formcad.module.css";

function Editora(){

    const editora = {
        id:'',
        nome:''
    }

    const [editoras, setEditoras] = useState([]);
    const [btnCadastrar, setBtnCadastrar] = useState(true);
    const [objEditora, setObjEditora] = useState(editora);

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

    //Exluir editora
    const remover = (indice) => {
        fetch('http://localhost:8080/editoras/' + objEditora.id, {
        method: 'delete',
        headers: {
            'Content-type':'application/json',
            'Accept':'application/json'
        }
    })
    .then(() => {
        alert('Editora excluida!');
        console.log(objEditora);
        console.log(objEditora.id);
        console.log(editoras);
        })
    }

    //Selecionar editora na table
    const selecionarEditora = (indice) => {
        setObjEditora(editoras[indice]);
        setBtnCadastrar(false);
        //console.log(objEditora);
        //console.log(editoras);
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
            <form className={styles.form}>
                <h3>Cadastro de editora:</h3>
                <input type='text' className='form-control' name='nome'  onChange={aoDigitar} value={objEditora.nome} placeholder='Nome da editora' />
                
                {
                    btnCadastrar
                    ?
                    <input type='button' className='btn btn-primary' value='Cadastrar' onClick={cadastrar} />
                    :
                    <div>
                        <input type='button' className='btn btn-warning' value='Alterar' onClick={cadastrar} />
                        <input type='button' className='btn btn-danger' value='Remover' onClick={remover} />
                        <input type='button' className='btn btn-secondary' value='Cancelar' onClick={limparFormulario} />
                    </div>
                    
                }
                
            </form>
            <TableEditora vetor={editoras} selecionar={selecionarEditora} />
            <Footer />
        </div>
        
    )
}

export default Editora;