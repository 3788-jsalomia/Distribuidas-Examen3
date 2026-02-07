import { useEffect, useState } from "react";
import { getPolizas, createPoliza, deletePoliza } from "../api/polizaApi";

export function usePolizas() {
    const [polizas, setPolizas] = useState<any[]>([]);

    const loadPolizas = async () => {
        const res = await getPolizas();
        setPolizas(res.data);
    };

    const addPoliza = async (poliza: any) => {
        await createPoliza(poliza);
        loadPolizas();
    };

    const removePoliza = async (id: string | number) => {
        await deletePoliza(id);
        loadPolizas();
    };

    useEffect(() => {
        loadPolizas();
    }, []);

    return { polizas, addPoliza, removePoliza };
}
