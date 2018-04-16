FROM dockerregistry.pagero.local/ubuntu-java8

WORKDIR /opt

COPY HelloMessageFrontEnd/target/HelloMessageFrontEnd-1.0-SNAPSHOT-jar-with-dependencies.jar HelloMessageFrontEnd.jar

RUN sudo chmod +x HelloMessageFrontEnd.jar 

EXPOSE 60000

ENTRYPOINT ["java", "-jar", "/opt/HelloMessageFrontEnd.jar"]
