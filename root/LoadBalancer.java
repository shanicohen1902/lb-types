package root;

import root.Server;
import root.Task;

public abstract class LoadBalancer {

    protected Server[] servers;

    public abstract void handleRequest(Task task);

    protected int getLoad(Server server) {
        return server.getQueue().size();
    }

}
