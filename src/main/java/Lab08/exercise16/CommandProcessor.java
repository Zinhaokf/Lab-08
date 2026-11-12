package Lab08.exercise16;

import java.util.ArrayList;
import java.util.List;
import Lab08.exercise15.UndoableCommand;

public class CommandProcessor {

    private final List<UndoableCommand> aCommands = new ArrayList<>();

    public void consume(UndoableCommand pCommand) {
        pCommand.execute();
        aCommands.add(pCommand);
    }

    public void undoLast() {
        assert !aCommands.isEmpty();
        UndoableCommand command = aCommands.remove(aCommands.size() - 1);
        command.undo();
    }
}