package UserN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsernNamer {
    public static String currentName;
    public static ArrayList<String> currentNameList = new ArrayList<>();     //Создаем очередь из имен
    public static int posList = 0;
    public String myname;
    private static final Object monitor = new Object();


    public UsernNamer(String myname) {
        this.myname = myname;
        currentNameList.add(this.myname);
        if (currentName == null) {                        // Однократно инициализируем имя в очереди первым элементом
            currentName = currentNameList.get(0);
        }
        if (currentNameList.size() == 2) {                // При наличии хотя бы двух элементов в списке, сдвигаем позицию
            shiftPos();                                   // Чтобы не было повтора первого элемента
        }
    }
    // Сдвиг позиции
    public void shiftPos() {
        if (posList == (currentNameList.size() - 1)) {
            posList = 0;
        } else {
            posList++;
        }
    }
//
    public void printMyName() {
        synchronized (monitor) {              //Синхронизация по неизменяемому обьекту, потоки будут видеть, кто сейчас работает и не будут лезть, до Notify
            try {
                while (true) {
                    while (!currentName.equalsIgnoreCase(this.myname)) {                    //Конкретный поток не работает, если очередь не его
                        monitor.wait();
                    }
                    System.out.println(this.myname);
                    Thread.sleep(300);
                    currentName = currentNameList.get(posList);     //Меняем текущее имя, сдвигая его по позиции в списке
                    shiftPos();
                    monitor.notifyAll();   //Пробуждает все потоки, чтобы они лезли
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
