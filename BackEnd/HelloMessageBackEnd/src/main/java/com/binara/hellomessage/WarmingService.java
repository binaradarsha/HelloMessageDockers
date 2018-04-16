package com.binara.hellomessage;

import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class WarmingService extends WarmingGrpc.WarmingImplBase {

    private static final Logger logger = Logger.getLogger(WarmingService.class.getName());

    @Override
    public void welcome(WelcomeRequest request, StreamObserver<WelcomeResponse> responseObserver) {
        // Retrieve input
        String helloMessage = request.getHelloMessage();
        logger.info("Got request: " + helloMessage);

        // Prepare output
        String fullReply = helloMessage + "\nWelcome to Kubernetes world.";
        WelcomeResponse response = WelcomeResponse.newBuilder().setFullReply(fullReply).build();

        // Send response via StreamObserver
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
