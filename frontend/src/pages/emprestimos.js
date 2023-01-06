import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import styles from "../components/formcad.module.css";

function Emprestimos(){

    return(
        <div>
             <Navbar />
            <form className={styles.form}>
                <h3>Registrar emprestimo:</h3>
                Data do emprestimo: <input type='date' className='form-control' name='nome' placeholder='Nome do usuario' />
                Data de devolução: <input type='date' className='form-control' name='nome' />
                <input type='text' className='form-control' name='nomeUsuario' placeholder='Nome do usuario' />
                <input type='text' className='form-control' name='nomeLivro' placeholder='Nome do livro' />
                <input type='button' className='btn btn-primary' value='Cadastrar' />
            </form>
            <Footer />
        </div>
    )

}

export default Emprestimos;