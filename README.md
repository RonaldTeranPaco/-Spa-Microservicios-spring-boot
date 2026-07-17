<h2>NOTA: tener docker isntalado y ejecutar docker-compose.yml con el comando "docker compose up".</h2>
<img width="851" height="616" alt="image" src="https://github.com/user-attachments/assets/69a971c2-de77-4ab3-a703-faf4c9c8931b" />

<h2>cosistema de Microservicios - Sistema de Gestión Clínica</h2>

<h2>Descripción</h2>

Este proyecto implementa una arquitectura de microservicios orientada a la gestión de citas médicas, historiales clínicos y notificaciones para un centro de salud. La solución está diseñada bajo los principios de sistemas distribuidos, favoreciendo la escalabilidad, el desacoplamiento y la resiliencia de cada dominio de negocio.

La comunicación entre los servicios combina llamadas síncronas vía REST y comunicación asíncrona basada en eventos a través de Apache Kafka, permitiendo que los distintos dominios evolucionen de forma independiente sin comprometer la consistencia del sistema en su conjunto.

<h2>**Arquitectura**</h2>

<h2>El ecosistema está compuesto por los siguientes componentes:<h2/>

<h3>API Gateway</h3>

Punto de entrada único del sistema. Enruta las solicitudes de los clientes hacia los microservicios correspondientes, centralizando aspectos transversales como el ruteo y la seguridad de acceso.

<h3>Microservicios de dominio</h3>


<h3>Dominio Citas:</h3> gestiona la creación, modificación y consulta de citas médicas. Cuenta con su propia base de datos y se comunica de forma síncrona (REST) con el Dominio Historial Clínico, además de publicar eventos hacia el broker de Kafka.
<h3>Dominio Historial Clínico:</h3> administra la información clínica de los pacientes, con persistencia propia y comunicación directa con el Dominio Citas.
<h3>Dominio Notificaciones:</h3> se encarga del envío de notificaciones a los usuarios (por ejemplo, confirmaciones o recordatorios de citas), consumiendo eventos publicados en Kafka y almacenando su propio estado en base de datos.


<h3>Comunicación asíncrona</h3>


Broker Kafka: actúa como intermediario de mensajería entre el Dominio Citas y el Dominio Notificaciones, desacoplando la generación de eventos de su procesamiento y garantizando mayor tolerancia a fallos.


<h3>Infraestructura de soporte</h3>


Eureka: servidor de service discovery, encargado del registro y descubrimiento de los microservicios dentro del ecosistema.
Servidor de Configuración: centraliza la configuración de todos los microservicios, permitiendo gestionar parámetros de forma unificada y desacoplada del código fuente de cada servicio.

