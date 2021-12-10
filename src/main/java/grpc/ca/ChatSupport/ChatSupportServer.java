/*
 * Luke T
 * ChatSupportServer.java
 * 07/12/21 
 */

package grpc.ca.ChatSupport;

import java.io.IOException;

import javax.swing.JOptionPane;

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
		reg.run("_ChatSupport._tcp.local.", "Chat Support", port, "Chat Support");

		try {
			Server server = ServerBuilder.forPort(port).addService(server1).build().start();

			System.out.println("Server running on port: " + port);

			server.awaitTermination();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	//bidirectional streaming
	@Override
	public StreamObserver<HelloRequest4> getChatSupport(StreamObserver<HelloReply4> responseObserver) {

		System.out.println("Inside streaming implementation");
		return new StreamObserver<HelloRequest4>() {

			@Override
			public void onNext(HelloRequest4 msg) {
				System.out.println("Receiving messages: " + msg.getName4());

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
				
				JOptionPane.showMessageDialog(null, "Thank you for your queries, we will be back to you shortly.");
				
				System.out.println("Stream is completed, inside server");

				// completed too
				responseObserver.onCompleted();
			}

		};
	}

}