import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import { RiDeleteBin2Fill } from 'react-icons/ri';
import { RiEdit2Fill } from 'react-icons/ri';
import { SlMagnifierAdd } from 'react-icons/sl';
import { useEffect } from "react";

function EditoraTabela(){

    //UseEffect - buscar dados
    useEffect(() => {
        
    })

    return(
        <div>
            <Navbar />
            <h3 align="center" style={{padding:"20px"}}>Editoras cadastradas:</h3>
            <table class="table container">
            <thead>
                <tr>
                <th scope="col">#</th>
                <th scope="col">Nome da editora</th>
                <th scope="col">Ações</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>
                        <a href="/"><SlMagnifierAdd style={{ fontSize:"1.5em", margin:".5em" }}/></a>
                        <a href="/"><RiEdit2Fill style={{ fontSize:"1.5em", margin:".5em" }}/></a>
                        <a href="/"><RiDeleteBin2Fill style={{ fontSize:"1.5em", margin:".5em" }}/></a>
                    </td>
                </tr>
            </tbody>
            </table>
            <Footer />
        </div>
        
    )
}

export default EditoraTabela;