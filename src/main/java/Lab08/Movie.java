package Lab08;

import java.util.Objects;

public final class Movie implements Show {
	private final String title;
	private final int year;
	private final int runningTime;

	public Movie(String title, int year, int runningTime) {
		this.title = Objects.requireNonNull(title, "title");
		this.year = year;
		this.runningTime = runningTime;
	}

	@Override
	public String description() {
		return String.format("%s (%d)", title, year);
	}

	@Override
	public int runningTime() {
		return runningTime;
	}

	@Override
	public Show copy() {
		return new Movie(title, year, runningTime);
	}
}
