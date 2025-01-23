Proyecto Spring Boot con SQLite

Este proyecto es una aplicación basada en Spring Boot utilizando SQLite como base de datos y JUnit para las pruebas unitarias.

Requisitos previos
Antes de comenzar, asegúrate de tener los siguientes requisitos instalados:

Java 23.0.2 o superior.
Maven o Spring Boot CLI para ejecutar los comandos.

Inicialización del proyecto
Para ejecutar el proyecto, utiliza el siguiente comando en el directorio raíz del proyecto:

En Windows:
mvnw.cmd spring-boot:run
En Linux/Mac:
./mvnw spring-boot:run

Este comando iniciará el servidor Spring Boot y el proyecto estará disponible en http://localhost:8080/ (o el puerto configurado en tu archivo application.properties).

Configuración de la base de datos (SQLite)

No es necesario realizar ninguna configuración con la base de datos, ya que se adjunta en el repositorio.

La base de datos SQLite está configurada en el archivo src/main/resources/application.properties. Ejemplo de configuración:

spring.datasource.url=jdbc:sqlite:src/main/resources/db/database.db
spring.datasource.driverClassName=org.sqlite.JDBC
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.jpa.database-platform=org.hibernate.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update

Este archivo conecta tu aplicación con una base de datos SQLite que se encuentra en la raíz del proyecto. Puedes cambiar la URL de la base de datos si lo deseas, pero no es necesario, según la ubicación y el nombre que des a tu archivo de base de datos.

Ejecución de pruebas unitarias
Este proyecto utiliza JUnit para las pruebas unitarias. Para ejecutar las pruebas, usa el siguiente comando:

mvn test
Este comando ejecutará las pruebas unitarias configuradas en el proyecto y mostrará los resultados en la consola.
