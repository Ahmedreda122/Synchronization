public class Device implements Runnable{

    private String name;
    private String type;

    Device(String name, String type){
        this.name = name;
        this.type = type;
    }
    @Override
    public void run() {
        connect();
        performOnlineActivity();
        disconnect();
    }

    public void connect(){
        System.out.println(this.name + " logged in");
    }

    public void performOnlineActivity(){
        System.out.println(this.name + " performs online activity");
    }

    public void disconnect(){
        System.out.println(this.name + " logged out");
    }

    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }

}
