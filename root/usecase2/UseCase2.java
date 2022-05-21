package root.usecase2;

import root.LoadBalancer;
import root.Server;
import root.Task;
import root.UseCase;
import root.usecase1.RoundRobinLoadBalancer;

import java.util.concurrent.ExecutionException;


public class UseCase2 extends UseCase
{

    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        Server[] servers = initDifferentServersTypes();

        Task[] tasks = initDefaultTasks(15);

        LoadBalancer loadBalancer = new UseCase2LoadBalancer(servers); //todo in less than 11 sec

        sendTasks(servers, tasks, loadBalancer, "usecase2");
    }

    private static Server[] initDifferentServersTypes() {
        Server server1 = new Server("fastServer", Server.ServerType.EAGER);
        Server server2 = new Server("normalServer", Server.ServerType.NORMAL);
        Server server3 = new Server("lazyServer", Server.ServerType.LAZY);
        Server[] servers = new Server[] { server1, server2, server3 };
        return servers;
    }
}

