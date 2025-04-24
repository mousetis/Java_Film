package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Showtimes {
	String showtimeID;
	Movies movieID;
	Room roomID;
	LocalDateTime startedTime;
	LocalDateTime endTime;
	
	public Showtimes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Showtimes(String showtimeID, Movies movieID, Room roomID, LocalDateTime startedTime, LocalDateTime endTime) {
		super();
		this.showtimeID = showtimeID;
		this.movieID = movieID;
		this.roomID = roomID;
		this.startedTime = startedTime;
		this.endTime = endTime;
	}

	public String getShowtimeID() {
		return showtimeID;
	}

	public void setShowtimeID(String showtimeID) {
		this.showtimeID = showtimeID;
	}

	public Movies getMovieID() {
		return movieID;
	}

	public void setMovieID(Movies movieID) {
		this.movieID = movieID;
	}

	public Room getRoomID() {
		return roomID;
	}

	public void setRoomID(Room roomID) {
		this.roomID = roomID;
	}

	public LocalDateTime getStartedTime() {
		return startedTime;
	}

	public void setStartedTime(LocalDateTime startedTime) {
		this.startedTime = startedTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(showtimeID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Showtimes other = (Showtimes) obj;
		return Objects.equals(showtimeID, other.showtimeID);
	}

	@Override
	public String toString() {
		return "Showtimes [showtimeID=" + showtimeID + ", movieID=" + movieID + ", roomID=" + roomID + ", startedTime="
				+ startedTime + ", endTime=" + endTime + "]";
	}
	
	
}
