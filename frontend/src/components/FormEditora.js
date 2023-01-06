import styles from './formcad.module.css';

function FormEditora({btnCadastrar, aoDigitar,objEditora, cadastrar, remover, limparFormulario}){

    return (

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

    )
}

export default FormEditora;

