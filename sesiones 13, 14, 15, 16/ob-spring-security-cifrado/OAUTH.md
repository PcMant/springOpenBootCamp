
## Open Authorization (OAuth)

Es un framework de autorización, abierto y está construido estándares
IETF y licenciado bajo Open Web Fundation.

Es un protocolo de delegación:

Permite que alguien que controla un recurso permita a una aplicación
de software acceder a ese recurso en su propio nombre sin pasar por ello.

Con la ayuda de OAuth los usuario pueden autorizar a third part applications
a acceder a sus datos o ejecutar determinadas operaciones sin necesidad de 
proporcionar usuario y contraseña.

## Flujo de trabajo con OAuth:

1. Una aplicación solicita autenticación
2. Se realiza login mediante Google
3. La aplicación se cominica con Google donde utilizan las credenciales 
de Google sin que la aplicación pueda verlas.
4. El servidor de Google pregunta al usuario si desea ceder X permisos
5. El usuario acepta los permisos
6. Google genera un token de acceso como respuesta
7. La aplicación utiliza ese token

## Escenarios para utilizar OAuth

1. Autenticación HTTP en la que no se quiere utilizar usuario y contraseña
todo el tiempo
2. Múltiples aplicaciones dentro de una misma empresa y en consecuencia
multiples cuentas con el mismo usuario 
3. Arquitecturas de microservicios
4. Interacción de aplicaciones de terceros

## Proveedores

Google, Github, Facebook, Okta

## OAuth en Spring Security

Inicialmente había un proyecto llamado Spring Security 0Auth.

En 2018 se sobrescribe para hacerlo más eficiente, con un código más
sencillo.

Se depreca el antiguo (https://spring.io/projects/spring-security-oauth)
y ahora OAuth está integrado en el propio Spring Security.

Incluye:

* Client Support
* Resource server
* Authorization Server: https://github.com/spring-projects/spring-authorization-server

Keycloak : https://www.keycloak.org/

Ver ejemplos de aplicaciones: https://github.com/spring-guides/tut-spring-boot-oauth2

## Flujos de acción OAuth:

* Authorization code
* Implicit
* Resource Owner password credentials
* Client Credentials
* Refres Token

## OpenId Connect

* OpenID Connect --> Authentication
* OAuth 2.0 --> Authorization
* HTTP