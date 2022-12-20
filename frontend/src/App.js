import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/home";
import Livros from "./pages/livros";
import Emprestimos from "./pages/emprestimos";
import Usuarios from "./pages/usuarios";
import Editora from "./pages/editoras";
import Generos from "./pages/generos";
import Colecoes from "./pages/colecoes";

function App() {

  return (
    //Rotas
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/livros" element={<Livros />} />
        <Route path="/emprestimos" element={<Emprestimos />} />
        <Route path="/editoras" element={<Editora />} />
        <Route path="/generos" element={<Generos />} />
        <Route path="/colecoes" element={<Colecoes />} />
        <Route path="/usuarios" element={<Usuarios />} />
        <Route path="/emprestimos" element={<Emprestimos />} />
      </Routes>
    </Router>
  );
}

export default App;
