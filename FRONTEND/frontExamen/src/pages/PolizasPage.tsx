import { usePolizas } from "../hooks/usePolizas.ts";
import PolizaForm from "../components/polizas/PolizaForm";

export default function PolizasPage() {
  const { polizas, addPoliza, removePoliza } = usePolizas();

  return (
    <>
      <h2>Pólizas</h2>
      <PolizaForm onSave={addPoliza} />
      <ul>
        {polizas.map((p: any) => (
          <li key={p.id}>
            {p.numeroPoliza} - {p.estado}
            <button onClick={() => removePoliza(p.id)}>Eliminar</button>
          </li>
        ))}
      </ul>
    </>
  );
}
