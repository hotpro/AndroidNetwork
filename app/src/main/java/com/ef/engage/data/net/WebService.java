package com.ef.engage.data.net;


import com.ef.engage.data.model.Course;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/18/14
 *
 * assemble http request from arguments
 * this handler 403, 500, error code, error description,
 */
public interface WebService {

    public void getCourse(String id, WebRequestHandler<Course> webRequestHandler);

}
