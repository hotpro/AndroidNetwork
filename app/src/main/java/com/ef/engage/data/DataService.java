package com.ef.engage.data;

import com.ef.engage.data.model.Course;
import com.ef.engage.data.model.SessionInfo;
import com.ef.engage.data.model.StudyContext;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/18/14
 */
public interface DataService {

    public void login(String userName, String password, DataRequestHandler<SessionInfo> dataRequestHandler);

    public void getStudyContext(String token, String culturecode, String sessionId, DataRequestHandler<StudyContext> dataRequestHandler);

    public void getCourse(String id, DataRequestHandler<Course> dataRequestHandler);

    public void getCourseList();

    public void submitProgress();
}
