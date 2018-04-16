This repository contains 2 sub projects for creating Docker containers.

(1) Grpc front-end service
(2) Grpc back-end service

Commands to build Docker images:

docker build -t binaradarsha/hellobackend:1.0 BackEnd/  
docker build -t binaradarsha/hellofrontend:1.0 FrontEnd/

Commands to create Docker containers:

docker run -d --name hellobackend1.0 binaradarsha/hellobackend:1.0  
docker run -d --name hellofrontend --link hellobackend1.0:hellobackend binaradarsha/hellobackend:1.0

Check /etc/hosts file in hellofrontend container. It will contain a host entry called "hellobackend" mapped to ip address of hellobackend1.0 container.

docker exec -it hellofrontend1.0 bash  
cat /etc/hosts 