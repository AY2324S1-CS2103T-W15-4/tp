package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Students's course in the student list.
 * Guarantees: immutable; is valid as declared in {@link #isValidCourse(String)}
 */
public class Course {


    public static final String MESSAGE_CONSTRAINTS =
            "Course code should contain a two- or three-letter prefix, "
                    + "four digits course code and an optional one-letter suffix";
    public static final String VALIDATION_REGEX = "\\w{6,8}";
    public final String value;

    /**
     * Constructs a {@code Course}.
     *
     * @param course A valid course code.
     */
    public Course(String course) {
        requireNonNull(course);
        checkArgument(isValidCourse(course), MESSAGE_CONSTRAINTS);
        value = course;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidCourse(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Course)) {
            return false;
        }

        Course otherCourse = (Course) other;
        return value.equals(otherCourse.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
