import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import styles from "../components/formcad.module.css";

function Colecoes(){

    return(
        <div>
            <Navbar />
            <form className={styles.form}>
                <h3>Cadastro de coleções:</h3>
                <input type='text' className='form-control' name='nome' placeholder='Nome da coleção' />
                <input type='button' className='btn btn-primary' value='Cadastrar' />
            </form>
            <Footer />
        </div>
        
    )
}

export default Colecoes;