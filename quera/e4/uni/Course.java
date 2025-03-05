package uni;

import java.util.ArrayList;

public class Course {
    public int id;
    public int units;
    public String title;

    public static ArrayList<Course> courseList = new ArrayList<>();

    public Course(String title, int units) {
        this.id = courseList.size();
        this.title = title;

        courseList.add(this);
    }

    public static Course findByID(int id) {
        for (Course course : courseList) {
            if (course.id == id)
                return course;
        }
        return null;
    }
}