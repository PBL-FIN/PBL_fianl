package problem;
public class Problem {
    private String problem;
    private int answer;

    public Problem(String problem, int answer) {
        this.problem = problem;
        this.answer = answer;
    }
    
    public String getProblem() {
        return problem;
    }

    public int getAnswer() {
        return answer;
    }    
}

