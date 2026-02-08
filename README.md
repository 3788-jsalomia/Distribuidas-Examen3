# Despliegue de Microservicios con Kubernetes

Este proyecto contiene un sistema basado en microservicios desplegado en **Kubernetes**, compuesto por:

*  Microservicios backend (Spring Boot)

  * ms-clientes (PostgreSQL)
  * ms-planseguro (PostgreSQL)
  * ms-poliza (MySQL)
*  Bases de datos

  * PostgreSQL (clientes y planseguro)
  * MySQL 8 (poliza)
*  Frontend

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
kubectl apply -f postgres-clientes-deployment.yaml
kubectl apply -f postgres-clientes-service.yaml
kubectl apply -f postgres-clientes-config.yaml
```

### PostgreSQL – Plan Seguro

```bash
kubectl apply -f postgres-planseguro-deployment.yaml
kubectl apply -f postgres-planseguro-service.yaml
kubectl apply -f postgres-planseguro-config.yaml
```

### MySQL – Póliza

```bash
kubectl apply -f mysql-deployment.yaml
kubectl apply -f service-mysql.yaml
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
docker build -t micro-clientes:v1 .
docker build -t micro-plan:v1 .
docker build -t micro-poliza:v1 .
```

📌 Las imagenes estan cargadas en docker hub de los microservicios y frontEnd

```bash
MS:
https://hub.docker.com/repository/docker/jsalomia/micro-clientes/general
https://hub.docker.com/repository/docker/jsalomia/micro-plan/general
https://hub.docker.com/repository/docker/jsalomia/micro-poliza/general
FRONT END:
https://hub.docker.com/repository/docker/jsalomia/frontend-seguros/general

```
---

## 4️⃣ Desplegar los microservicios

```bash
kubectl apply -f micro-clientes-deployment.yaml
kubectl apply -f micro-plan-deployment.yaml
kubectl apply -f micro-poliza-deployment.yaml

Para crear el servicio de cada ms:
kubectl expose deployment micro-clientes --port=8081 --type=LoadBalancer -n seguros
kubectl expose deployment micro-plan --port=8082 --type=LoadBalancer -n seguros
kubectl expose deployment micro-poliza --port=8083 --type=LoadBalancer -n seguros
```

Verificar:

```bash
kubectl get pods -n seguros
kubectl get svc -n seguros
```

---

## 5️⃣ Desplegar el frontend

```bash
kubectl apply -f deployment–frontend.yaml
kubectl apply -f Service–Frontend.yaml
kubectl port-forward svc/frontend 8080:80 -n seguros
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
