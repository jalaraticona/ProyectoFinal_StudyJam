Proyecto Final - Study Jam II 2016
===

<div align="center">
    <center>
        <img src="http://developerstudyjams.com/images/masthead.png" width="400px"/>
    </center>
</div>

Este es el Proyecto Final del Study Jam Android Development for Beginners II 2016, llevado a cabo en la ciudad de La Paz, Bolivia a cargo del representante del GDG Android Bolivia Gustavo Lizarraga</a> .

Nombre Aplicación.
---
Reproductor StudyJam Player Pro

Objetivo
---
Reproduccion de musica obteniendo los datos desde la SD CARD

Caracteristicas
---
* Manejo de archivos
* Manejos de listas con intents
* Aplicacion con algunas animaciones

Wireframes
---
Se puede visualizar la presentacion en el siguiente link:
http://ninjamock.com/s/7ZBMG

Compatibilidad
---
Esta aplicación es compatible con versiones de Android 6.0 o y 7.0 preferentemente en dispositivos huawei.

Uso
---------
Para probar este ejemplo clona este repositorio de la siguiente forma:
>
>     $ git clone https://github.com/jalaraticona/ProyectoFinal_StudyJam.git

Luego de ello dentro de Android Studio:

* File --> New --> Import Project 
* Seleccionas la ruta donde hiciste el `clone` del proyecto.
* Build --> Rebuild Project
* Run 

Corrida previa
---
Aca te muestro cual es el funcionamiento de mi aplicación a grandes rasgos.
<div align="center">
    <center>
        <table border="0">
            <tr>
                <td><img src="https://github.com/Gusn8/StudyJam_II_CustomListViews/blob/master/img/captura.gif" width="250"></td>
                <td><img src="https://github.com/Gusn8/StudyJam_II_Animations/raw/master/img/corrida_02.gif" width="250"></td>
                <td><img src="https://github.com/Gusn8/StudyJam_II_Intents/raw/master/img/corrida_02.gif" width="250"></td>
            </tr>
        </table>
    </center>
</div>
<br>

Descripción técnica
---
Se utilizáron los siguientes componentes tanto en el `diseño` como en la `funcionalidad`:

**`Vista:`**
* LinearLayout (Horizontal) para la alineación de las vistas principales.
* RelativeLayout, para el acomodamiento de la segunda pantalla: SegundaActivity.
* ListView, para listar las musicas de la SD CARD
* TextView, para mostrar información acerca de las pistas musicales.
* ImageView, para mostrar una imagen
.
.
.

**`Funcionalidad:`**
* MediaPlayer, para reproducir la canción desde la memoria interna.
* Ciclo de vida de una Activity, para detectar cuando se coloca en Pausado asi pueda seguir ejecutandose una tarea.
.
.
.

**`Tareas pendientes:`**
En base a esta idea no se pudo completar con las siguientes caracteristicas:
* Manejo de metadatos de la musica.
* Boton de busqueda especifica de la musica.
* Botones dinamicos y con animaciones.
* Manejo de ProgessBar.
* A sugerencia de personas que utilizaron la app cambio de diseñ<o></o>.
.
.
.

Autor
---
Jorge Abimael Lara Ticona

Contactos
---
laraticonajorge@gmail.com

[Facebook](https://www.facebook.com/jorgelaraticona) <br>
[Github](https://www.github.com/jalaraticona)<br>
