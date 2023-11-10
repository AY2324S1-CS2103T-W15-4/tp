package seedu.codesphere.logic.parser;

import static seedu.codesphere.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.codesphere.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.codesphere.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.codesphere.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.codesphere.testutil.TypicalIndexes.INDEX_FIRST_STUDENT;

import org.junit.jupiter.api.Test;

import seedu.codesphere.commons.core.index.Index;
import seedu.codesphere.logic.commands.RemarkCommand;
import seedu.codesphere.logic.commands.RemoveCommand;
import seedu.codesphere.logic.stagemanager.StageManager;
import seedu.codesphere.model.course.Course;
import seedu.codesphere.model.student.Remark;
import seedu.codesphere.testutil.CourseBuilder;
import seedu.codesphere.testutil.StudentBuilder;

public class RemoveCommandParserTest {
    private RemoveCommandParser parser = new RemoveCommandParser();

    @Test
    public void parse_indexSpecified_success() {
        Course validCourse = new CourseBuilder().build();
        StageManager.getInstance().setCourseStage(validCourse);
        validCourse.addStudent(new StudentBuilder().withRemark("").build());

        RemoveCommand.EditStudentDescriptor studentDescriptor = new RemoveCommand.EditStudentDescriptor();
        studentDescriptor.setRemark(new Remark(""));
        Index targetIndex = INDEX_FIRST_STUDENT;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_REMARK;
        RemoveCommand expectedCommand = new RemoveCommand(INDEX_FIRST_STUDENT, studentDescriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemoveCommand.MESSAGE_USAGE);

        // no parameters
        assertParseFailure(parser, RemoveCommand.COMMAND_WORD, expectedMessage);

        // no index
        assertParseFailure(parser, RemarkCommand.COMMAND_WORD + " ", expectedMessage);
    }
}
