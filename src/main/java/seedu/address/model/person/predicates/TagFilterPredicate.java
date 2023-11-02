package seedu.address.model.person.predicates;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Student;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class TagFilterPredicate implements Predicate<Student> {
    private final List<String> keywords;

    public TagFilterPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Student student) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(student.getTag().getStringRanking(), keyword));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TagFilterPredicate)) {
            return false;
        }

        TagFilterPredicate otherTagFilterPredicate = (TagFilterPredicate) other;
        return keywords.equals(otherTagFilterPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
