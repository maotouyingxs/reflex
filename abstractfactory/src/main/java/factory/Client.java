package factory;

public class Client {
    public static void main(String[] args) {
        CarFactory jiLiFactory = new JiLiFactory();
        Engine engineA = jiLiFactory.createEngine();
        Chair chairA = jiLiFactory.createChair();
        engineA.run();
        engineA.start();
        chairA.run();
    }
}
