CSOF5101 - Conceptos Avanzados de Ingenier�a de Software
Personal Software Process (PSP) for Engineers
Johann De Jesus Olaya Herrera
Fecha : 2017-03-07

Instrucciones para obtener repositorio desde GitHub :
1. En el directorio en que desea descargar el proyecto ejecute el comando : git clone https://github.com/johannolayaherrera/Ecos_Tarea3.git

Intrucciones de ejecuci�n :

Desp�es de obtener la informaci�n desde el repositorio

1. Ejecute desde el directorio del proyecto "\src\MavenRegresion" el comando : mvn package
2. Luego el comando : mvn exec:java -Dexec.mainClass="com.uniandes.ecos.MavenRegresion.Controlador.EstadisticoControlador" 
3. En la interfaz ingrese la ruta del archivo de datos (.txt).

Nota: El archivo de datos es un archivo de texto plano(.txt). Por cada registro se debe tener un salto de l�nea, un registro comprende los valores de X y Y
estos valores est�n separados por el simbolo "_".

Ejemplo : 
180_90
170_80


