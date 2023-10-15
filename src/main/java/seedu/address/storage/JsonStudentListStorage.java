package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyStudentList;

/**
 * A class to access AddressBook data stored as a json file on the hard disk.
 */
public class JsonStudentListStorage implements StudentListStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonStudentListStorage.class);

    private Path filePath;

    public JsonStudentListStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getStudentListFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyStudentList> readStudentList() throws DataLoadingException {
        return readStudentList(filePath);
    }

    /**
     * Similar to {@link #readStudentList()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataLoadingException if loading the data from storage failed.
     */
    public Optional<ReadOnlyStudentList> readStudentList(Path filePath) throws DataLoadingException {
        requireNonNull(filePath);

        Optional<JsonSerializableStudentList> jsonAddressBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableStudentList.class);
        if (!jsonAddressBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonAddressBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataLoadingException(ive);
        }
    }

    @Override
    public void saveStudentList(ReadOnlyStudentList addressBook) throws IOException {
        saveStudentList(addressBook, filePath);
    }

    /**
     * Similar to {@link #saveStudentList(ReadOnlyStudentList)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveStudentList(ReadOnlyStudentList addressBook, Path filePath) throws IOException {
        requireNonNull(addressBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableStudentList(addressBook), filePath);
    }

}
