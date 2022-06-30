package User;

public class MainThread {

    public static void main(String[] args) {

        UserNamer userNamer1 = new UserNamer("Вася");
        UserNamer userNamer2 = new UserNamer("Саша");



        Thread thread1 = new Thread(() -> userNamer1.printMyName());
        Thread thread2 = new Thread(() -> userNamer2.printMyName());


        thread1.start();
        thread2.start();


    }


}
