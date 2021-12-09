package grpc.ca.ChatSupport;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class JmDNSDiscovery {

	public static ServiceInfo run(String serviceType) throws InterruptedException {

		ServiceInfo serviceInfo = null;
		try {
			MyServiceListener listener = new MyServiceListener();
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener(serviceType, listener);

			Thread.sleep(10000);

			serviceInfo = listener.getServiceInfo();

			System.out.println("Client started");

		} catch (IOException e) {

			e.printStackTrace();
		}

		return serviceInfo;
	}

	public static class MyServiceListener implements ServiceListener {

		int port;
		ServiceInfo serviceInfo;

		public void serviceAdded(ServiceEvent event) {

			ServiceInfo serviceInfo = event.getInfo();
			this.port = serviceInfo.getPort();
			this.serviceInfo = serviceInfo;

			System.out.println("Running on port: " + serviceInfo.getPort());
			System.out.println("Service added: " + event.getInfo());
		}

		public void serviceRemoved(ServiceEvent event) {

			System.out.println("Service removed: " + event.getInfo());
		}

		public void serviceResolved(ServiceEvent event) {

			ServiceInfo serviceInfo = event.getInfo();
			this.port = serviceInfo.getPort();
			this.serviceInfo = serviceInfo;

			System.out.println("Running on port: " + serviceInfo.getPort());
			System.out.println("Service resolved: " + event.getInfo());
		}

		public int getPort() {
			return port;
		}

		public ServiceInfo getServiceInfo() {
			return serviceInfo;
		}

	}

}
