    See on Jaanus Siniväli kinokava ja istekohtade pakkumise veebirakenduse proovitöö.
    
    Rakenduse jooksutamine:
        Käivita Docker Engine (n. Docker Desktop)
        Liigu terminalis projekti kausta ning sisesta: docker compose up 

        
    Kui Docker mingil põhjusel ei tööta siis:
    cinemaback-is
        Kommenteerida sisse välja application.properties vajalikud read, et õige spring.datasource oleks kasutuses:
            #for development
            #spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
            #for docker-compose
            #spring.datasource.url=jdbc:postgresql://db:5432/postgres
    Intellij-s teha vajalikud andmebaasi, gradle-i ja/või muu vajaliku seadistused,
    jooksutada CinemabackApplication.
    Backendi saab kasutada ka iseseisvalt kasutades swaggerit,kui app on jooksutatud:
    http://localhost:8080/swagger-ui/index.html
    
    
    cinemafront-is
       Kommenteerida sisse välja vite.config.mjs vajalikud read, et õige target oleks kasutuses:
            //for development use
            //target: 'http://localhost:8080',
            //for Docker use
            //target: 'http://proovjsback:8080',
    
    Liikuda terminalis kausta cinemafront ning sisestada käsklused 
    npm install ning npm run dev 
