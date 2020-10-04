package esp32;

import javax.bluetooth.*;


public class SendData {

	private static Object lock = new Object();
	public static void SendDataToESP() {
		try {
	
			LocalDevice localDevice = LocalDevice.getLocalDevice();
	
			DiscoveryAgent agent = localDevice.getDiscoveryAgent();
	
			agent.startInquiry(DiscoveryAgent.GIAC, new MyDiscoveryListener());
	
			try {
				synchronized(lock) {
					lock.wait();
				}
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Device Inquiry Completed. ");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
