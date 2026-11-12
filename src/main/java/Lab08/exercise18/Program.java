package Lab08.exercise18;

import java.util.EnumMap;
import Lab08.Show;
import Lab08.exercise15.UndoableCommand;

public class Program {

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    private static final Show NULL_SHOW = createNullShow();

    private static Show createNullShow() {
        return new Show() {
            public String description() { return ""; }
            public int runningTime() { return 0; }
            public Show copy() { return createNullShow(); }
            public int hashCode() { return 0; }
            public boolean equals(Object pObject) {
                return pObject != null && pObject.getClass() == this.getClass();
            }
        };
    }

    private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
    private final CommandProcessor aProcessor;

    public Program(CommandProcessor pProcessor) {
        aProcessor = pProcessor;
        clearShows();
    }

    public void add(Show pShow, Day pDay) {
        aProcessor.consume(createAddCommand(pShow, pDay));
    }

    public void remove(Day pDay) {
        aProcessor.consume(createRemoveCommand(pDay));
    }

    public void clear() {
        aProcessor.consume(createClearCommand());
    }

    public void undoLast() {
        aProcessor.undoLast();
    }

    public void redoLast() {
        aProcessor.redoLast();
    }

    private UndoableCommand createAddCommand(Show pShow, Day pDay) {
        return new UndoableCommand() {
            public void execute() {
                addShow(pShow, pDay);
            }

            public void undo() {
                removeShow(pDay);
            }
        };
    }

    private UndoableCommand createRemoveCommand(Day pDay) {
        return new UndoableCommand() {
            Show show = aShows.get(pDay);

            public void execute() {
                show = aShows.get(pDay);
                removeShow(pDay);
            }

            public void undo() {
                addShow(show, pDay);
            }
        };
    }

    private UndoableCommand createClearCommand() {
        return new UndoableCommand() {
            EnumMap<Day, Show> previousShows = new EnumMap<>(aShows);

            public void execute() {
                previousShows = new EnumMap<>(aShows);
                clearShows();
            }

            public void undo() {
                aShows.putAll(previousShows);
            }
        };
    }

    private void clearShows() {
        for (Day day : Day.values()) {
            aShows.put(day, NULL_SHOW);
        }
    }

    private void addShow(Show pShow, Day pDay) {
        assert pShow != null && pDay != null;
        aShows.put(pDay, pShow);
    }

    private void removeShow(Day pDay) {
        assert pDay != null;
        aShows.put(pDay, NULL_SHOW);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Day day : aShows.keySet()) {
            result
                    .append(String.format("%9s", day.name()))
                    .append(": ")
                    .append(aShows.get(day).description())
                    .append("\n");
        }
        return result.toString();
    }
}