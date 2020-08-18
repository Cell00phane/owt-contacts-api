# Build user project with maven and copy the users jar to docker topology
cd contacts-api || exit
mvn clean package install -DskipTests
cp target/contacts-api-0.0.1-SNAPSHOT.jar ../docker/docker-images/backend/

# Go back to project root
cd ..

# Go back to docker topology
cd docker || exit

# docker compose
# Make sure to down it before executing again
docker-compose down
docker-compose up --build

# Shut everything down when done
docker-compose down

# Clean docker (For my memory). You can comment these lines if you don't want a clean up of your system.
docker system prune
docker volume prune

