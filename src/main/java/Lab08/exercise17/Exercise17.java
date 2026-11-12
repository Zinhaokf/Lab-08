package Lab08.exercise17;

import Lab08.Movie;
import Lab08.exercise15.Program;
import Lab08.exercise15.Program.Day;

public class Exercise17 {
    public static void main(String[] args) {
        Program program = new Program();
        CommandProcessor processor = new CommandProcessor();

        processor.consume(program.createAddCommand(new Movie("Movie 1", 2000, 120), Day.MONDAY));
        System.out.println("After add:\n" + program);

        processor.undoLast();
        System.out.println("After undoLast:\n" + program);

        processor.redoLast();
        System.out.println("After redoLast:\n" + program);
    }
}