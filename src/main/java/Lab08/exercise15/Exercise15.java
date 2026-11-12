package Lab08.exercise15;

import Lab08.Movie;
import Lab08.exercise15.Program.Day;

public class Exercise15 {
    public static void main(String[] args) {
        Program program = new Program();

        UndoableCommand command = program.createAddCommand(new Movie("Movie 1", 2000, 120), Day.MONDAY);
        command.execute();
        System.out.println("After add Movie 1:\n" + program);
        command.undo();
        System.out.println("After undo add:\n" + program);
        command.execute();

        command = program.createAddCommand(new Movie("Movie 2", 2010, 90), Day.WEDNESDAY);
        command.execute(); // No undo on purpose
        System.out.println("After add Movie 2:\n" + program);

        command = program.createRemoveCommand(Day.MONDAY);
        command.execute();
        System.out.println("After remove Monday:\n" + program);
        command.undo();
        System.out.println("After undo remove:\n" + program);

        command = program.createClearCommand();
        command.execute();
        System.out.println("After clear:\n" + program);
        command.undo();
        System.out.println("After undo clear:\n" + program);
    }
}