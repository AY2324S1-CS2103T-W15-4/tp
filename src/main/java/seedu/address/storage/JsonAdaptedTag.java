package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.tag.StudentRank;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Tag}.
 */
class JsonAdaptedTag {

    private final StudentRank ranking;

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedTag(StudentRank ranking) {
        this.ranking = ranking;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedTag(Tag source) {
        ranking = source.ranking;
    }

    @JsonValue
    public String getTagName() {
        return ranking.toString();
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Tag toModelType() throws IllegalValueException {
        if (!Tag.isValidTagName(ranking.toString())) {
            throw new IllegalValueException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(ranking);
    }

}
