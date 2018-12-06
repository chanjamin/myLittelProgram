package bean;

public class RealStar implements Star {
    /**
     * 唱歌是要自己真唱的
     */
    @Override
    public void sing() {
        System.out.println("周杰伦在唱歌");
    }
}