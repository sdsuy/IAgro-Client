
# Welcome to IAgro application's Client repo 
### hosting Stigma Software's rendition for the Testing and Development Proyect of UTEC's ITL

This repo contains source code for the Client-side proyect divided into aplication, presentation and remote folders under the src/com folder as well as a separate images folder.
/Application/ folder holds the main class for the client wich runs the application interface components and defines functions that mainly connect UI calls to remote calls but also 
provide general application flow and bootstrap.
/Presentation/ folder bears all layout classes for each component: Login, Main Menu, List Activities, Create Activities, Create User, List Forms, Create Forms and more, these
classes utilize Java Swing library and feature all the graphic elements of the app as well as interaction and event listeners.
/Remote/ folder contains all Business Object classes wich lay out functions that load elements from the server trough remote calls to bean objects.

Project Configuration:
This Java proyect was built using Eclipse IDE (www.Eclipse.org) running on JDK 1.8 and Java Swing Library, we also load jboss-client library to connect to the WildFly server (www.WildFly.org)

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Bienvenido al repositorio de la app cliente IAgro por Stigma Softwares 
### para la rendicion del Proyecto de Desarrollo y Testing 2020 de la carrera LTI de UTEC

Este repositorio contiene codigo fuente para el proyecto del lado cliente, dividido en ficheros aplicacion, presentacion y remoto, dentro de la carpeta src/com ademas de un fichero
particular para las imagenes.
El fichero /application/ mantiene la clase principala para el cliente, que corre los componetes de interfaz del aplicativo y define funciones que conectan llamados de UI con los
objetos de negocio pero tambien provee funcionamiento general de aplicacion y bootstrap.
Fichero /presentation/ alberga todas las clases de compaginación para cada componente: Logueo, Menu Principal, Listado de Actividades, Creacion de Actividades, Creacion de Usuario, 
Listado de Formularios, Creacion de Formularios y mas, se utiliza la librería Java Swing y aparecen todos los elementos graficos de la app asi como la interaccion y manejo de 
eventos.
La carpeta /remote/ contiene las clases de Objetos de Negocio que presentan funciones para cargar elementos desde el servidor a través de llamados remotos a Java Beans

Configuración del Proyecto:
Este proyecto Java se construyó usando IDEs de Fundación Eclipse (www.Eclipse.org) y corre en JDK versión 1.8
Se utiliza la librería Java Swing y también la librería jboss-client para realizar la conección con el servidor WildFly (www.WildFly.org)





