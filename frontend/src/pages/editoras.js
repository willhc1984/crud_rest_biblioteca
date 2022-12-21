import { useState } from "react";
import { json } from "react-router-dom";
import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import styles from "./formcad.module.css";

function Editora(){

    const editora = {
        id:'',
        nome:''
    }

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
        .then(retorno => retorno,json())
        .then(retorno_convertido => {
            alert("Editora cadastrada!")
        })
    }

    const aoDigitar = (e) => {
        setObjEditora({...objEditora, [e.target.name]:e.target.value});
    }

    return(
        <div>
            <Navbar />
            <form className={styles.form}>
                <h3>Cadastro de editora:</h3>
                <input type='text' className='form-control' name='nome'  onChange={aoDigitar} value={objEditora.nome} placeholder='Nome da editora' />
                <input type='button' className='btn btn-primary' value='Cadastrar' onClick={cadastrar} />
            </form>
            <Footer />
        </div>
        
    )
}

export default Editora;