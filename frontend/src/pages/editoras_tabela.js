import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import { RiDeleteBin2Fill } from 'react-icons/ri';
import { RiEdit2Fill } from 'react-icons/ri';
import { SlMagnifierAdd } from 'react-icons/sl';
import { useEffect, useState } from "react";
import styles from "./formcad.module.css";

function EditoraTabela(){

    const editora = {
        id: '',
        nome: ''
    }

    //useState
    const [editoras, setEditoras] = useState([]);
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

    //Exluir editora
    const remover = () => {
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

    return(
        <div>
            <Navbar />
            <h3 align="center" style={{padding:"20px"}}>Editoras cadastradas:</h3>
            <table className="table" style={{width:"800px", align:"center", margin:"auto"}}>
            <thead>
                <tr align="center">
                <th scope="col">#</th>
                <th scope="col">Nome da editora</th>
                <th scope="col">Ações</th>
                </tr>
            </thead>
            <tbody>
                {
                    editoras.map((editora, indice) => (
                        <tr key={indice} align="center">
                            <td>{editora.id}</td>
                            <td>{editora.nome}</td>
                            <td>
                                <a href="/"><SlMagnifierAdd style={{ fontSize:"1.2em", margin:".2em" }}/></a>
                                <a href="/"><RiEdit2Fill style={{ fontSize:"1.2em", margin:".2em" }}/></a>
                                <a href="#" onClick={remover}><RiDeleteBin2Fill style={{ fontSize:"1.2em", margin:".2em" }}/></a>
                            </td>
                        </tr>
                    ))
                }
                
            </tbody>
            </table>
            <Footer />
        </div>
        
    )
}

export default EditoraTabela;