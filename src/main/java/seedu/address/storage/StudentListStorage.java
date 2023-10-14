package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyStudentList;
import seedu.address.model.StudentList;

/**
 * Represents a storage for {@link StudentList}.
 */
public interface StudentListStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getStudentListFilePath();

    /**
     * Returns AddressBook data as a {@link ReadOnlyStudentList}.
     * Returns {@code Optional.empty()} if storage file is not found.
     *
     * @throws DataLoadingException if loading the data from storage failed.
     */
    Optional<ReadOnlyStudentList> readStudentList() throws DataLoadingException;

    /**
     * @see #getStudentListFilePath()
     */
    Optional<ReadOnlyStudentList> readStudentList(Path filePath) throws DataLoadingException;

    /**
     * Saves the given {@link ReadOnlyStudentList} to the storage.
     * @param addressBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveStudentList(ReadOnlyStudentList addressBook) throws IOException;

    /**
     * @see #saveStudentList(ReadOnlyStudentList)
     */
    void saveStudentList(ReadOnlyStudentList addressBook, Path filePath) throws IOException;

}
