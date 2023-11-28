import java.util.ArrayList;
import java.util.Scanner;

public class Network {
  int maxNumConnections;
  int maxNumDevices;
  private ArrayList<Device> devices = new ArrayList<Device>();

  public void run() {
    Scanner input = new Scanner(System.in);
    System.out.println("What is the number of WI-FI Connections?");
    maxNumConnections = input.nextInt();
    System.out.println("What is the number of devices Clients want to connect?");
    maxNumDevices = input.nextInt();
    for (int i = 0; i < maxNumDevices; i++) {
      String name = input.next();
      String type = input.next();
      devices.add(new Device(name, type));
    }
    Router router = new Router(maxNumConnections);

    for (int i = 0; i < maxNumDevices; i++){
      devices.get(i).run();
    }
  }
  //    boolean addDevice(Device newDevice){
//        if (nConnections.equals(devices.size())){
//            System.out.println("Sorry, maximum number of devices reached");
//            return false;
//        }
//        return devices.add(newDevice);
//    }
}
