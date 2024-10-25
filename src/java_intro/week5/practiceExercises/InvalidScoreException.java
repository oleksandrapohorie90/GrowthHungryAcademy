package java_intro.week5.practiceExercises;

public class InvalidScoreException extends Exception{
    public InvalidScoreException(String message){
        super(message);
//        Custom Exception:
//        If the score is out of the range 0-100.
    }
}
