import { useState } from "react";

interface PolizaFormProps {
  onSave: (poliza: any) => void;
}

export default function PolizaForm({ onSave }: PolizaFormProps) {
  const [poliza, setPoliza] = useState({
    numeroPoliza: "",
    fechaInicio: "",
    fechaFin: "",
    primaMensual: 0,
    estado: "ACTIVA",
    clienteId: "",
    planSeguroId: ""
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPoliza({ ...poliza, [e.target.name]: e.target.value });
  };

  return (
    <div>
      <input name="numeroPoliza" placeholder="Número póliza" onChange={handleChange} />
      <input name="fechaInicio" type="date" onChange={handleChange} />
      <input name="fechaFin" type="date" onChange={handleChange} />
      <input name="clienteId" placeholder="Cliente ID" onChange={handleChange} />
      <input name="planSeguroId" placeholder="Plan ID" onChange={handleChange} />
      <button onClick={() => onSave(poliza)}>Emitir</button>
    </div>
  );
}
