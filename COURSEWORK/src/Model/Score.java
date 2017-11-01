package Model;

public class Score {

    int scoreID;
    int score;
    int userID;
    int quizID;

    public int getScoreID() {
        return scoreID;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public Score(int scoreID, int score, int userID, int quizID) {
        this.scoreID = scoreID;
        this.score = score;
        this.userID = userID;
        this.quizID = quizID;

    }
}
