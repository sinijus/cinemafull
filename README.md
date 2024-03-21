    See on Jaanus Siniväli kinokava ja istekohtade pakkumise veebirakenduse proovitöö.
    
    Rakenduse jooksutamine:
        Käivita Docker Engine (n. Docker Desktop)
        Liigu terminalis projekti kausta ning sisesta: docker compose up 

        
    Kui Docker mingil põhjusel ei tööta:

    
    Vue-Vite config:
    Kommenteerida sisse välja vite.config.mjs järgmised read vastavalt kasutusele:
        //for development use
        //target: 'http://localhost:8080',
        //for Docker use
        // target: 'http://proovjsback:8080',

    Applications properties:
    Kommenteerida sisse välja application.properties järgmised read vastavalt kasutusele:

        #for development
        spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
        #for docker-compose
        #spring.datasource.url=jdbc:postgresql://db:5432/postgres