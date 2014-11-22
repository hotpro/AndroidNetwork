package com.ef.engage.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/22/14
 */
public class Lesson {
    private int lessonId;
    private String title;
    private String details;
    private String imagePath;
    private List<Module> modules = new ArrayList<Module>();
}
