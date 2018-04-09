package server;

import interface_.helloService;

/**
 * @author xy
 * @date 2018/04/09 22:00
 */
public class HelloServiceImpl implements helloService {

    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
