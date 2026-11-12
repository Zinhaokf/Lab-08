package Lab08;

import java.util.Objects;

public final class Concert implements Show {
	private final String title;
	private final String performer;
	private final int runningTime;

	public Concert(String title, String performer, int runningTime) {
		this.title = Objects.requireNonNull(title, "title");
		this.performer = Objects.requireNonNull(performer, "performer");
		this.runningTime = runningTime;
	}

	@Override
	public String description() {
		return String.format("%s by %s", title, performer);
	}

	@Override
	public int runningTime() {
		return runningTime;
	}

	@Override
	public Show copy() {
		return new Concert(title, performer, runningTime);
	}
}
