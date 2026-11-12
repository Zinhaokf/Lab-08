package Lab08.exercise18;

import Lab08.exercise15.UndoableCommand;

public interface CommandProcessor {
    void consume(UndoableCommand pCommand);

    void undoLast();

    void redoLast();
}