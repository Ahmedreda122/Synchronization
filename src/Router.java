import java.util.ArrayList;

public class Router {

    private Integer nConnections = 0; // max connections

    private Semaphore spaces = new Semaphore(nConnections);
//    private Semaphore connections = new Semaphore(0);
    ArrayList<Boolean> ifConnected = new ArrayList<>(nConnections);

    Router(int nConnections){
        this.nConnections = nConnections;
    }


    public void occupyConnection(Device device){
        spaces.P(device); // waite(device)
        System.out.println("Connection " + (nConnections-spaces.value) + " " + device.getName() + " Occupied");
        device.connect();
        device.performOnlineActivity();
        connections.V();
    }
    public void releaseConnection(Device device){
        connections.P(device); // waite(device)
        device.disconnect();
        spaces.V();
    }
}
