import { useEffect, useState } from "react";
import { getClientes, createCliente, deleteCliente } from "../api/clienteApi";

export function useClientes() {
  const [clientes, setClientes] = useState<any[]>([]);

  const loadClientes = async () => {
    const res = await getClientes();
    setClientes(res.data);
  };

  const addCliente = async (cliente: any) => {
    await createCliente(cliente);
    loadClientes();
  };

  const removeCliente = async (id: string | number) => {
    await deleteCliente(id);
    loadClientes();
  };

  useEffect(() => {
    loadClientes();
  }, []);

  return { clientes, addCliente, removeCliente };
}
