FROM dockerregistry.pagero.local/ubuntu-java8

WORKDIR /opt

COPY HelloMessageBackEnd/target/HelloMessageBackEnd-1.0-SNAPSHOT-jar-with-dependencies.jar HelloMessageBackEnd.jar

RUN sudo chmod +x HelloMessageBackEnd.jar 

EXPOSE 50000

ENTRYPOINT ["java", "-jar", "/opt/HelloMessageBackEnd.jar"]
