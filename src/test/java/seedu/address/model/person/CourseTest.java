package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Course(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidPhone = "";
        assertThrows(IllegalArgumentException.class, () -> new Course(invalidPhone));
    }

    @Test
    public void isValidPhone() {
        // null phone number
        assertThrows(NullPointerException.class, () -> Course.isValidCourse(null));

        // invalid phone numbers
        assertFalse(Course.isValidCourse("")); // empty string
        assertFalse(Course.isValidCourse(" ")); // spaces only
        assertFalse(Course.isValidCourse("91")); // less than 3 numbers
        assertFalse(Course.isValidCourse("phone")); // non-numeric
        assertFalse(Course.isValidCourse("9011p041")); // alphabets within digits
        assertFalse(Course.isValidCourse("9312 1534")); // spaces within digits

        // valid phone numbers
        assertTrue(Course.isValidCourse("911")); // exactly 3 numbers
        assertTrue(Course.isValidCourse("93121534"));
        assertTrue(Course.isValidCourse("124293842033123")); // long phone numbers
    }

    @Test
    public void equals() {
        Course course = new Course("999");

        // same values -> returns true
        assertTrue(course.equals(new Course("999")));

        // same object -> returns true
        assertTrue(course.equals(course));

        // null -> returns false
        assertFalse(course.equals(null));

        // different types -> returns false
        assertFalse(course.equals(5.0f));

        // different values -> returns false
        assertFalse(course.equals(new Course("995")));
    }
}
