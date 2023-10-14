package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyStudentList;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private StudentListStorage studentListStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code AddressBookStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(StudentListStorage studentListStorage, UserPrefsStorage userPrefsStorage) {
        this.studentListStorage = studentListStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataLoadingException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getStudentListFilePath() {
        return studentListStorage.getStudentListFilePath();
    }

    @Override
    public Optional<ReadOnlyStudentList> readStudentList() throws DataLoadingException {
        return readStudentList(studentListStorage.getStudentListFilePath());
    }

    @Override
    public Optional<ReadOnlyStudentList> readStudentList(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return studentListStorage.readStudentList(filePath);
    }

    @Override
    public void saveStudentList(ReadOnlyStudentList addressBook) throws IOException {
        saveStudentList(addressBook, studentListStorage.getStudentListFilePath());
    }

    @Override
    public void saveStudentList(ReadOnlyStudentList addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        studentListStorage.saveStudentList(addressBook, filePath);
    }

}
