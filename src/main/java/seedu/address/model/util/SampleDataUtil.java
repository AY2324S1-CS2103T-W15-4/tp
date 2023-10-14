package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.ReadOnlyStudentList;
import seedu.address.model.StudentList;
import seedu.address.model.person.Course;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Student;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code StudentList} with sample data.
 */
public class SampleDataUtil {
    public static Student[] getSampleStudents() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"), new Course("CS2103T"), new Email("alexyeoh@u.nus.edu"),
                getTagSet("GOOD")),
            new Student(new Name("Bernice Yu"), new Course("CS2103T"), new Email("berniceyu@u.nus.edu"),
                getTagSet("GOOD")),
            new Student(new Name("Charlotte Oliveiro"), new Course("CS2103T"), new Email("charlotte@u.nus.edu"),
                getTagSet("POOR")),
            new Student(new Name("David Li"), new Course("CS2103T"), new Email("lidavid@u.nus.edu"),
                getTagSet("POOR")),
            new Student(new Name("Irfan Ibrahim"), new Course("CS2103T"), new Email("irfan@u.nus.edu"),
                getTagSet("AVERAGE")),
            new Student(new Name("Roy Balakrishnan"), new Course("CS2103T"), new Email("royb@u.nus.edu"),
                getTagSet("AVERAGE"))
        };
    }

    public static ReadOnlyStudentList getSampleStudentList() {
        StudentList sampleSl = new StudentList();
        for (Student sampleStudent : getSampleStudents()) {
            sampleSl.addStudent(sampleStudent);
        }
        return sampleSl;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
