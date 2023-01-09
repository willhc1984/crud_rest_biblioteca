import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import styles from "../components/formcad.module.css";
import FormGenero from "../components/FormGenero";
import TableGenero from "../components/TableGenero";
import { useEffect, useState } from "react";

function Generos(){

    const genero = {
        id:'',
        descricao:''
    }

    const [generos, setGeneros] = useState([]);
    const [btnCadastrar, setBtnCadastrar] = useState(true);
    const [objGenero, setObjGenero] = useState(genero);

    //UseEffect - buscar dados
    useEffect(() => {
        fetch('http://localhost:8080/generos', {
        headers: {
            'Content-type':'application/json',
            'Accept':'application/json',
            }
        })
    .then(retorno => retorno.json())
    .then((retorno_convertido) => setGeneros(retorno_convertido));
    }, []);

    //Cadastrar editora
    const cadastrar = () => {
        fetch("http://localhost:8080/generos", {
            method: 'post',
            body: JSON.stringify(objGenero),
            headers: {
                'Content-type':'application/json',
                'Accept':'application/json',
            }
        })
        .then(retorno => retorno.json())
        .then(retorno_convertido => {
            if(retorno_convertido.descricao){
                alert("Genero cadastrado!");
                setGeneros([...generos, retorno_convertido])
                limparFormulario();
            }else{
                alert("Erro ao cadastrar!" + JSON.stringify(retorno_convertido.validations));
            }
        })
        .catch((retorno) => {
            alert("Erro: servidor pode estar off-line!");
        })
    }

    //Exluir genero
    const remover = (indice) => {
        fetch('http://localhost:8080/generos/' + objGenero.id, {
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
                if(data.id === objGenero.id){
                    alert('Genero excluido!');
                    //Copia vetor de editoras
                    let vetorTemp = [...generos];
                    //Indice
                    let indice = vetorTemp.findIndex((p) => {
                        return p.id === objGenero.id;
                    })
                    //Remove editora do vetorTemp
                    vetorTemp.splice(indice, 1);
                    //Atualiza vetor de editoras
                    setGeneros(vetorTemp);
                    //Limpa formulario
                    limparFormulario();
                }
            })
        .catch(e => {
            alert('Erro: servidor off-line!');
        })
    }

    //Editar genero
    const alterar = () => {
        fetch('http://localhost:8080/generos/' + objGenero.id, {
        method: 'put',
        body: JSON.stringify(objGenero),
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
            let vetorTemp = [...generos]
            //Indice
            let indice = vetorTemp.findIndex((p) => {
                return p.id === objGenero.id;
            });
            //Altera editora do vetor
            vetorTemp[indice] = objGenero;
            //Atualizar editora
            setGeneros(vetorTemp);
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
        setObjGenero(generos[indice]);
        //console.log(objEditora);
        setBtnCadastrar(false);
    }

    //Obter dados do formulario
    const aoDigitar = (e) => {
        setObjGenero({...objGenero, [e.target.name]:e.target.value});
    }

    //Limpar formulario
    const limparFormulario = () => {
        setObjGenero(genero);
        setBtnCadastrar(true);
    }

    return(
        <div>
            <Navbar />
            <FormGenero btnCadastrar={btnCadastrar} aoDigitar={aoDigitar} objGenero={objGenero} 
                cadastrar={cadastrar} remover={remover} limparFormulario={limparFormulario} alterar={alterar} />
            <TableGenero vetor={generos} selecionar={selecionarEditora} />
            <Footer />
        </div>
        
    )
}

export default Generos;