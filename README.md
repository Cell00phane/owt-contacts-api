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

## Features not implemented:
- Users and user authentication should be done on a separate server (docker container). We should
not expose the user api to the users, only the authentication endpoint.
- User authentication (to be done on /authentications or /login endpoint).
- User authorization: Once authenticated, generate a jwt token that has as a claim the user's id.
Any API request should have that token attached to it in the authorization header.
Any incoming API request to our contacts API is intercepted (HandlerInterceptorAdapter)
and checks if the token is valid, and if so retrieves the user id and attaches it as an attribute to the request and
the request is passed down the normal pipeline. 
In the controllers, any unauthorized access, is verified using that attribute that we set, that checks if the user id
matches the owner id of the resource he's trying to access.
- Better exception handling with clearer messages and response codes.
