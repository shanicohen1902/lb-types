package root.usecase2;

import root.LoadBalancer;
import root.Server;
import root.Task;

import java.util.*;

public class UseCase2LoadBalancer extends LoadBalancer {


    public UseCase2LoadBalancer(Server[] servers) {
        this.servers = servers;
    }

    public void handleRequest(Task task) {
        // todo
    }

}