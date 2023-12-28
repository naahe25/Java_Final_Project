import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String studentName;
    private String rollNumber;
    private String subject;
    private String major;
    private CourseType courseType;

    // Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(String studentName, String rollNumber, String subject, String major, CourseType courseType) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.subject = subject;
        this.major = major;
        this.courseType = courseType;
    }

    // Getters and Setters

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    // Enum for CourseType
    public enum CourseType {
        MAJOR, NON_MAJOR, OPTIONAL
    }
}
