package CSCI5308.GroupFormationTool.SurveyManagerTest;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.IOptions;
import CSCI5308.GroupFormationTool.QuestionManager.IQuestion;
import CSCI5308.GroupFormationTool.QuestionManager.Question;
import CSCI5308.GroupFormationTool.QuestionManager.QuestionAbstractFactory;
import CSCI5308.GroupFormationTool.SurveyManager.IResponse;
import CSCI5308.GroupFormationTool.SurveyManager.ISurvey;
import CSCI5308.GroupFormationTool.SurveyManager.ISurveyPersistence;
import CSCI5308.GroupFormationTool.SurveyManager.SurveyAbstractFactory;

public class SurveyDBMock implements ISurveyPersistence {

	private SurveyAbstractFactory surveyFactory = SurveyAbstractFactory.getFactory();
	private QuestionAbstractFactory questionFactory = QuestionAbstractFactory.getFactory();

	public ISurvey loadSurveyByCourseID(long courseID) {
		ISurvey survey = surveyFactory.makeSurvey();
		List<IQuestion> questions = new ArrayList<IQuestion>();
		IQuestion question = questionFactory.makeQuestion();

		question.setId(1);
		question.setTitle("Programming Expertise");
		question.setText("Rate your programming skills");
		question.setOptions(loadOptionsByQuestionID(1));
		questions.add((Question) question);

		survey.setId(1);
		survey.setUserID(1);
		survey.setQuestions(questions);
		survey.setActive(1);
		return survey;
	}

	public IOptions loadOptionsByQuestionID(long questionID) {
		IOptions options = questionFactory.makeOptions();
		options.setDefault();
		return options;
	}

	public void saveSurveyResponse(IResponse response) {
		if (response.getId() > -1 && response.getQuestionID() > -1 && response.getResponse() != ""
				&& response.getUserID() > -1) {
			IResponse responseTest = surveyFactory.makeResponse();
			responseTest.setId(response.getId());
		}
	}

	public boolean deleteSurveyQuestion(long questionID, long courseID) {
		IQuestion question = questionFactory.makeQuestion();
		question.setId(questionID);
		ISurvey survey = surveyFactory.makeSurvey();
		survey.setId(courseID);
		if (question.getId() > -1 && survey.getId() > -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addSurveyQuestion(long questionID, long courseID, long instructorID) {
		ISurvey survey = surveyFactory.makeSurvey();
		survey.setId(courseID);
		survey.setUserID(instructorID);
		List<IQuestion> questionList = new ArrayList<IQuestion>();
		IQuestion question = questionFactory.makeQuestion();
		question.setId(questionID);
		questionList.add((Question) question);
		survey.setQuestions(questionList);
		if (survey.getId() > -1 && survey.getUserID() > -1 && survey.getQuestions() != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean publishSurvey(long courseID) throws Exception {
		ISurvey survey = surveyFactory.makeSurvey();
		survey.setId(courseID);
		survey.setActive(1);
		if(survey.getActive()==1){
			return true;
		}
		return false;
	}
}
