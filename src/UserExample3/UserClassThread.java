package UserExample3;

//Создаем класс поток, через наследование
//
public class UserClassThread extends Thread {
    private String myName;
    public static final Object monitor = new Object();
    public static String currentName;
    public static String tmpName;

    public UserClassThread(String myname) {
        this.myName = myname;
        if (currentName == null) {
            currentName = this.myName;
        } else {
            tmpName = this.myName;
        }
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        synchronized (monitor) {
            try {
                while (true) {
                    while (!currentName.equals(this.myName)) {
                        monitor.wait();
                    }
                    System.out.println("Мое имя:" + this.myName);
                    Thread.sleep(300);
                    currentName = tmpName;
                    tmpName = this.myName;
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }


}
