# How to test this?


1. [Install Docker Compose](https://docs.docker.com/compose/install/)
2. Open docker
3. Clone this repository
4. Move to folder of project 
5. Run all containers with `docker-compose -f docker-compose.yml up --build`
6. Verify in Datadog that your container picks up the docker and logs of project
