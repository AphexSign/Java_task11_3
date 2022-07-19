package UserExample3;

public class Main {
//
    public static void main(String[] args) {
        UserClassThread userClassThread1=new UserClassThread("Вася");
        UserClassThread userClassThread2=new UserClassThread("Саша");
        userClassThread1.start();
        userClassThread2.start();

    }
}
