package Lab08.exercise18;

import java.util.ArrayList;
import java.util.List;
import Lab08.exercise15.UndoableCommand;

public class BasicCommandProcessor implements CommandProcessor {

    private final List<UndoableCommand> aExecutedCommands = new ArrayList<>();
    private final List<UndoableCommand> aUndoneCommands = new ArrayList<>();

    public void consume(UndoableCommand pCommand) {
        pCommand.execute();
        aExecutedCommands.add(pCommand);
    }

    public void undoLast() {
        assert !aExecutedCommands.isEmpty();
        UndoableCommand command = aExecutedCommands.remove(aExecutedCommands.size() - 1);
        command.undo();
        aUndoneCommands.add(command);
    }

    public void redoLast() {
        assert !aUndoneCommands.isEmpty();
        UndoableCommand command = aUndoneCommands.remove(aUndoneCommands.size() - 1);
        consume(command);
    }
}