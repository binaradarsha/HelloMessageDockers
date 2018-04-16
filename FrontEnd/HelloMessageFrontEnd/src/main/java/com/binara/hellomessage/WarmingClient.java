package com.binara.hellomessage;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WarmingClient {

    public String getFullReply(String helloMessage) {
        // Creating the channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress(Network.WARMING_SERVER_HOST, Network.WARMING_SERVER_PORT)
                .usePlaintext(true)
                .build();

        // Retrieving the service stub
        WarmingGrpc.WarmingBlockingStub blockingStub = WarmingGrpc.newBlockingStub(channel);

        // Creating the request
        WelcomeRequest request = WelcomeRequest.newBuilder().setHelloMessage(helloMessage).build();

        // Invoking the service method with passing the request object
        WelcomeResponse response = blockingStub.welcome(request);

        return response.getFullReply();
    }

}
