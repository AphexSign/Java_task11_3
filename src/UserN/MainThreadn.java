package UserN;

import User.UserNamer;
//
import java.util.*;

public class MainThreadn {

    public static void main(String[] args) {
        //Сказка "Репка" - 8 персонажей(c разделителем)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько персонажей будет? - ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Итак...");

        UsernNamer[] usernNamers = new UsernNamer[n];
        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Имя персонажа N" + (i + 1));
            usernNamers[i] = new UsernNamer(scanner.nextLine());
            UsernNamer tmpUserNamer = usernNamers[i];
            threads[i] = new Thread(tmpUserNamer::printMyName);
        }

        Arrays.stream(threads).forEach(Thread::start);


    }

}
