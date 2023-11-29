public class Semaphore {
  protected int value = 0;

  protected Semaphore() {
    value = 0;
  }

  protected Semaphore(int initial) {
    value = initial;
  }
// synchronized keyword ensures that only one thread can execute this method at a time
  public synchronized void P(Device device) { // wait() decrement the semaphore value. if negative, suspend the process
    value--;
    if (value < 0) {
      try {
        System.out.println("(" + device.getName() + ") (" + device.getType() + ")" + " arrived and waiting");
        wait();
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    } else{
        System.out.println( device.getName() +" (" + device.getType() + ")" +" arrived");
    }
  }

  public synchronized void V() { // signal() increment the semaphore value, allow the first
//        process in the waiting queue to continue.
    value++;
    if (value <= 0) notify(); //  to wake up one of the waiting threads
  }
}
