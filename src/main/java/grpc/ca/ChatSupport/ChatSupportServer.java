package grpc.ca.ChatSupport;

import java.io.IOException;

import grpc.ca.ChatSupport.chatSupportGrpc.chatSupportImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ChatSupportServer extends chatSupportImplBase {

	public static void main(String[] args) throws InterruptedException, IOException {

		int port = 50053;
		ChatSupportServer server1 = new ChatSupportServer();

		JmDNSRegistration reg = new JmDNSRegistration();
		
		System.out.println("Starting gRPC Chat Support Server");
		reg.run("_ChatSupport._tcp.local.", "Chat Support", 50053, "Running Chat Support");

		
		
		try {
			Server server = ServerBuilder.forPort(port).addService(server1).build().start();

			System.out.println("Server running on port: " + port);

			server.awaitTermination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public StreamObserver<HelloRequest4> getChatSupport(StreamObserver<HelloReply4> responseObserver) {

		System.out.println("Inside streaming implementation");
		return new StreamObserver<HelloRequest4>() {

			@Override
			public void onNext(HelloRequest4 msg) {
				System.out.println("Receiving messages " + msg.getName4());

				String converted = msg.getName4();

				HelloReply4 reply = HelloReply4.newBuilder().setMessage4(converted).setMessage4(msg.getName4()).build();

				responseObserver.onNext(reply);

			}

			@Override
			public void onError(Throwable t) {

				t.printStackTrace();

			}

			// Client has indicated to server that it has finished streaming
			@Override
			public void onCompleted() {
				System.out.println("Stream is completed, inside server");

				// completed too
				responseObserver.onCompleted();
			}

		};
	}

}