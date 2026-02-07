import { useClientes } from "../hooks/useClientes";
import ClienteForm from "../components/clientes/ClienteForm";

export default function ClientesPage() {
  const { clientes, addCliente, removeCliente } = useClientes();

  return (
    <>
      <h2>Clientes</h2>
      <ClienteForm onSave={addCliente} />
      <ul>
        {clientes.map((c: any) => (
          <li key={c.id}>
            {c.nombre}
            <button onClick={() => removeCliente(c.id)}>Eliminar</button>
          </li>
        ))}
      </ul>
    </>
  );
}
