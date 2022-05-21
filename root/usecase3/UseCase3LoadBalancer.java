package root.usecase3;

import root.LoadBalancer;
import root.Server;
import root.Task;

public class UseCase3LoadBalancer extends LoadBalancer {

    public UseCase3LoadBalancer(Server[] servers) {
        this.servers = servers;
    }

    public void handleRequest(Task task) {
        // todo
    }

}