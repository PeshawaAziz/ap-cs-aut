
package uni;

import java.util.ArrayList;

public class Student {
    public int id;
    public int personID;
    public int majorID;
    public String studentID;
    public final int entranceYear;

    public static ArrayList<Student> studentList = new ArrayList<>();

    public Student(int personID, int entranceYear, int majorID) {
        this.id = studentList.size();

        for (Major major : Major.majorList) {
            if (major.id == majorID) {
                major.addStudent();
                this.personID = major.numberOfStudents;
                break;
            }
        }

        this.entranceYear = entranceYear;
        this.majorID = majorID;

        setStudentCode();

        studentList.add(this);
    }

    public static Student findByID(int id) {
        for (Student student : studentList) {
            if (student.id == id)
                return student;
        }
        return null;
    }

    public void setStudentCode() {
        this.studentID = entranceYear + "" + majorID + "" + personID;
    }
}