import Footer from "../components/Footer";
import Navbar from "../components/Navbar";
import styles from "./formcad.module.css";

function Livros(){

    return(
        <div>
            <Navbar />
            <form className={styles.form}>
                <h3>Cadastro de livros:</h3>
                <input type='text' className='form-control' name='titulo' placeholder='Titulo' />
                <input type='number' className='form-control' name='paginas' placeholder='Paginas' />
                <input type='number' className='form-control' name='valorMulta' placeholder='Valor de multa' />
                <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Editora</label>
                    <select class="form-select" id="inputGroupSelect01">
                        <option selected>Escolha...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Gênero</label>
                    <select class="form-select" id="inputGroupSelect01">
                        <option selected>Escolha...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Coleção</label>
                    <select class="form-select" id="inputGroupSelect01">
                        <option selected>Escolha...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <input type='button' className='btn btn-primary' value='Cadastrar' />
                   
            </form>
            <Footer />
        </div>
       
    )

}

export default Livros;