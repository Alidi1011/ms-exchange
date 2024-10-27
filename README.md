# ms-exchange
Microservicio para gestionar cambio de moneda

# Docker

1. Generamos nuestro jar.

> mvn clean package

2. Elaboramos el archivo Dockerfile en el directorio raiz del proyecto.

> Dockerfile:
FROM openjdk:17
WORKDIR /app
COPY ./target/ms-exchange-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ms-exchange-0.0.1-SNAPSHOT.jar"]


3. Construimos la imagen.
> docker build -t exchange .
> docker build -t exchange .  -f .\ms-exchange\Dockerfile

4. Crear una nueva red

> docker network create springboot

5. Instanciamos la imagen, construir contenedor:

> docker run -p 8080:8080 --name ms-exchange --network springboot exchange

# OPENAPI

http://localhost:8080/swagger-ui/index.html

http://localhost:8080/v3/api-docs