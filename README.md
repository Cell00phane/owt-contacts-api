# owt-contacts-api
A SpringBoot project exposing a simple Contacts API and documented using Swagger 2

## QuickStart
To launch the application, you can use the start shell `launch.sh` that we've conveniently provided to 
build the Spring server and launch the docker topology.

The docker topology contains:
- A mysql container for the database.
- A SpringBoot Java server container.
- A phpmyadmin console container to view the database.

Once the docker topology is up, you can access the API via `localhost:8080/api` where you will see a Swagger documentation
of the Contacts API, and where you try out some requests.
