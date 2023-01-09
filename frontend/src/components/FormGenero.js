import styles from './formcad.module.css';

function FormGenero({btnCadastrar, aoDigitar,objGenero, cadastrar, remover, limparFormulario, alterar}){

    return (

        <form className={styles.form}>
            <h3>Cadastro de genero literario:</h3>
            <input type='text' className='form-control' name='descricao' onChange={aoDigitar} value={objGenero.descricao} placeholder='Nome da editora' />
            
            {
                btnCadastrar
                ?
                <input type='button' className='btn btn-primary' value='Cadastrar' onClick={cadastrar} />
                :
                <div>
                    <input type='button' className='btn btn-warning' value='Alterar' onClick={alterar} />
                    <input type='button' className='btn btn-danger' value='Remover' onClick={remover} />
                    <input type='button' className='btn btn-secondary' value='Cancelar' onClick={limparFormulario} />
                </div>
                
            }
            
        </form>

    )
}

export default FormGenero;

