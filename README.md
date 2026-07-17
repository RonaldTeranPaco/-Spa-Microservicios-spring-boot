<h2>NOTA: tener docker isntalado y ejecutar docker-compose.yml con el comando docker compose up.<h2/>
<img width="851" height="616" alt="image" src="https://github.com/user-attachments/assets/69a971c2-de77-4ab3-a703-faf4c9c8931b" />
Diseño de la arquitectura microservicio , separacion de los dominios de citas , historial y notificaciones.
cambiar las coneciones a las bases de datos. buscar y cambiar el correo para que mande.
el broker de kafka sirve para que cuando una cita se confirme se mande un envento al kafka y el dominio de notificaciones lo lea y mande un correo al paciente.

