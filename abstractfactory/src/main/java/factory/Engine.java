package factory;

/**
 * 发动机
 */
public interface Engine {
    void run();
    void start();
}

class EngineA implements Engine {

    @Override
    public void run() {
        System.out.println("发送机转速快...");
    }

    @Override
    public void start() {

    }
}

class EngineB implements Engine {
    @Override
    public void run() {
        System.out.println("发动机转速慢...");
    }

    @Override
    public void start() {

    }
}