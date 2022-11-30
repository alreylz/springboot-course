<img height="auto" src="C:\Users\cored\Desktop\Github\springboot-course\setup\images\springboot-course.jpg" width="50%"/>

# TIW [2022-23] SpringBootCourse
**Author :@alreylz** 

### Ejemplos funcionales de SpringBoot/Spring Framework para la asignatura de Tecnologías Informáticas para la Web (2022-2023)


## 0. Configuración para ejecutar los ejemplos

---

`/setup`: Contiene datos de ejemplo que pueden ser usados para inicializar la persistencia (rellenar la base de datos) E.g., scripts de bases de
datos, imágenes de prueba, etc.

Importante saber en qué puerto está ejecutando nuestra aplicación a la hora de probar las APIs, puesto que  (ver archivo `applicacion.properties`).

## 1. Spring Web: Respondiendo a peticiones HTTP

---

### <span style="color:teal">El "Nuevo Servlet" -> Respondiendo a peticiones HTTP (GET/POST/PUT/DELETE)</span>

<code>representations/...</code> -> Clases sin respaldo en base de datos que pueden ser devueltas como representación al llamarse a nuestra API REST

<code>controllers/BasicController</code> -> Clase con @Controller que tiene una serie de endpoints accesibles y que demuestran el uso de spring web para contestar peticiones.


### <span style="color:teal">Creación de APIs REST con Spring +  devolver representaciones JSON/XML </span>

<code>representations/...</code> -> Clases sin respaldo en base de datos que pueden ser devueltas como representación al llamarse a nuestra API REST

<code>controllers/SampleWebControllerNoPersistence</code> -> Controlador que ejemplifica un API rest pero sin respaldo con base de datos (se simula la persistencia por medio de una serie de listas que se van actualizando según las peticiones que se realicen.)

### <span style="color:teal">API Rest con control de códigos de estado (ResponseEntity<>)</span>

<code>controllers/ComputerRestControllerWResponseEntity</code> --> Clase controller con respaldo en base de datos que hace accesibles una serie de enpoints para Crear, Actualizar, Eliminar y Buscar objetos 'Computer'

<code>repos/ComputerDAO</code> --> DAO que extiende de CrudRepository para la gestión de objetos 'Computer'

<code>mysql.entities/Computer</code> -> Clase entidad asociada con la base de datos

## 2. Persistencia (Spring Data):

---
Acceso a base de datos y realización de operaciones a nivel de objeto con JPA.

Importante especificar en el archivo `application.properties` los valores correctos para usuario, contraseña y uri de la base de datos (obligatorio para MySQL).

### <span style="color:#b731ae"> CRUD(Create,Read,Update,Delete) sobre Mysql</span>


#### <span style="color:teal"> Person REST API <span style="color:yellow">(Work In Progress)</span></span>

...

#### <span style="color:teal"> Computer REST API </span>

<code>mysql.entities/Computer</code> -> Clase entidad asociada con la base de datos

<code>repos/ComputerDAO</code> -> DAO que extiende de CrudRepository para la gestión de objetos 'Computer'

<code>controllers/ComputerRestController</code> -> Controlador encargado de hacer accesible la API

### <span style="color:#b731ae">CRUD MongoDB </span>

#### <span style="color:teal">Person REST API <span style="color:yellow">(Work In Progress)</span> </span>
 
<code>mysql.documents/Person</code> -> Clase @Document que tiene asociada una colección en MongoDB

<code>repos/MongoRepo</code> -> DAO que extiende de CrudRepository y accede a MongoDB

<code>controllers/MongoController</code>

... <span style="color:yellow">More examples coming </span>

## 3. Vistas y  consumo de APIs REST: <span style="color:yellow">(Work In Progress)</span>

---
#### <span style="color:teal">JSP en Spring (no recomendado) : Necesita configuraciones varias y está deprecado</span>

Necesario crear sistema de carpetas <code>webapp/WEB-INF/views</code> donde metereremos las vistas .jsp

Descomentar la clase `ConfigEnableJSPAndThymeleaf.java` para poder usar JSPs y Thymeleaf a la vez (pero todas las vistas han de ir dentro de la carpeta anteriormente mencionada)

#### <span style="color:teal">Thymeleaf</span>

<code>templates/ShowPersonData.html</code> -> Construye una tabla dinámicamente que muestra todos los elementos 'Person' que hay en la base de datos mysql

<code>templates/PersonCreateForm.html</code> -> Muestra un formulario de thymeleaf y especifica dinámicamente la url a la que se realiza la petición para insertar a una persona.

<code>controllers/ThymeleafControllers</code> -> Clase controlador que permite mostrar las vistas asociadas y que le pasa la información a mostrar a estas por medio de la clase Model.

... <span style="color:yellow">More examples coming </span>


### Consumo de API Rest en Spring

RestTemplate, códigos de estado y peticiones a microservicios desde otros microservicios o el front.

<code>controllers/SpringAPIConsumer </code> -> Urls que ser solicitadas realizan llamadas a una API y muestran el resultado de las mismas. Usan una instancia de RestTemplate para realizar las llamadas a APIs.

<code>controllers/ComputerRestController </code> -> Código de la API REST que responde a las peticiones como tal


## 4. Spring Security: <span style="color:yellow">(Work In Progress)</span>

---


