package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.HOON;
import static seedu.address.testutil.TypicalPersons.IDA;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.StudentList;
import seedu.address.model.ReadOnlyStudentList;

public class JsonStudentListStorageTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonAddressBookStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readAddressBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readAddressBook(null));
    }

    private java.util.Optional<ReadOnlyStudentList> readAddressBook(String filePath) throws Exception {
        return new JsonStudentListStorage(Paths.get(filePath)).readStudentList(addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readAddressBook("NonExistentFile.json").isPresent());
    }

    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataLoadingException.class, () -> readAddressBook("notJsonFormatAddressBook.json"));
    }

    @Test
    public void readAddressBook_invalidPersonAddressBook_throwDataLoadingException() {
        assertThrows(DataLoadingException.class, () -> readAddressBook("invalidPersonAddressBook.json"));
    }

    @Test
    public void readAddressBook_invalidAndValidPersonAddressBook_throwDataLoadingException() {
        assertThrows(DataLoadingException.class, () -> readAddressBook("invalidAndValidPersonAddressBook.json"));
    }

    @Test
    public void readAndSaveAddressBook_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempAddressBook.json");
        StudentList original = getTypicalAddressBook();
        JsonStudentListStorage jsonAddressBookStorage = new JsonStudentListStorage(filePath);

        // Save in new file and read back
        jsonAddressBookStorage.saveStudentList(original, filePath);
        ReadOnlyStudentList readBack = jsonAddressBookStorage.readStudentList(filePath).get();
        assertEquals(original, new StudentList(readBack));

        // Modify data, overwrite exiting file, and read back
        original.addStudent(HOON);
        original.removeStudent(ALICE);
        jsonAddressBookStorage.saveStudentList(original, filePath);
        readBack = jsonAddressBookStorage.readStudentList(filePath).get();
        assertEquals(original, new StudentList(readBack));

        // Save and read without specifying file path
        original.addStudent(IDA);
        jsonAddressBookStorage.saveStudentList(original); // file path not specified
        readBack = jsonAddressBookStorage.readStudentList().get(); // file path not specified
        assertEquals(original, new StudentList(readBack));

    }

    @Test
    public void saveAddressBook_nullAddressBook_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveAddressBook(null, "SomeFile.json"));
    }

    /**
     * Saves {@code addressBook} at the specified {@code filePath}.
     */
    private void saveAddressBook(ReadOnlyStudentList addressBook, String filePath) {
        try {
            new JsonStudentListStorage(Paths.get(filePath))
                    .saveStudentList(addressBook, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveAddressBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveAddressBook(new StudentList(), null));
    }
}
