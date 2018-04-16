package com.binara.hellomessage;

import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class HelloServer {

    private final static Logger logger = Logger.getLogger(HelloServer.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("HelloServer starting, listening port = " + Network.HELLO_SERVER_PORT);

            ServerBuilder.forPort(Network.HELLO_SERVER_PORT)
                    .addService(new HelloService())
                    .build()
                    .start()
                    .awaitTermination();

//            logger.info("Grpc server started listening on port " + Network.HELLO_SERVER_PORT);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
