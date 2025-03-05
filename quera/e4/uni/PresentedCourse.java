
package uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int id;
    public int courseID;
    public int professorID;
    public int capacity;

    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public static ArrayList<Integer> studentIDs = new ArrayList<>();

    public PresentedCourse(int courseID, int professorID, int capacity) {
        this.id = presentedCourseList.size();
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = capacity;

        presentedCourseList.add(this);
    }

    public static PresentedCourse findByID(int id) {
        for (PresentedCourse presentedCourse : presentedCourseList) {
            if (presentedCourse.id == id)
                return presentedCourse;
        }
        return null;
    }

    public void addStudent(int studentID) {
        if (studentIDs.size() < capacity) {
            studentIDs.add(studentID);
        } else {
            System.out.println("Maximum presented course capacity reached!");
        }
    }
}