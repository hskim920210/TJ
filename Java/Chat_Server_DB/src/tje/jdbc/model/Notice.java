package tje.jdbc.model;

import java.io.*;
import java.util.*;

public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String message;
	private Date write_date;

	public Notice() {
	}

	public Notice(int id, String message, Date write_date) {
		this.id = id;
		this.message = message;
		this.write_date = write_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

}
