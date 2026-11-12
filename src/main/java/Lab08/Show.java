package Lab08;

/**
 * A performance that can take place in a theater.
 */
public interface Show {
	String description();

	int runningTime();

	Show copy();
}
