package seedu.address.model.student.predicates;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.student.Student;

/**
 * Tests that a {@code Person}'s {@code PendingQuestion} exists.
 */
public class AllPendingQuestionPredicate implements Predicate<Student> {

    public AllPendingQuestionPredicate() {
    }

    @Override
    public boolean test(Student student) {
        return student.getPendingQuestion().value.length() > 0;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AllPendingQuestionPredicate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
