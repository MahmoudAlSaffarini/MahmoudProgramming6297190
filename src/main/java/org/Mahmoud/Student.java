package org.Mahmoud;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Student {

    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId);
        nextId++;

        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;

        this.registeredCourses = new ArrayList<>();
    }

    /**
     * Checks if a course is registered for the student before adding it.
     * @param course the course to be registered.
     * @return true if the course will be registered, false if it was already registered.
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);

        course.registerStudent(this);

        return true;
    }

    /**
     * Drops and removes the student from the course if they exist in the list.
     * @param course the course to be dropped.
     * @return true if the course was successfully dropped, false if the student is not registered.
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.remove(course);

        course.getRegisteredStudents().remove(this);

        return true;
    }

    /**
     * Converts a student to a simple string.
     * @return a simple string containing the studentId, studentName, and departmentName.
     */
    public String toSimplifiedString() {
        return String.format("%s %s %s", studentId, studentName, department.getDepartmentName());
    }

    public void setStudentName(String studentName) {
        this.studentName = Util.toTitleCase(studentName);
    }

    @Override
    public String toString() {
        String coursesString = "[";

        for (Course course : registeredCourses) {
            coursesString += course.toSimplifiedString() + ", ";
        }
        if (registeredCourses.size() > 0) {
            coursesString = coursesString.substring(0, coursesString.length() - 2);
        }
        coursesString += "]";

        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + coursesString +
                '}';
    }
}
