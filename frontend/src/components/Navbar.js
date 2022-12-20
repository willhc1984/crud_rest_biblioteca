import { IoLibraryOutline } from 'react-icons/io5';
function Navbar(){

    return(
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container-fluid">
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                    <li className="nav-item">
                    <a className="navbar-brand" href="/">
                        <IoLibraryOutline style={{ fontSize: "1.5em"}} />
                    </a>
                    </li>
                    <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" href="/" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Emprestimos
                    </a>
                    <ul className="dropdown-menu">
                        <li><a className="dropdown-item" href="/emprestimos">Registrar</a></li>
                        <li><a className="dropdown-item" href="/emprestimos">Visualizar</a></li>
                    </ul>
                    </li>
                    <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" href="/" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Cadastros
                    </a>
                    <ul className="dropdown-menu">
                        <li><a className="dropdown-item" href="/livros">Livro</a></li>
                        <li><a className="dropdown-item" href="/editoras">Editora</a></li>
                        <li><a className="dropdown-item" href="/generos">Gênero</a></li>
                        <li><a className="dropdown-item" href="/colecoes">Coleção</a></li>
                        <li><a className="dropdown-item" href="/usuarios">Usuarios</a></li>
                    </ul>
                    </li>
                    <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" href="/" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Registros
                    </a>
                    <ul className="dropdown-menu">
                        <li><a className="dropdown-item" href="/">Emprestimos</a></li>
                        <li><a className="dropdown-item" href="/">Livros</a></li>
                        <li><a className="dropdown-item" href="/editorastabela">Editoras</a></li>
                        <li><a className="dropdown-item" href="/">Coleções</a></li>
                        <li><a className="dropdown-item" href="/">Generos</a></li>
                        <li><a className="dropdown-item" href="/">Usuarios</a></li>
                    </ul>
                    </li>
                </ul>
                <form className="d-flex" role="search">
                    <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                    <button className="btn btn-outline-success" type="submit">Search</button>
                </form>
                </div>
            </div>
            </nav>
    )
}

export default Navbar;