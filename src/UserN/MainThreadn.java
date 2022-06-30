package UserN;

import User.UserNamer;

public class MainThreadn {

    public static void main(String[] args) {

        UsernNamer usernNamer1 = new UsernNamer("Вася1");
        UsernNamer usernNamer2 = new UsernNamer("Саша2");
        UsernNamer usernNamer3 = new UsernNamer("Гена3");
        UsernNamer usernNamer4 = new UsernNamer("Нико4");
        UsernNamer usernNamer5 = new UsernNamer("Алекс5");



        Thread thread1 = new Thread(() -> usernNamer1.printMyName());
        Thread thread2 = new Thread(() -> usernNamer2.printMyName());
        Thread thread3 = new Thread(() -> usernNamer3.printMyName());
        Thread thread4 = new Thread(() -> usernNamer4.printMyName());
        Thread thread5 = new Thread(() -> usernNamer5.printMyName());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }


}
