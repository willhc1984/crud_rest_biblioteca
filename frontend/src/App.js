import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/home";
import Livros from "./pages/livros";
import Emprestimos from "./pages/emprestimos";
import Usuarios from "./pages/usuarios";

function App() {

  return (
    //Rotas
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/livros" element={<Livros />} />
        <Route path="/emprestimos" element={<Emprestimos />} />
        <Route path="/usuarios" element={<Usuarios />} />
      </Routes>
    </Router>
  );
}

export default App;
