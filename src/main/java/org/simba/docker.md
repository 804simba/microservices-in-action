1. https://medium.com/@farhadmalik/docker-98457961ef81

Docker is a virtualization tool used for containerizing applications. The containers isolate the applications from the environments they run in and help the engineers treat and manage the infrastructure environments as software.

- Version: Type in docker --version to get the installed docker version.
- Ps: Type in docker ps to show the containers.
- Build: Type in docker build. It builds a docker image from a Dockerfile.
  - Container: Type in docker container to manage containers. Within a docker container, we need to specify a sub-command e.g.
  - `docker container attach`: To attach local standard input, output, and error streams to a running container
  - `docker container ps`: Gets container details e.g. container id, image, command, when it was created, status, ports, names and so on.
  - `docker container commit`: To create a new image from a container’s changes. It will save the docker container state and create a new image out of the container.
  - `docker container cp`: To copy files/folders between a container and the local filesystem
  - `docker container create`: To create a new container from a docker image
  - `docker container exec`: To run a command in a running container
  - `docker container export`: To export a container’s filesystem as a tar archive
  - `docker container inspect`: To display detailed information on one or more containers
  - `docker container kill <id>`: To kill one or more running containers
  - `docker container logs <id>`: To fetch the logs of a container
  - `docker container ls <id>`: To list containers
  - `docker container rm <id>`: To remove one or more containers
  - `docker container run <id>`: To run a command in a new container. We can pass in optional parameters such as `-e` to set environment variables, `— name` to set the container name, `— volume` to bind mount a volume, `-w` to set the working directory inside the container, `— expose` to export a range of ports, `-p` to publish and bind container ports to the host and so on.
  - `docker container start <id>`: To start one or more stopped containers
  - `docker container stats <id>`: To display a live stream of container(s) resource usage statistics
  - `docker container stop <id>`: To stop one or more running containers
  - `docker container top <id>`: To display the running processes of a container
- Volume: Type `docker volume` to manage docker volumes. We can type in `docker volume create` to create docker volume, `docker volume inspect` to display delayed information of a volume, `docker volume ls` to view all the volumes and `docker volume rm` to remove a volume.