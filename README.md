# 🚀 Despliegue de Microservicios con Kubernetes

Este proyecto contiene un sistema basado en microservicios desplegado en **Kubernetes**, compuesto por:

* 🧩 Microservicios backend (Spring Boot)

  * ms-clientes (PostgreSQL)
  * ms-planseguro (PostgreSQL)
  * ms-poliza (MySQL)
* 🗄️ Bases de datos

  * PostgreSQL (clientes y planseguro)
  * MySQL 8 (poliza)
* 🌐 Frontend

Todo se ejecuta dentro del **namespace `seguros`**.

---


## 1️⃣ Crear el namespace

```bash
kubectl create namespace seguros
```

Verificar:

```bash
kubectl get namespaces
```

---

## 2️⃣ Desplegar las bases de datos

### PostgreSQL – Clientes

```bash
kubectl apply -f k8s/postgres-clientes.yaml
```

### PostgreSQL – Plan Seguro

```bash
kubectl apply -f k8s/postgres-planseguro.yaml
```

### MySQL – Póliza

```bash
kubectl apply -f k8s/mysql.yaml
```

Verificar:

```bash
kubectl get pods -n seguros
```

Todos deben aparecer en estado **Running**.

---

## 3️⃣ Construir imágenes Docker de los microservicios

Desde la raíz de cada microservicio:

```bash
mvn clean package -DskipTests
docker build -t micro-clientes:latest .
docker build -t micro-plan:latest .
docker build -t micro-poliza:latest .
```

📌 En Docker Desktop no es necesario hacer `docker push`.

---

## 4️⃣ Desplegar los microservicios

```bash
kubectl apply -f k8s/micro-clientes.yaml
kubectl apply -f k8s/micro-plan.yaml
kubectl apply -f k8s/micro-poliza.yaml
```

Verificar:

```bash
kubectl get pods -n seguros
kubectl get svc -n seguros
```

---

## 5️⃣ Desplegar el frontend

```bash
kubectl apply -f k8s/frontend.yaml
```

Obtener el puerto:

```bash
kubectl get svc frontend -n seguros
```

Acceder desde el navegador:

```
http://localhost:<NODE_PORT>
```

---

## 6️⃣ Verificación general

```bash
kubectl get all -n seguros
```

Estado esperado:

* Pods: `Running`
* Servicios: `ClusterIP / NodePort / LoadBalancer`
* Sin errores `CrashLoopBackOff`

---

## 7️⃣ Solución de problemas

### Ver logs de un microservicio

```bash
kubectl logs micro-poliza-XXXX -n seguros
```

### Reiniciar un deployment

```bash
kubectl rollout restart deployment micro-poliza -n seguros
```

### Ver detalles del pod

```bash
kubectl describe pod micro-poliza-XXXX -n seguros
```
