package com.ef.engage.data.net;

import com.ef.engage.data.ServiceResponse;
import com.ef.engage.data.model.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/22/14
 */
public class CourseReponse extends ServiceResponse {
    private int courseId;
    private String title;
    private List<Level> levels = new ArrayList<Level>();
}
