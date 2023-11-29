import java.util.ArrayList;
import java.util.Scanner;

public class Network {
  
  public static void main(String[] args) {
    ArrayList<Device> devices = new ArrayList<Device>();
    int maxNumConnections;
    int maxNumDevices;
      Scanner input = new Scanner(System.in);
      System.out.println("What is the number of WI-FI Connections?");
      maxNumConnections = input.nextInt();
      System.out.println("What is the number of devices Clients want to connect?");
      maxNumDevices = input.nextInt();
    Router router = new Router(maxNumConnections);
    Thread thread = new Thread(devices.get(i));
    for (int i = 0; i < maxNumDevices; i++) {
        String name = input.next();
        String type = input.next();
        devices.add(new Device(name, type, router));
      }
    thread.start();

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
