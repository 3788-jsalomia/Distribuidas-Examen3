import axios from "axios";

const API_URL = "http://localhost:8083/api/poliza";

export const getPolizas = () => axios.get(API_URL);
export const createPoliza = (poliza: any) => axios.post(API_URL, poliza);
export const deletePoliza = (id: string | number) => axios.delete(`${API_URL}/${id}`);
