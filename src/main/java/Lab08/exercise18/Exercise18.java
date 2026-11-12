package Lab08.exercise18;

import Lab08.Movie;
import Lab08.exercise18.Program.Day;

public class Exercise18 {
    public static void main(String[] args) {
        Program program = new Program(new BasicCommandProcessor());

        program.add(new Movie("Movie 1", 2000, 120), Day.MONDAY);
        program.add(new Movie("Movie 2", 2010, 90), Day.WEDNESDAY);
        System.out.println("After two adds:\n" + program);

        program.remove(Day.MONDAY);
        System.out.println("After remove Monday:\n" + program);

        program.undoLast();
        System.out.println("After undoLast:\n" + program);

        program.redoLast();
        System.out.println("After redoLast:\n" + program);

        program.clear();
        program.undoLast();
        System.out.println("After clear + undoLast:\n" + program);
    }
}