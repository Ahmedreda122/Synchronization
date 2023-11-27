import java.util.ArrayList;

public class Router {

    private Integer nConnections = 0;

    private Semaphore spaces = new Semaphore(nConnections);
    private Semaphore connections = new Semaphore(0);

    Router(int nConnections){
        this.nConnections = nConnections;
    }


    public void occupyConnection(Device device){
        spaces.P(device);
        System.out.println("Connection " + connections.value + " " + device.getName() + " Occupied");
        device.connect();
        device.performOnlineActivity();
        connections.V();
    }
    public void releaseConnection(Device device){
        connections.P(device);
        device.disconnect();
        spaces.V();
    }
}
