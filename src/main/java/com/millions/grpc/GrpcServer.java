package com.millions.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Created by millions on 2019/5/1.
 */
public class GrpcServer {
    public static void main(String[] args) {
        try {

            int port = 50051;
            final Server server = ServerBuilder.forPort(port)
                    .addService(new HelloServiceImpl())
                    .build()
                    .start();
            System.out.println("Server started, listening on " + port);
            server.awaitTermination();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
