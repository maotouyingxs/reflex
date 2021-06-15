package factory;

/**
 * 座椅
 */
public interface Chair {
    void run();
}

class ChairA implements Chair {
    @Override
    public void run() {
        System.out.println("自动加热...");
    }
}
class ChairB implements Chair {
    @Override
    public void run() {
        System.out.println("不能加热...");
    }
}