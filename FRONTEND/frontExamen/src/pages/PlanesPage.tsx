import { usePlanes } from "../hooks/usePlanes.ts";
import PlanForm from "../components/planes/PlanForm";

export default function PlanesPage() {
  const { planes, addPlan, removePlan } = usePlanes();

  const styles = {
    container: {
      maxWidth: "700px",
      margin: "40px auto",
      padding: "20px",
      fontFamily: "Arial, sans-serif",
      backgroundColor: "#f9fafb",
      borderRadius: "8px",
      boxShadow: "0 4px 10px rgba(0,0,0,0.1)"
    },
    title: {
      textAlign: "center" as const,
      marginBottom: "20px",
      color: "#1f2937"
    },
    formContainer: {
      marginBottom: "30px",
      padding: "15px",
      backgroundColor: "#ffffff",
      borderRadius: "6px",
      boxShadow: "0 2px 6px rgba(0,0,0,0.08)"
    },
    list: {
      listStyle: "none",
      padding: 0,
      margin: 0
    },
    listItem: {
      display: "flex",
      justifyContent: "space-between",
      alignItems: "center",
      padding: "12px 16px",
      marginBottom: "10px",
      backgroundColor: "#ffffff",
      borderRadius: "6px",
      boxShadow: "0 1px 4px rgba(0,0,0,0.08)"
    },
    planName: {
      fontWeight: 600,
      color: "#111827"
    },
    deleteButton: {
      backgroundColor: "#ef4444",
      color: "#ffffff",
      border: "none",
      padding: "6px 12px",
      borderRadius: "4px",
      cursor: "pointer",
      fontSize: "14px"
    }
  };

  return (
    <div style={styles.container}>
      <h2 style={styles.title}>Gestión de Planes</h2>

      <div style={styles.formContainer}>
        <PlanForm onSave={addPlan} />
      </div>

      <ul style={styles.list}>
        {planes.map((p: any) => (
          <li key={p.id} style={styles.listItem}>
            <span style={styles.planName}>{p.nombre}</span>

            <button
              style={styles.deleteButton}
              onClick={() => removePlan(p.id)}
            >
              Eliminar
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}
