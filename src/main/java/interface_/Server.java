package interface_;

import java.io.IOException;

/**
 * @author xy
 * @date 2018/04/08 23:28
 */
public interface Server {

    void start() throws IOException;

    void stop();

    void register(Class serviceInterface, Class Impl);

    boolean isRunning();

    int getPort();
}
