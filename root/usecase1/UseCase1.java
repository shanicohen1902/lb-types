package root.usecase1;

import java.util.concurrent.ExecutionException;

import root.LoadBalancer;
import root.Server;
import root.Task;
import root.UseCase;


public class UseCase1 extends UseCase
{

    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        Server[] servers = UseCase.initDefaultServers();

        Task[] tasks = UseCase.initDefaultTasks(15);

        LoadBalancer loadBalancer = new RoundRobinLoadBalancer(servers);

        UseCase.sendTasks(servers, tasks, loadBalancer, "usecase1");
    }

}

