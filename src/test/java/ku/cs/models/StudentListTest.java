package ku.cs.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentListTest {

    @Test
    public void testAddNewStudent() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("1", "Alice");
        assertEquals(1, studentList.getStudents().size());
    }

    @Test
    public void testFindStudentById() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("1", "Alice");
        assertNotNull(studentList.findStudentById("1"));
        assertNull(studentList.findStudentById("2"));
    }

    @Test
    public void testGiveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("1", "Alice");
        studentList.giveScoreToId("1", 10.5);
        assertEquals(10.5, studentList.findStudentById("1").getScore());
    }

    @Test
    public void testViewGradeOfId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("1", "Alice", 85.5);
        assertEquals("A", studentList.viewGradeOfId("1"));
    }
}
