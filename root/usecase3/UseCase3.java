package root.usecase3;

import root.LoadBalancer;
import root.Server;
import root.Task;
import root.UseCase;

import java.util.concurrent.ExecutionException;


public class UseCase3 extends UseCase
{

    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        Server[] servers = initDefaultServers();

        Task[] tasks = initDifferentTasks(15);

        LoadBalancer loadBalancer = new UseCase3LoadBalancer(servers);

        sendTasks(servers, tasks, loadBalancer, "usecase3");
    }


    private static Task[] initDifferentTasks(int length) {
        Task[] tasks = new Task[length];
        int typesCount = Server.ServerType.values().length;

        for(int i = 0; i < length; i = i + typesCount) {
            tasks[i] = new Task("task_" + i, Task.TaskType.LAZY);
        }

        for(int i = 1; i < length; i = i + typesCount) {
            tasks[i] = new Task("Task_" + i, Task.TaskType.NORMAL);
        }

        for(int i = 2; i < length; i = i + typesCount) {
            tasks[i] = new Task("Task_" + i, Task.TaskType.EAGER);
        }
        
        return tasks;
    }

}

