package Model;

public class Questions {

    int questionID;
    String question;
    String answer;
    int quizID;

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public Questions(int questionID, String question, String answer, int quizID) {
        this.questionID = questionID;
        this.question = question;
        this.answer = answer;
        this.quizID = quizID;

    }

}

