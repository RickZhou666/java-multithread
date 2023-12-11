package thread.creation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Rick
 * @Date: 2023/12/11 11:48
 */
public class MultiExecutor {

    private final List<Runnable> tasks;
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void executeAll(){
        List<Thread> threads = new ArrayList<>(tasks.size());

        for (Runnable task : tasks){
            Thread thread  = new Thread(task);
            threads.add(thread);
        }

        for (Thread thread : threads){
            thread.start();
        }

    }
}
