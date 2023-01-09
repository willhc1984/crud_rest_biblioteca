import { useEffect, useState } from "react";
import Alert from "../components/Alert";
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
                alert("Erro ao cadastrar!" + JSON.stringify(retorno_convertido.validations));
            }
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
            return response.json();
        })
        .then((data) => {
                if(data.status !== 200){
                    alert(data.error);
                }
                if(data.id === objEditora.id){
                    alert('Editora excluida!');
                    //Copia vetor de editoras
                    let vetorTemp = [...editoras];
                    //Indice
                    let indice = vetorTemp.findIndex((p) => {
                        return p.id === objEditora.id;
                    })
                    //Remove editora do vetorTemp
                    vetorTemp.splice(indice, 1);
                    //Atualiza vetor de editoras
                    setEditoras(vetorTemp);
                    //Limpa formulario
                    limparFormulario();
                }
            })
        .catch(e => {
            alert('Erro: servidor off-line!');
        })
    }

    //Editar editora
    const alterar = () => {
        fetch('http://localhost:8080/editoras/' + objEditora.id, {
        method: 'put',
        body: JSON.stringify(objEditora),
        headers: {
            'Content-type':'application/json',
            'Accept':'application/json',
            }
        })
        .then(retorno => retorno.json())
        .then(() => {
            //Mensagem
            alert('Editora alterada!')
            //Copia do vetor editoras
            let vetorTemp = [...editoras]
            //Indice
            let indice = vetorTemp.findIndex((p) => {
                return p.id === objEditora.id;
            });
            //Altera editora do vetor
            vetorTemp[indice] = objEditora;
            //Atualizar editora
            setEditoras(vetorTemp);
            //Limpa formulario
            limparFormulario();
        })
        .catch(e =>{
            alert('Erro: servidor off-line!');
        });
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
                cadastrar={cadastrar} remover={remover} limparFormulario={limparFormulario} alterar={alterar} />
            <TableEditora vetor={editoras} selecionar={selecionarEditora} />
            <Footer />
        </div>
        
    )
}

export default Editora;