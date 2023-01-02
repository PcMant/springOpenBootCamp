# Ejercicios sesiones 10, 11 y 12

# Ejercicio 1
* Probar a empaquetar la aplicación con maven package desde Intellij IDEA
* Desde terminal en IntelliJ IDEA verificar que se ejecuta correctamente con el comando:
```
java -jar target/spring-deploy-1.0.jar
```
* Crear un perfil para dev y otro para test con una propiedad nueva que cargaremos en el controlador.

# Ejercicio 2
Desplegar el API REST de Latops en Heroku y verificar funcionamiento desde POSTMAN.

**Nota:** Heroku retiro sus planes gratuitos, en su lugar utilizar otra alternativa, en mi caso
[railway](https://railway.app/).

# Ejercicio 3
Añadir Spring Security sobre el proyecto API REST de Laptops y configurar 2 usuarios en memoria
utilizando una clase WebSecurityConfig.

**Nota**: Varios métodos se han quedado deprecated para más información
del nuevo modo mirar la documentación oficial.
[https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter](https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)

Además no olvidar añadir la siguiente dependencia al fichero "pomp.xml":

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
    <scope>test</scope>
</dependency>
```