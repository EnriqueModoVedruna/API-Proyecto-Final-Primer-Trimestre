# API-Proyecto-Final-Primer-Trimestre
Como proyecto final del primer trimestre tengo que hacer una API que se conecte a una base de datos Workbench con 6 tablas

Estas tablas son 4 que almacenan el contenido y las otras 2 son las tablas intermedias que sirven como relación.

## Instalación
1. Copiar el enlace desde el botón **<> Code**
2. Posicionarnos en la carpeta de nuestro ordenador donde vamos a almacenar el repositorio. Dentro de esta carpeta hacemos <ins>click derecho</ins> y seleccionamos **Open Git Bash here**
3. Se nos abrirá la terminal y tendremos que poner **git clone + el_enlace_del_proyecto**

Con esto ya tendremos el proyecto en nuestro ordenador, ahora toca arrancarlo

1. En la barra de navegación del proyecto, nos vamos hacia el apartado de **maven**
2. Cuando abrimos la lista desplegable tenemos que desplegar **Lifecircle**
3. Dentro tendremos bastantes opciones, nos dirigimos a **install** y con esto el proyecto deberia de funcionar

## Vistazo al ManyToMany utilizado en las tablas

La relación sería Many to Many entre las tablas:
- Desarrolladores (Developers) -> Proyectos (Projects) Tabla intermedia: developers_worked_on_projects
- Tecnologias (Technologies) -> Proyectos (Projects) Tabla intermedia: technologies_used_in_projects

````java
// Developers
@ManyToMany(fetch= FetchType.LAZY) // Hacemos la relacion ManyToMany, indicando la tabla intermedia
    @JoinTable(
        name = "developers_worked_on_projects", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "developers_dev_id"), // Columna de esta entidad en la tabla intermedia
        inverseJoinColumns = @JoinColumn(name = "projects_project_id") // Columna de la otra entidad en la tabla intermedia
    )
    List<Projects> proyectosDesarrolladores;
````

##
