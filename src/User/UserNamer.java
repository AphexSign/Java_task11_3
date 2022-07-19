package User;

public class UserNamer {
    public static String currentName;
    public String myname;
    private static final Object monitor = new Object();
    public static String tmpName;
//
    public UserNamer(String myname) {
        this.myname = myname;

        if (currentName == null) {
            currentName = this.myname;
        } else {
            tmpName = this.myname;
        }

    }

    public void printMyName() {
        synchronized (monitor) {
            try {
                while (true) {
                    while (!currentName.equals(this.myname)) {
                        monitor.wait();
                    }
                    System.out.println(this.myname);
                    Thread.sleep(300);
                    currentName = tmpName;
                    tmpName = this.myname;
                    monitor.notify();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
