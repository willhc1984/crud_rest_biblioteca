import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import styles from "./formcad.module.css";

function Emprestimos(){

    return(
        <div>
             <Navbar />
            <form className={styles.form}>
                <h3>Registrar emprestimo:</h3>
                Data do emprestimo: <input type='date' className='form-control' name='nome' />
                Data de devolução: <input type='date' className='form-control' name='nome' />
                <input type='button' className='btn btn-primary' value='Cadastrar' />
            </form>
            <Footer />
        </div>
    )

}

export default Emprestimos;