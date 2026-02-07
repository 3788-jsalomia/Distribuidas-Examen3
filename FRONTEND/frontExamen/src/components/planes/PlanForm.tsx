import { useState } from "react";

interface PlanFormProps {
  onSave: (plan: any) => void;
}

export default function PlanForm({ onSave }: PlanFormProps) {
  const [plan, setPlan] = useState({
    nombre: "",
    tipo: "VIDA",
    primaBase: 0,
    coberturaMax: 0
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    setPlan({ ...plan, [e.target.name]: e.target.value });
  };

  return (
    <div>
      <input name="nombre" placeholder="Nombre" onChange={handleChange} />
      <select name="tipo" onChange={handleChange}>
        <option>VIDA</option>
        <option>AUTO</option>
        <option>SALUD</option>
      </select>
      <input name="primaBase" type="number" onChange={handleChange} />
      <input name="coberturaMax" type="number" onChange={handleChange} />
      <button onClick={() => onSave(plan)}>Guardar</button>
    </div>
  );
}
