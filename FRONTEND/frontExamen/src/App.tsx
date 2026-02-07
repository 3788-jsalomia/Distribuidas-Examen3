import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import ClientesPage from "./pages/ClientesPage";
import PlanesPage from "./pages/PlanesPage";
import PolizasPage from "./pages/PolizasPage";
import "./App.css";

function App() {
  return (
    <Router>
      <nav style={{ padding: "10px", borderBottom: "1px solid #ccc" }}>
        <Link to="/clientes">Clientes</Link> |{" "}
        <Link to="/planes">Planes</Link> |{" "}
        <Link to="/polizas">Pólizas</Link>
      </nav>

      <Routes>
        <Route path="/" element={<ClientesPage />} />
        <Route path="/clientes" element={<ClientesPage />} />
        <Route path="/planes" element={<PlanesPage />} />
        <Route path="/polizas" element={<PolizasPage />} />
      </Routes>
    </Router>
  );
}

export default App;
