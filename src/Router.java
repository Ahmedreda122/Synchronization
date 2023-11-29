import java.util.ArrayList;

public class Router {

  private Integer nConnections = 0; // max device connections

  private Semaphore spaces;
  //    private Semaphore connections = new Semaphore(0);
  ArrayList<Boolean> ifConnected = new ArrayList<>(nConnections);

  Router(int nConnections) {
    this.nConnections = nConnections;
    spaces = new Semaphore(nConnections);

    for (int i = 0; i < nConnections; i++) {
      ifConnected.add(false);
    }
  }
  private Boolean checkIfNoConn(){
    boolean f = false;
    for(int i = 0; i < ifConnected.size();i++){
      if(ifConnected.get(i)){f = true;break;}
    }
    return f;
  }

  // 4
  // 1 2 3 4
  // 0 0 0 0
  public int occupyConnection(Device device)  {

    if(checkIfNoConn()){
      System.out.println("No Available Connections");
    }
    spaces.P(device); // waite(device)
    int setDeviceID = 0;
    for (int i = 0; i < nConnections; i++) {
      if (!ifConnected.get(i)) {
        setDeviceID = i;
        ifConnected.set(i, true);
//              (nConnections-spaces.value)
        System.out.println("Connection " + i + ": " + device.getName() + " Occupied");
        break;
      }
    }
//      device.connect();
//      device.performOnlineActivity();
//        connections.V();
    return setDeviceID;
  }

  private void throwIoException(String string) {
  }
  public void releaseConnection(Device device) {
    ifConnected.set(device.getDeviceID(), false); // wait(device)
    spaces.V();
  }
}
