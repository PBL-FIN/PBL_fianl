package problem;

public class scoreManager {
    private static int score = 0;

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0; // 점수 리셋
    }
}
