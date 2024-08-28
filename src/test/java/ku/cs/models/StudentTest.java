package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    public void testConstructorWithTwoParams() {
        Student student = new Student("1", "Alice");
        assertEquals("1", student.getId());
        assertEquals("Alice", student.getName());
        assertEquals(0, student.getScore());
    }

    @Test
    public void testConstructorWithThreeParams() {
        Student student = new Student("1", "Bob", 85.5);
        assertEquals("1", student.getId());
        assertEquals("Bob", student.getName());
        assertEquals(85.5, student.getScore());
    }

    @Test
    public void testChangeName() {
        Student student = new Student("1", "Alice");
        student.changeName("Bob");
        assertEquals("Bob", student.getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.5 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิมคะแนน 86 คะแนน และให้ object คำนวณเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    public void testIsId() {
        Student student = new Student("1", "Alice");
        assertTrue(student.isId("1"));
        assertFalse(student.isId("2"));
    }

    @Test
    public void testToString() {
        Student student = new Student("1", "Alice", 85.5);
        assertEquals("{id: '1', name: 'Alice', score: 85.5}", student.toString());
    }
}