
function TableEditora({vetor, selecionar}){  

    return(
        <div>
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
                    vetor.map((editora, indice) => (
                        <tr key={indice} align="center">
                            <td>{editora.id}</td>
                            <td>{editora.nome}</td>
                            <td><button className='btn btn-success' onClick={() => {selecionar(indice)}} >Selecionar</button></td>
                        </tr>
                    ))
                }
                
            </tbody>
            </table>
        </div>
        
    )
}

export default TableEditora;