package grpc.ca.ChatSupport;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;
import javax.swing.JOptionPane;

import grpc.ca.ChatSupport.chatSupportGrpc.chatSupportStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class ChatSupportClient {

	private static chatSupportStub asyncStub;

	public static void main(String[] args) throws Exception {

		String host = "localhost";

		ServiceInfo serviceInfo = JmDNSDiscovery.run("_ChatSupport._tcp.local.");

		ManagedChannel channel1 = ManagedChannelBuilder.forAddress(host, serviceInfo.getPort()).usePlaintext().build();

		asyncStub = chatSupportGrpc.newStub(channel1);

		try {
			System.out.println("--Bidirectional streaming--");
			getChatSupport();

		} catch (StatusRuntimeException ex) {
			ex.printStackTrace();
		} finally {
			channel1.shutdown().awaitTermination(60, TimeUnit.SECONDS);
		}

	}

	// bidirectional streaming
	public static void getChatSupport() {

		StreamObserver<HelloReply4> responseObserver = new StreamObserver<HelloReply4>() {

			@Override
			public void onNext(HelloReply4 msg) {
				System.out.println("Passing messages: " + msg.getMessage4());

			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println("Stream is completed, inside client");
			}

		};

		StreamObserver<HelloRequest4> requestObserver = asyncStub.getChatSupport(responseObserver);

		try {

			String answerYesNo = JOptionPane.showInputDialog("?", null);

			while (answerYesNo.equalsIgnoreCase("Yes")) {

				String firstMessage = JOptionPane.showInputDialog("first message", null);
				requestObserver.onNext(HelloRequest4.newBuilder().setName4(firstMessage).build());
				Thread.sleep(1000);
				answerYesNo = JOptionPane.showInputDialog("Would you like to chat?", null);

			}

			Thread.sleep(2000);
			// Mark the end of requests
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
