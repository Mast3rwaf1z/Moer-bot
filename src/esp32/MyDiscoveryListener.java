package esp32;

import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

public class MyDiscoveryListener implements DiscoveryListener {
	private static Object lock = new Object();
	
	@Override
	public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
		// TODO Auto-generated method stub
		String name;
		try {
			name = btDevice.getFriendlyName(false);
		} 
		catch (Exception e) {
			name = btDevice.getBluetoothAddress();
		}
		System.out.println("device found: " + name);
	}

	@Override
	public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public void serviceSearchCompleted(int transID, int respCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inquiryCompleted(int discType) {
		// TODO Auto-generated method stub
		synchronized(lock) {
			lock.notify();
		}
	}

}
