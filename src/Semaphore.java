public class Semaphore {
    protected int value = 0 ;
    protected Semaphore() { value = 0 ; }
    protected Semaphore(int initial) { value = initial ; }
    public synchronized void P(Device device) {
        value--;
        if (value < 0)
            try {
                System.out.println("(" + device.getName()+ ") (" + device.getType()+ ")" + "arrived and waiting");
                wait();
            } catch( InterruptedException e) {
                System.out.println(e);
            }
    }
    public synchronized void V() {
        value++; if (value <= 0) notify() ;
    }
}
