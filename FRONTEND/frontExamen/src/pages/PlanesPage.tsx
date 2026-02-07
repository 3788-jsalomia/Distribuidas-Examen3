import { usePlanes } from "../hooks/usePlanes.ts";
import PlanForm from "../components/planes/PlanForm";

export default function PlanesPage() {
  const { planes, addPlan, removePlan } = usePlanes();

  return (
    <>
      <h2>Planes</h2>
      <PlanForm onSave={addPlan} />
      <ul>
        {planes.map((p: any) => (
          <li key={p.id}>
            {p.nombre}
            <button onClick={() => removePlan(p.id)}>Eliminar</button>
          </li>
        ))}
      </ul>
    </>
  );
}
