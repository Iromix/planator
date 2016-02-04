package planat0r;

import java.util.List;


import database.IActivity;
import database.ITag;

/*! Question class  
 * @author ima3k
 * @version NaN
 * @since never
 * */
public class Question implements IQuestion{
	IActivity activity1;/**<left question instance*/
	IActivity activity2;/**<right question instance*/
	boolean status;/**<which was pushed*/
	
	//! A constructor.
    /*!
     * save activities as questions activity1 left activity2 right
    */
	Question(IActivity activity1,IActivity activity2){
		this.activity1 = activity1;
		this.activity2 = activity2;
	}
	
	/**
     * check that user picked activity1\
     * @return true if is pushed false otherwise
    */
	public void leftPushed(){
		status = true;
	}
	/**
     * check that user picked activity2\
     * @return true if is pushed false otherwise
    */
	public void rightPushed(){
		status = false;
	}
	
	/**
     * check that user picked activity1
     * @param activities list of activities picked by user
     * @return List<ITag> picked tags by user
    */
	public List<ITag> getPushedTags(){
		if(status){
			return activity1.getTagList();
		}
		else{
			return activity2.getTagList();
		}
	}
	
	/**
     * get text of activity1
     * @return activity1 text
    */
	@Override
	public String getLeftText() {
		return activity1.getName();
	}
	
	/**
     * get text of activity2
     * @return activity2 text
    */
	@Override
	public String getRightText() {
		return activity2.getName();
	}
}
