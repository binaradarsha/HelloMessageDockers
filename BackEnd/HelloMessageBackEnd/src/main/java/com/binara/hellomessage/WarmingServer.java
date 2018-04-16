package com.binara.hellomessage;

import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class WarmingServer {

    public final static int PORT = 50000;

    private final static Logger logger = Logger.getLogger(WarmingServer.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("WarmingServer starting, listening port = " + PORT);

            ServerBuilder.forPort(PORT)
                    .addService(new WarmingService())
                    .build()
                    .start()
                    .awaitTermination();

//            logger.info("Grpc server started listening on port " + PORT);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
