package com.ef.engage.data;

import com.ef.engage.data.model.Course;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/18/14
 */
public interface DataService {

    public void login();

    public void getStudyContext();

    public void getCourse(String id, DataRequestHandler<Course> dataRequestHandler);

    public void getCourseList();

    public void submitProgress();
}
