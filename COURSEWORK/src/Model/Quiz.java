package Model;

public class Quiz {

    int quizID;
    String difficultyLevel;

    public Quiz(int quizID, String difficultyLevel) {
        this.quizID = quizID;
        this.difficultyLevel = difficultyLevel;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
