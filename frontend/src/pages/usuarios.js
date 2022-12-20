import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import styles from "./formcad.module.css";

function Usuarios(){

    return(
        <div>
            <Navbar />
            <form className={styles.form}>
                <h3>Cadastro de usuarios:</h3>
                <input type='number' className='form-control' name='nome' placeholder='Nome' />
                <input type='text' className='form-control' name='email' placeholder='Email' />
                <input type='text' className='form-control' name='telefone' placeholder='Telefone' />
                <input type='text' className='form-control' name='password' placeholder='Senha' />
                <input type='text' className='form-control' name='password' placeholder='Redigite a senha' />
                <input type='button' className='btn btn-primary' value='Cadastrar' />
                   
            </form>
            <Footer />
        </div>
        
    )

}

export default Usuarios;