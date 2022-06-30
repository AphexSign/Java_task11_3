package UserN;

import java.util.ArrayList;

public class UsernNamer {
    public static String currentName;
    public static ArrayList<String> currentNameList=new ArrayList<>();     //Создаем очередь из имен
    public static int posList=0;
    public String myname;
    private static final Object monitor=new Object();


    public UsernNamer(String myname){
        this.myname=myname;
        currentNameList.add(this.myname);
    }

    public void shiftPost(){
        if(posList==(currentNameList.size()-1)){
            posList=0;
        }
        else {posList++;}
    }

        public synchronized void printMyName(){
        //Однократно инициализируем имя в очереди первым элементом
        if (currentName==null){
            currentName=currentNameList.get(0);
        }
            //Синхронизация по неизменяемому обьекту, потоки будут видеть, кто сейчас работает и не будут лезть, до Notify
        synchronized (monitor){
            try {
                while (true) {
                    //Конкретный поток не работает, если очередь не его
                    while (currentName != this.myname) {
                        monitor.wait();
                    }
                    System.out.println(this.myname);
                    Thread.sleep(300);
                    //Меняем текущее имя, сдвигая его по позиции в списке
                    currentName = currentNameList.get(posList);
                    shiftPost();
                    //Пробуждает все потоки, чтобы они лезли на строчку кода 33
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }
