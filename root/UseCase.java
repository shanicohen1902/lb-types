package root;

import root.usecase1.RoundRobinLoadBalancer;

import java.util.concurrent.ExecutionException;


public class UseCase
{

    protected static void sendTasks(Server[] servers, Task[] tasks, LoadBalancer loadBalancer, String usecase)
            throws InterruptedException, ExecutionException {

        long startTime = System.currentTimeMillis();

        for(Task task : tasks){
            loadBalancer.handleRequest(task);
        };

        waitForTermination(servers);

        System.out.println("finish " + usecase + ", took " + (System.currentTimeMillis() - startTime) + " ms");

    }

    protected static Task[] initDefaultTasks(int length) {
        Task[] tasks = new Task[length];
        for(int i = 0; i < length; i++)
        {
            tasks[i] = new Task("Task_" + i, Task.TaskType.EAGER);
        }
        return tasks;
    }

    protected static Server[] initDefaultServers() {
        Server server1 = new Server("fastServer", Server.ServerType.EAGER);
        Server server2 = new Server("fastServer", Server.ServerType.EAGER);
        Server server3 = new Server("fastServer", Server.ServerType.EAGER);
        Server[] servers = new Server[] { server1, server2, server3 };
        return servers;
    }

    private static void waitForTermination(Server[] servers) throws InterruptedException, ExecutionException {
        
        for(Server server : servers)
        {
             server.submit(() -> {
                server.shutdown();
            })
            .get();
        }
    }
}

