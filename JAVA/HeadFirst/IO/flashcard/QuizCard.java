public class QuizCard
{
    private String quiz;
    private String ans;

    public QuizCard(String q, String a){
        quiz = q;
        ans = a;
    }
    public String getQuiz(){
        return quiz;
    }
    public String getAns(){
        return ans;
    }
}
