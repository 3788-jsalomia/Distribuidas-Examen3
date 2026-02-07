import { useState } from "react";

interface ClienteFormProps {
  onSave: (cliente: any) => void;
}

export default function ClienteForm({ onSave }: ClienteFormProps) {
  const [cliente, setCliente] = useState({
    nombre: "",
    identificacion: "",
    email: "",
    telefono: ""
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setCliente({ ...cliente, [e.target.name]: e.target.value });
  };

  return (
    <div>
      <input name="nombre" placeholder="Nombre" onChange={handleChange} />
      <input name="identificacion" placeholder="Identificación" onChange={handleChange} />
      <input name="email" placeholder="Email" onChange={handleChange} />
      <input name="telefono" placeholder="Teléfono" onChange={handleChange} />
      <button onClick={() => onSave(cliente)}>Guardar</button>
    </div>
  );
}
