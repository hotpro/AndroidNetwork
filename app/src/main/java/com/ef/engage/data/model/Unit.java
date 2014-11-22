package com.ef.engage.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/22/14
 */
public class Unit {
    private int unitId;
    private String name;
    private String imagePath;
    private List<Lesson> lessons = new ArrayList<Lesson>();
}
