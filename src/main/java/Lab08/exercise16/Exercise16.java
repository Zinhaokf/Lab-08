package Lab08.exercise16;

import Lab08.Movie;
import Lab08.exercise15.Program;
import Lab08.exercise15.Program.Day;

public class Exercise16 {
    public static void main(String[] args) {
        Program program = new Program();
        CommandProcessor processor = new CommandProcessor();

        processor.consume(program.createAddCommand(new Movie("Movie 1", 2000, 120), Day.MONDAY));
        processor.consume(program.createAddCommand(new Movie("Movie 2", 2010, 90), Day.WEDNESDAY));
        System.out.println("After two adds:\n" + program);

        processor.undoLast();
        System.out.println("After undoLast:\n" + program);

        processor.undoLast();
        System.out.println("After second undoLast:\n" + program);
    }
}