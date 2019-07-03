package com.tje.scan;

import java.sql.*;

public class Closer {
	public static void close(Connection obj) {
		if( obj == null ) {
			return;
		}
		try {
			obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement obj) {
		if( obj == null ) {
			return;
		}
		try {
			obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement obj) {
		if( obj == null ) {
			return;
		}
		try {
			obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet obj) {
		if( obj == null ) {
			return;
		}
		try {
			obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
