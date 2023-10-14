package seedu.address.testutil;

import seedu.address.model.StudentList;
import seedu.address.model.person.Student;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private StudentList studentList;

    public AddressBookBuilder() {
        studentList = new StudentList();
    }

    public AddressBookBuilder(StudentList studentList) {
        this.studentList = studentList;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withPerson(Student student) {
        studentList.addStudent(student);
        return this;
    }

    public StudentList build() {
        return studentList;
    }
}
