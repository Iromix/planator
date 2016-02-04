package planat0r;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import database.IActivity;
import database.IDatabase;
import database.ITag;


/*! Questioner class  
 * @author ima3k
 * @version NaN
 * @since never
 * */
public class Questioner {
	IDatabase database;/**<handler for database*/
	public static final int NUMBER_OF_QUESTIONS = 3;/**<number of questions for user*/
	
	Questioner(IDatabase database){
		this.database = database;
	}
	/**
     * generate NUMBER_OF_QUESTIONS questions for user
     * @return list of generated questionSer
    */
	public List<Question> generateQuestionSet(){
		List<Question> questions = new ArrayList<Question>();
		List<IActivity> allActivities = database.getAllActivities();
		
		Random randomGenerator = new Random();
		for(int i=0;i<NUMBER_OF_QUESTIONS;i++){
			int randomElementPosition1 = randomGenerator.nextInt(allActivities.size()-1);
			int randomElementPosition2 = randomGenerator.nextInt(allActivities.size()-1);

			IActivity activity1 = allActivities.get(randomElementPosition1);
			IActivity activity2 = allActivities.get(randomElementPosition2);
			while(randomElementPosition1 == randomElementPosition2){
				activity2 = allActivities.get(randomElementPosition2);
			}
			
			
			allActivities.remove(activity1);
			allActivities.remove(activity2);
			
			Question question = new Question(activity1, activity2);
			questions.add(question);
		}
		return questions;
	}
	
	/**
     * check that user picked activity1\
     * @param answers which user picked
     * @return list of tags generated using answers
    */
	public List<ITag> saveAnswers(List<Question> answers){
		List<ITag> tags = new ArrayList<ITag>();
		for(IQuestion answer : answers){
			tags.addAll(answer.getPushedTags());
		}
		return tags;
	}
}
