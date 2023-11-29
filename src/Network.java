import java.util.ArrayList;
import java.util.Scanner;

public class Network {
  
  public static void main(String[] args) {
    ArrayList<Thread> devices = new ArrayList<>();
    int maxNumConnections;
    int maxNumDevices;

    Scanner input = new Scanner(System.in);

    System.out.println("What is the number of WI-FI Connections?");
    maxNumConnections = input.nextInt();
    System.out.println("What is the number of devices Clients want to connect?");
    maxNumDevices = input.nextInt();

    Router router = new Router(maxNumConnections);

    for (int i = 0; i < maxNumDevices; i++) {
        String name = input.next();
        String type = input.next();
        devices.add(new Thread(new Device(name, type, router)));
    }

    for (int i = 0; i < maxNumDevices; i++){
        devices.get(i).start();
    }
  }
}
