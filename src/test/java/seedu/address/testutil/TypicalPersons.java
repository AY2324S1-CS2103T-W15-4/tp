package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_COURSE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COURSE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_GOOD;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_POOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.StudentList;
import seedu.address.model.person.Student;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Student ALICE = new PersonBuilder().withName("Alice Pauline")
            .withEmail("alice@example.com")
            .withCourse("CS2103T")
            .withTags("friends").build();
    public static final Student BENSON = new PersonBuilder().withName("Benson Meier")
            .withEmail("johnd@example.com").withCourse("98765432")
            .withTags("owesMoney", "friends").build();
    public static final Student CARL = new PersonBuilder().withName("Carl Kurz").withCourse("CS2103T")
            .withEmail("heinz@example.com").build();
    public static final Student DANIEL = new PersonBuilder().withName("Daniel Meier").withCourse("CS2103T")
            .withEmail("cornelia@example.com").withTags("friends").build();
    public static final Student ELLE = new PersonBuilder().withName("Elle Meyer").withCourse("CS2103T")
            .withEmail("werner@example.com").build();
    public static final Student FIONA = new PersonBuilder().withName("Fiona Kunz").withCourse("CS2103T")
            .withEmail("lydia@example.com").build();
    public static final Student GEORGE = new PersonBuilder().withName("George Best").withCourse("CS2103T")
            .withEmail("anna@example.com").build();

    // Manually added
    public static final Student HOON = new PersonBuilder().withName("Hoon Meier").withCourse("CS2103T")
            .withEmail("stefan@example.com").build();
    public static final Student IDA = new PersonBuilder().withName("Ida Mueller").withCourse("CS2103T")
            .withEmail("hans@example.com").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Student AMY = new PersonBuilder().withName(VALID_NAME_AMY).withCourse(VALID_COURSE_AMY)
            .withEmail(VALID_EMAIL_AMY).withTags(VALID_TAG_POOR).build();
    public static final Student BOB = new PersonBuilder().withName(VALID_NAME_BOB).withCourse(VALID_COURSE_BOB)
            .withEmail(VALID_EMAIL_BOB).withTags(VALID_TAG_GOOD)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static StudentList getTypicalAddressBook() {
        StudentList ab = new StudentList();
        for (Student student : getTypicalPersons()) {
            ab.addStudent(student);
        }
        return ab;
    }

    public static List<Student> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
