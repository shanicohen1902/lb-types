package root.usecase1;

import root.LoadBalancer;
import root.Server;
import root.Task;

public class RoundRobinLoadBalancer extends LoadBalancer {

    int currentServerIndex = 0;

    public RoundRobinLoadBalancer(Server[] servers) {
        this.servers = servers;
    }

    public void handleRequest(Task task) {
        System.out.println("routing task " + task.getName() + " to " +  servers[currentServerIndex].getName());
        servers[currentServerIndex].handleTask(task);
        currentServerIndex = (currentServerIndex + 1) % servers.length;
    }

}
