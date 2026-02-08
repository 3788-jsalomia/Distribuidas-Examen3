import { useState } from "react";

interface Poliza {
  numeroPoliza: number;
  fechaInicio: string;
  fechaFin: string;
  primaMensual: number;
  estado: boolean;
}

interface PolizaFormProps {
  onSave: (poliza: Poliza) => void;
}

export default function PolizaForm({ onSave }: PolizaFormProps) {
  const [poliza, setPoliza] = useState<Poliza>({
    numeroPoliza: 0,
    fechaInicio: "",
    fechaFin: "",
    primaMensual: 0,
    estado: true
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, type, checked } = e.target;

    setPoliza({
      ...poliza,
      [name]:
        type === "number"
          ? Number(value)
          : type === "checkbox"
            ? checked
            : value
    });
  };

  return (
    <div>
      <input
        name="numeroPoliza"
        type="number"
        placeholder="Número póliza"
        onChange={handleChange}
      />

      <input
        name="fechaInicio"
        type="date"
        onChange={handleChange}
      />

      <input
        name="fechaFin"
        type="date"
        onChange={handleChange}
      />

      <input
        name="primaMensual"
        type="number"
        placeholder="Prima mensual"
        onChange={handleChange}
      />

      <label>
        Activa
        <input
          name="estado"
          type="checkbox"
          checked={poliza.estado}
          onChange={handleChange}
        />
      </label>

      <button onClick={() => onSave(poliza)}>
        Emitir
      </button>
    </div>
  );
}
