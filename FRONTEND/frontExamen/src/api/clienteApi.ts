import axios from "axios";

const API_URL = "http://localhost:8081/api/cliente";

export const getClientes = () => axios.get(API_URL);
export const getClienteById = (id: string | number) => axios.get(`${API_URL}/${id}`);
export const createCliente = (cliente: any) => axios.post(API_URL, cliente);
export const updateCliente = (id: string | number, cliente: any) => axios.put(`${API_URL}/${id}`, cliente);
export const deleteCliente = (id: string | number) => axios.delete(`${API_URL}/${id}`);
