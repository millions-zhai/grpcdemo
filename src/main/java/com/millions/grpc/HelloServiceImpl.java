package com.millions.grpc;

import com.millions.grpc.gencode.HelloRequest;
import com.millions.grpc.gencode.HelloResponse;
import com.millions.grpc.gencode.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * Created by millions on 2019/5/1.
 */
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
