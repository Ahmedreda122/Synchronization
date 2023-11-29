public class Device implements Runnable{

    private String name;
    private String type;
    Router router;
    private int deviceID;
    Device(String name, String type){
        this.name = name;
        this.type = type;
    }
    @Override
    public void run() {
        connect();
        performOnlineActivity();
//        System.out.println("Connection" 2: "" + this.name + "performs online activity");
        disconnect();
    }

    public void connect(){
        deviceID=router.occupyConnection(this); // set deviceID for (this) device
        System.out.println("Connection "+this.deviceID+": "+this.name + " login");
    }

    public void performOnlineActivity(){
        System.out.println(this.name + " performs online activity");
    }

    public void disconnect(){
        System.out.println("Connection "+this.deviceID+": "+this.name + " logged out");
    }

    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public Integer getDeviceID(){return deviceID;}

}
