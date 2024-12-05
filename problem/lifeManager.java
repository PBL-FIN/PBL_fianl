package problem;

public class lifeManager {
    private static int lifeCnt = 3;

    public void discount() {
        lifeCnt -= 1;
    }
    public int getLifeCnt() {
        return lifeCnt;
    }
}
