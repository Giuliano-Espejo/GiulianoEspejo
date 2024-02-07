import { BrowserRouter, Route, Routes } from "react-router-dom";
import NavBar from "./componentes/NavBar";
import Productos from "./componentes/Productos";
import Producto from "./componentes/Producto";
import Agregar from "./componentes/Agregar";


function App() {
  return (
    <div className="App" >
      <BrowserRouter>
        <NavBar />
        <Routes>  
          <Route exact path="/" element={<Productos />} />
          <Route exact path="/producto/:id" element={<Producto/>}/>
          <Route exact path="/agregar" element={<Agregar/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
