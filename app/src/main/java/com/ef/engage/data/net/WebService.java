package com.ef.engage.data.net;


import com.ef.engage.data.model.Course;
import com.ef.engage.data.model.Enrollment;
import com.ef.engage.data.model.SessionInfo;
import com.ef.engage.data.model.StudyContext;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/18/14
 *
 * assemble http request from arguments
 * this handler 403, 500, error code, error description,
 */
public interface WebService {

    public void login(String userName, String password, WebRequestHandler<SessionInfo> webRequestHandler);

    public void getStudyContext(String token, String culturecode, String sessionId, WebRequestHandler<StudyContext> webRequestHandler);

    public void getCourse(String id, WebRequestHandler<Course> webRequestHandler);

    public void getEnrolledCourses(String token, WebRequestHandler<Enrollment[]> webRequestHandler);

}
