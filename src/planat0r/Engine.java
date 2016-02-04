package planat0r;

import java.util.ArrayList;
import java.util.List;

import database.ASchedule;
import database.DBManager;
import database.IActivity;
import database.IDatabase;
import database.ITag;
import database.Schedule;

/*! Engine class  
 * @author ima3k
 * @version NaN
 * @since never
 * */
public class Engine implements IEngine{
	public final int NUMBER_OF_ACTIVITIES = 5;
	private Questioner questioner;/**<handler for questioner interaction*/
	
	private IDatabase database;/**<handler for database interaction*/
	
	private List<ITag> smubmitedTags; /**<list of submited tags by user*/
	private ASchedule schedule;/**<schedule generated by user*/
	private String username;/**<name of the current user*/
	
    //! A constructor.
    /*!
      creates instances of database and questioner.
    */
	public Engine(){
		 this.questioner = new Questioner(database);
		 this.database = new DBManager();
	}
    /**
     * get questionset generated by Questioner instance
     * @return list of questions generated
    */
	public List<Question> getQuestions(){
		return questioner.generateQuestionSet();
	}
	/**
     * get questionset generated by Questioner instance
     * @param answers	list of questions filled with status from user
     * @return list of questions generated
    */
	public List<ITag> submitAnswers(List<Question> answers){
		return questioner.saveAnswers(answers);
	}
	/**
     * get  generated by Questioner instance
     * @return list of generated activities
    */
	@Override
	public List<IActivity> generateActivities() {
		List<IActivity> allActivities = database.getAllActivities();
		int[] points = new int[allActivities.size()];
		
		for(int i=0;i<allActivities.size();i++){
			List<ITag> tags = allActivities.get(i).getTagList();
			for(int j=0;j<tags.size();j++){
				for(int k=0;k<smubmitedTags.size();k++){
					if(tags.get(j).getName().equals(smubmitedTags.get(k).getName())){
						points[i]++;
					}
				}
			}
		}
		
		List<IActivity> result = new ArrayList<IActivity>();
		int max_pos=0;
		for(int j=0;j<NUMBER_OF_ACTIVITIES;j++){
			int max=-2;
			for(int i=0;i<allActivities.size();i++){
				if(max<points[i]){
					max = points[i];
					max_pos = i;
				}
			}
			result.add(allActivities.get(max_pos));
			points[max_pos] = -1;
			
		}
		return result;
	}
	/**
     * submit activities 
     * @param activities list of activities picked by user
     * @return list of questions generated
    */
	@Override
	public ASchedule submitActivties(List<IActivity> activities) {
		schedule = new Schedule();
		schedule.setActivityList(activities);
		schedule.setUserName(username);
		database.saveSchedule(schedule);
		return schedule;
	}

	public void setUserName(String userName){
		username = userName;
	}
	
	public String getUserName(){
		return username;
	}

	@Override
	public void submitTags(List<ITag> tags) {
		smubmitedTags = tags;		
	}
	@Override
	public ASchedule getSchedule(String username) {
		return database.getSchedule(username);
	}
}
