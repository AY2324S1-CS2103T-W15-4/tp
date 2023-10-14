package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_GOOD;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.Student;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.testutil.PersonBuilder;

public class StudentListTest {

    private final StudentList studentList = new StudentList();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), studentList.getStudentList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> studentList.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        StudentList newData = getTypicalAddressBook();
        studentList.resetData(newData);
        assertEquals(newData, studentList);
    }

    @Test
    public void resetData_withDuplicatePersons_throwsDuplicatePersonException() {
        // Two persons with the same identity fields
        Student editedAlice = new PersonBuilder(ALICE).withTags(VALID_TAG_GOOD)
                .build();
        List<Student> newStudents = Arrays.asList(ALICE, editedAlice);
        StudentListStub newData = new StudentListStub(newStudents);

        assertThrows(DuplicatePersonException.class, () -> studentList.resetData(newData));
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> studentList.hasStudent(null));
    }

    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(studentList.hasStudent(ALICE));
    }

    @Test
    public void hasPerson_personInAddressBook_returnsTrue() {
        studentList.addStudent(ALICE);
        assertTrue(studentList.hasStudent(ALICE));
    }

    @Test
    public void hasPerson_personWithSameIdentityFieldsInAddressBook_returnsTrue() {
        studentList.addStudent(ALICE);
        Student editedAlice = new PersonBuilder(ALICE).withTags(VALID_TAG_GOOD)
                .build();
        assertTrue(studentList.hasStudent(editedAlice));
    }

    @Test
    public void getPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> studentList.getStudentList().remove(0));
    }

    @Test
    public void toStringMethod() {
        String expected = StudentList.class.getCanonicalName() + "{persons=" + studentList.getStudentList() + "}";
        assertEquals(expected, studentList.toString());
    }

    /**
     * A stub ReadOnlyAddressBook whose persons list can violate interface constraints.
     */
    private static class StudentListStub implements ReadOnlyStudentList {
        private final ObservableList<Student> students = FXCollections.observableArrayList();

        StudentListStub(Collection<Student> students) {
            this.students.setAll(students);
        }

        @Override
        public ObservableList<Student> getStudentList() {
            return students;
        }
    }

}
