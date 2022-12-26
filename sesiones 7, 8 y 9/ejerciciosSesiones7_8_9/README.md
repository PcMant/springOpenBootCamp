# Ejercicios sesiones 7, 8 y 9

# Ejercicio 1

Implementar los métodos CRUD en el API REST de Laptop creada en ejercicios anteriores.

Los métodos CRUD:
* findAll()
* findOneById()
* create()
* update()
* delete()
* deleteAll()

## Ejercicio 2

Implementar swagger sobre el API REST de Laptop y verificar que funciona en la
URL: [http://localhost:8081/swagger-ui/](http://localhost:8081/swagger-ui/).

**Nota**: Debido a que la librería swagger utilizada en las sesiones es
incompatible con Spring Boot 3 y su falta de mantenimiento, he tenido que usar
otra librería que si lo es. [https://springdoc.org/v2/](https://springdoc.org/v2/)

## Ejercicio 3

Crear casos de test para el controlador de Laptop desde Spring Boot. 
Con click derecho dentro del código de la clase LaptopController utilizar 
la opción Generate > Test para crear la clase con todos los tests 
unitarios e implementarlos siguiente el proceso visto en clase.