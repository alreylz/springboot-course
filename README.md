# TIW [2022-23] SpringBootCourse

**Author :@alreylz**

Ejemplos funcionales de SpringBoot/Spring Framework para la asignatura de Tecnologías Informáticas para la Web (
2022-2023)

`/setup`: Contiene datos de ejemplo que pueden ser usados para inicializar la persistencia. E.g., scripts de bases de
datos, modelado de bases de datos, imágenes de prueba, etc.

## 1. Spring Web: Respondiendo a peticiones HTTP

---



### <span style="color:teal">El "Nuevo Servlet" -> Respondiendo a peticiones HTTP (GET/POST/PUT/DELETE)</span>

<code>representations/...</code> -> Clases sin respaldo en base de datos que pueden ser devueltas como representación al llamarse a nuestra API REST

<code>controllers/BasicController</code> -> Clase con @Controller que tiene una serie de endpoints accesibles y que demuestran el uso de spring web para contestar peticiones.


### <span style="color:teal">Creación de APIs REST con Spring +  devolver representaciones JSON/XML </span>

<code>representations/...</code> -> Clases sin respaldo en base de datos que pueden ser devueltas como representación al llamarse a nuestra API REST

<code>controllers/SampleWebControllerNoPersistence</code> -> Controlador que ejemplifica un API rest pero sin respaldo con base de datos (se simula la persistencia por medio de una serie de listas que se van actualizando según las peticiones que se realicen.)



## 2. Persistencia (Spring Data):

---
Acceso a base de datos y realización de operaciones a nivel de objeto con JPA.
###CRUD(Create,Read,Update,Delete) sobre Mysql


#### <span style="color:teal"> Person REST API <span style="color:yellow">(Work In Progress)</span></span>

...

#### <span style="color:teal"> Computer REST API </span>

<code>mysql.entities/Computer</code> -> Clase entidad asociada con la base de datos

<code>repos/ComputerDAO</code> -> DAO que extiende de CrudRepository

<code>controllers/ComputerRestController</code> -> Controlador encargado de hacer accesible la API

### CRUD MongoDB

####<span style="color:teal">Person REST API <span style="color:yellow">(Work In Progress)</span> </span>
 
<code>mysql.documents/Person</code> -> Clase @Document que tiene asociada una colección en MongoDB

<code>repos/MongoRepo</code> -> DAO que extiende de CrudRepository y accede a MongoDB

<code>controllers/MongoController</code>

...

## 3. Vistas y  consumo de APIs REST: <span style="color:yellow">(Work In Progress)</span>

---

- JSP
- Thymeleaf

### Consumo de API Rest en Spring

RestTemplate, códigos de estado y peticiones a microservicios desde otros microservicios o el front.

## 4. Spring Security: <span style="color:yellow">(Work In Progress)</span>

---


