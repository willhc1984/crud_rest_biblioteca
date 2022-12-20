import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import styles from "./formcad.module.css";

function Editora(){

    return(
        <div>
            <Navbar />
            <form className={styles.form}>
                <h3>Cadastro de editora:</h3>
                <input type='text' className='form-control' name='nome' placeholder='Nome da editora' />
                <input type='button' className='btn btn-primary' value='Cadastrar' />
            </form>
            <Footer />
        </div>
        
    )
}

export default Editora;