package root;

import java.util.concurrent.FutureTask;

public class Task extends FutureTask<String> {

    public enum TaskType {

        LAZY(3),
        NORMAL(2),
        EAGER(1);
    
        public final int seconds;
    
        private TaskType(int seconds) {
            this.seconds = seconds;
        }
    } 

    private String name;
    private TaskType type;

    public Task(String name, TaskType type) {
        super(() -> {
            try {
                Thread.sleep(type.seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return name;
        });
        this.name = name;
        this.type = type;
    }

    public Task(String name) {
        super(() -> {
            try {
                Thread.sleep(TaskType.NORMAL.seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return name;
        });
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TaskType getType() {
        return type;
    }

    public int getProcessTime() {
        return type.seconds;
    }

    @Override
    public void run() {
       try {
        Thread.sleep(type.seconds * 1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    }

    public void execute() throws InterruptedException {
        Thread.sleep(type.seconds * 1000);
    }

}
