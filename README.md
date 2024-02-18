Estoy creando una aplicación para android y pc que sea el cuaderno de un entrenador de baloncesto. Esta tendra una serie de funcionalidades que ayuden al entrenador a planificar tanto la temporada, como los entrenamientos y partidos.
Entre las vistas que he pensado que tendra la aplicación estan estas:
    - Login
    - Registro
    - Vista principal: En ella aparcera el calendario de partidos, las 3 ultimas estaditicas de los partios jugador, los ojetivos de la planificación de la semana de los entrenamientos y algun comentario o anatacion hecha por en entrenador.
    - Vista Equipos:
        - Vista añadir equipo: donde se podra configurar el equipo, poner nombre, donde juega, foto del escudo y otros datos interantes
        - Vista Plantilla: En se podrá configurar los direntes equipos que gestione el entrenado y añadir los jugaores de la plantilla, crear una planificación de entrenmiento de la temporada, ver el calendario de partidos, ver las estadisticas de los partido
            - Vista CRUD para los jugadores en el equipo
            - Vista planificación del equipo (Extencion de la vista planificación)
            - Vista resulatdos
            - Vista estadisticas
                - Se podran ver los estadisticas anotadas en la vista partido.
                - Se podra imprimir informes de esas estadisticas
            - Vista calendario
                - Se podran añadir eventos, fechas de partidos y entrenamientos
            - Vista anotaciones
                - Se podran anadir anotaciones que considere el entrenador
            - Vista jugador
                - Se podran ver las estadisticas
                - Planificación para el jugador (Extencion de la vista planificación)
                - Anotaciones de los entrenadores
            - Vista CRUD para los ojetivos
    - Vista partidos
        - Sera una vista donde primero se seleccionara el equipo que representas y tu rival si los equipos estan previmamente creados no hara falta crearlos
        - Se anotaran los tiros, faltas, el tiempo, rebotes ... todas las estadisticas relevantes para un entrenador
    - Vista planificación
        - Se podra planificación tanto semanalmente como anualmente
        - Vista CRUD pare los Ejercicios
        - Se podran poner en una especie de calendario los ejercicios
        - Vista informes de planificación
    - Vista pizara tactica
    - Settings donde cada entrenador pueda configurarse la aplicación un poco
Quiero que las difrentes vistas respresenten la tematica del basquet y que estas tengan un diseño simple y elegante. Que no esten cargadas de demasida información.

Te envio tambien 3 bocetos de vistas y modales de como me gustaria que fuera la aplicacion. La app va utilizar tanto jetpack compose para el desarollo en android como kotlin compose para el desarollo en pc. Y seguir las directrices de material Design.
