package problem;

public class PageLoadingManager {
    private static int LoadingCnt = 0;

    public void addCnt() {
        LoadingCnt += 1;
    }

    public int getLoadingCnt() {
        return LoadingCnt;
    }

    public void resetLoadingCnt() {
        LoadingCnt = 0;
    }
}
