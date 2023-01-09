import { useState } from "react";
import Pagination from "./Pagination";

function TableGenero({vetor, selecionar}){  

    return(
        <div>
            <h3 align="center" style={{padding:"20px"}}>Generos cadastrados:</h3>
            <table className="table" style={{width:"800px", align:"center", margin:"auto"}}>
                <thead>
                    <tr align="center">
                    <th scope="col">#</th>
                    <th scope="col">Descrição</th>
                    <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        vetor.map((genero, indice) => (
                            <tr key={indice} align="center">
                                <td>{genero.id}</td>
                                <td>{genero.descricao}</td>
                                <td><button className='btn btn-success' onClick={() => {selecionar(indice)}}>Selecionar</button></td>
                            </tr>
                        ))
                    }                
                </tbody>
            </table>

            

        </div>
        
    )
}

export default TableGenero;