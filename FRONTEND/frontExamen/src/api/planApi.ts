import axios from "axios";

const API_URL = "http://localhost:8082/api/plan";

export const getPlanes = () => axios.get(API_URL);
export const getPlanById = (id: string | number) => axios.get(`${API_URL}/${id}`);
export const createPlan = (plan: any) => axios.post(API_URL, plan);
export const updatePlan = (id: string | number, plan: any) => axios.put(`${API_URL}/${id}`, plan);
export const deletePlan = (id: string | number) => axios.delete(`${API_URL}/${id}`);
