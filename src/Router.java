import java.util.ArrayList;

public class Router {

    private Integer nConnections = 0;
    private ArrayList<Device> devices = new ArrayList<Device>();
    private Semaphore spaces = new Semaphore(nConnections);
    private Semaphore connections = new Semaphore(0);

    Router(int nConnections){
        this.nConnections = nConnections;
    }

//    boolean addDevice(Device newDevice){
//        if (nConnections.equals(devices.size())){
//            System.out.println("Sorry, maximum number of devices reached");
//            return false;
//        }
//        return devices.add(newDevice);
//    }

    public void occupyConnection(Device device){
        spaces.P();
        System.out.println(device.getName() + " Occupied");
        device.connect();
        device.performOnlineActivity();
        connections.V();
    }
    public void releaseConnection(Device device){
        connections.P();
        device.disconnect();
        spaces.V();
    }
}
