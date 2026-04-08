# MathServicesLambda

Proyecto de ejemplo en Java para exponer microservicios sencillos mediante **AWS Lambda** y **API Gateway**. El objetivo del taller es mostrar el ciclo completo de construcci\u00f3n, empaquetado y despliegue de funciones Lambda escritas en Java, as\u00ed como su exposici\u00f3n como servicios HTTP.

## Objetivos logrados

- Configuramos un proyecto **Maven** en Java 8 para AWS Lambda.
- Implementamos una clase de servicios de dominio `MathServices` con la l\u00f3gica de negocio.
- Creamos dos handlers Lambda:
  - `SquareHandler`: calcula el cuadrado de un n\u00famero entero.
  - `GetUserHandler`: construye un objeto de usuario de ejemplo a partir de los datos de entrada.
- Configuramos el `maven-shade-plugin` para generar un **fat JAR** listo para subir a Lambda.
- Probamos localmente la l\u00f3gica de negocio (m\u00e9todos `square` y `getUser`).
- Dejamos listo el artefacto para integrarlo con **API Gateway** y exponerlo como microservicio REST.

## Estructura del proyecto

- `pom.xml`: configuraci\u00f3n Maven del proyecto, dependencias y plugin de empaquetado.
- `src/main/java/co/edu/escuelaing/services/MathServices.java`
  - `square(Integer i)`: retorna el cuadrado de `i`.
  - `getUser(Integer id)`: construye un `String` de ejemplo con los datos de un usuario a partir de su id.
- `src/main/java/co/edu/escuelaing/services/SquareHandler.java`
  - Implementa `RequestHandler<Integer, Integer>` de AWS Lambda.
  - Recibe un entero como entrada y retorna su cuadrado utilizando `MathServices.square`.
- `src/main/java/co/edu/escuelaing/services/GetUserHandler.java`
  - Implementa `RequestHandler<Map<String,String>, String>`.
  - Espera un JSON con campos `name` y `email` y devuelve una representaci\u00f3n tipo `User{ name='...', email='...' }`.

## Tecnolog\u00edas utilizadas

- **Java 8**
- **AWS Lambda Java Core** (`com.amazonaws:aws-lambda-java-core:1.2.3`)
- **Maven** para la gesti\u00f3n de dependencias y el build
- **maven-shade-plugin** para generar el JAR ejecutable (fat JAR)

## Construcci\u00f3n del proyecto

Desde la carpeta `MathServicesLambda`:

```bash
mvn clean package
```

Esto genera un JAR en la carpeta `target/` (usando el `maven-shade-plugin`) que puede ser subido directamente a AWS Lambda como c\u00f3digo de la funci\u00f3n.

## Despliegue en AWS Lambda (resumen)

1. Ejecutar el build:
   ```bash
   mvn clean package
   ```
2. En la consola de AWS Lambda, crear una nueva funci\u00f3n Lambda basada en un **JAR** de Java.
3. Subir el archivo JAR generado en `target/`.
4. Configurar el **Handler** de acuerdo a la clase correspondiente, por ejemplo:
   - Para el cuadrado: `co.edu.escuelaing.services.SquareHandler::handleRequest`
   - Para el usuario: `co.edu.escuelaing.services.GetUserHandler::handleRequest`
5. (Opcional) Configurar un **API Gateway** HTTP/REST que invoque la funci\u00f3n Lambda y as\u00ed exponer el servicio v\u00eda HTTP.

## Ejemplos de uso

### SquareHandler

Entrada (evento JSON enviado a Lambda):

```json
5
```

Salida:

```json
25
```

### GetUserHandler

Entrada (evento JSON):

```json
{
  "name": "Alice",
  "email": "alice@example.com"
}
```

Salida:

```text
User{name='Alice', email='alice@example.com'}
```

## C\u00f3mo subir este proyecto a GitHub

Suponiendo que ya tienes una cuenta de GitHub y deseas usar el repositorio remoto:

`https://github.com/AllanContreras/Taller-de-Microservicios-y-AWS-lambda.git`

Desde la carpeta raiz del proyecto que contiene `MathServicesLambda` (por ejemplo `Hello-World-AWS-Lambda-y-Gateway-Services-en-Java`), puedes ejecutar los siguientes comandos:

```bash
cd c:\Users\allan\Downloads\Hello-World-AWS-Lambda-y-Gateway-Services-en-Java

# Inicializar el repositorio (si todav\u00eda no es un repo git)
git init

# Agregar el repositorio remoto de GitHub
git remote add origin https://github.com/AllanContreras/Taller-de-Microservicios-y-AWS-lambda.git

# Agregar todos los archivos al \u00edndice
git add .

# Crear un commit con los cambios
git commit -m "Proyecto MathServicesLambda con handlers de ejemplo"

# Subir al branch principal (main o master seg\u00fan como est\u00e9 configurado el repo remoto)
git branch -M main

git push -u origin main
```

> Nota: Es posible que GitHub te pida autenticaci\u00f3n (usuario/contrase\u00f1a o token personal). Sigue las instrucciones que aparezcan en la terminal.

Con esto, el proyecto (incluyendo este `README.md`) quedar\u00e1 subido al repositorio remoto proporcionado.