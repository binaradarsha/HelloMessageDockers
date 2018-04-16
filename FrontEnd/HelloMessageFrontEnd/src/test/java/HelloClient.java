import com.binara.hellomessage.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class HelloClient {

    public static void main(String[] args) {
        // Creating the channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("172.17.0.2", Network.HELLO_SERVER_PORT)
                .usePlaintext(true)
                .build();

        // Retrieving the service stub
        HelloGrpc.HelloBlockingStub blockingStub = HelloGrpc.newBlockingStub(channel);

        // Obtaining user input for name field
        System.out.print("Enter name : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        // Creating the request
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();

        // Invoking the service method with passing the request object
        HelloResponse response = blockingStub.greet(request);

        System.out.println("\n>>> Response : \n" + response.getReply());
    }

}
