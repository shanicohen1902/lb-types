package root;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server extends ThreadPoolExecutor{

    public enum ServerType {

        LAZY(3),
        NORMAL(2),
        EAGER(1);
    
        public final int overHead;
    
        private ServerType(int overHead) {
            this.overHead = overHead;
        }
    } 

    String name;
    ServerType type;
    List<Future<Task>> futureList = new ArrayList<>();

    public Server(String string, ServerType type) {
        super(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>() );  
        this.name = string;
        this.type = type; 
    }

    public ServerType getType(){ return type;}
    public String getName() {
        return name;
    }

    public void handleTask(Task task){
        Future<Task> future = this.submit(() -> {
            Thread.sleep(task.getProcessTime() * type.overHead * 1000);
            System.out.println("finish process " + task.getName());
            return task;
        });
        futureList.add(future);
    }
        
    public void shutdown(){  

        futureList.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        super.shutdown();
    }

        
}  


