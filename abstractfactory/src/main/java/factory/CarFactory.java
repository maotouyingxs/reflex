package factory;

/**
 * 包装厂
 */
public interface CarFactory {
    /**
     * 创建发动机
     *
     * @return 发动机
     */
    Engine createEngine();

    /**
     * 创建座椅
     *
     * @return 座椅
     */
    Chair createChair();
}
