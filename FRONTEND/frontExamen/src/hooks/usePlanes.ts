import { useEffect, useState } from "react";
import { getPlanes, createPlan, deletePlan } from "../api/planApi";

export function usePlanes() {
    const [planes, setPlanes] = useState<any[]>([]);

    const loadPlanes = async () => {
        const res = await getPlanes();
        setPlanes(res.data);
    };

    const addPlan = async (plan: any) => {
        await createPlan(plan);
        loadPlanes();
    };

    const removePlan = async (id: string | number) => {
        await deletePlan(id);
        loadPlanes();
    };

    useEffect(() => {
        loadPlanes();
    }, []);

    return { planes, addPlan, removePlan };
}
