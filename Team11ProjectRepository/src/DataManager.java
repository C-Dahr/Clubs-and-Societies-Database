import java.sql.*;
import java.util.ArrayList;

public class DataManager {

	Connection connection = null;
	
	public static int currentClubRequestId = 0;
	public static int currentClubAdminRequestId = 0;
	public static int currentClubId = 0;

	public DataManager() {
		 try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	     } catch (Exception e) {
	      System.err.println(e.toString());
	     }
		String url = "jdbc:mysql://cs2043.cs.unb.ca:3306/cs2043team11";
		try {
		connection = DriverManager.getConnection(url, "cs2043team11", "UVoP6FF3");
		} catch (SQLException e) {
		System.err.println("Database connection error.");
		}
	}
	
	public boolean setNewAdminRequest(ClubAdminRequestObject adminRequest) {
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "INSERT INTO ClubAdminRequests VALUES('" + ++currentClubAdminRequestId + "',"
														+ " '" + adminRequest.nameOfRequestSender + "',"
														+ " '" + adminRequest.username + "',"
														+ " '" + adminRequest.password + "',"
														+ "'" + adminRequest.firstName + "',"
														+ "'" + adminRequest.lastName + "',"
														+ "'" + adminRequest.email + "',"
														+ "'" + adminRequest.clubName + "');";
			
			//execute SQL query
			st.executeUpdate(sqlQuery);
			
			result = true;

		} 
		catch (SQLException e) {
			System.err.println("SQL error: setNewClubAdminRequest");
		}
		return result;
	}

	public ArrayList<ClubObject> getAllClubs() {
		ArrayList<ClubObject> clubsList = new ArrayList<ClubObject>();
		
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "SELECT * FROM Clubs;";
			
			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			
			//convert retrieved rows to clubInfoObject[]
			while (rs.next()) {
				ClubObject club = new ClubObject();
				club.id = rs.getString(1);
				club.name = rs.getString(2);
				club.description = rs.getString(3);
				club.location = rs.getString(4);
				club.clubAdmin = rs.getString(5);
				// Club Events to be added later
				//club.events = rs
				clubsList.add(club);
			}
		} 
		catch (SQLException e) {
			System.err.println("SQL error: getAllClubs");
		}
		
		return clubsList;
	}

	public ArrayList<ClubObject> getClubsFromFilterSearch(ArrayList<String> keywords) {
		ArrayList<ClubObject> clubList = new ArrayList<ClubObject>();
		try {
			Statement st = connection.createStatement();
			
			String sqlQuery = "SELECT * FROM Clubs WHERE ";
			for(int i = 0; i < keywords.size(); i++) {
				if (i < keywords.size() - 1) 
					sqlQuery += "name LIKE '%" + keywords.get(i) + "%' OR description LIKE '%" + keywords.get(i) + "%' OR ";
				else
					sqlQuery += "name LIKE '%" + keywords.get(i) + "%' OR description LIKE '%" + keywords.get(i) + "%';";
			}
			
			ResultSet rs = st.executeQuery(sqlQuery);
			
			while (rs.next()) {
				ClubObject club = new ClubObject();
				club.id = rs.getString(1);
				club.name = rs.getString(2);
				club.description = rs.getString(3);
				club.location = rs.getString(4);
				club.clubAdmin = rs.getString(5);
				clubList.add(club);				
			}
		} catch (SQLException e) {
			System.err.println("SQL error: getClubsFromFilterSearch");
		}
		
		return clubList;
	}

	public ClubObject getClubByClubName(String clubName) {

		ClubObject club = new ClubObject();
		
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "SELECT * FROM Clubs WHERE name = '" + clubName + "';";
			
			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			
			rs.next();
			
			club.id = rs.getString(1);
			club.name = rs.getString(2);
			club.description = rs.getString(3);
			club.location = rs.getString(4);
			club.clubAdmin = rs.getString(5);
		} 
		catch (SQLException e) {
			System.err.println("SQL error: getClubByClubName");
		}
		
		return club;
	}

	public ClubAdminAccountObject getClubAdminAccount(String id, String password) {
		ClubAdminAccountObject account = null;
		try {
			Statement st = connection.createStatement();
		
			String sqlQuery = "SELECT * FROM ClubAdminAccounts WHERE username = '" + id + "' AND password = '" + password + "';";
			ResultSet rs = st.executeQuery(sqlQuery);
			
			rs.next();
			
			account = new ClubAdminAccountObject(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));		
		}
		catch (SQLException e) {
			System.err.println("SQL error: no club admin account found.");
		}
		
		return account;
	}

	public boolean setNewCreateClubRequest(ClubRequestObject clubRequestIn) {
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "INSERT INTO ClubRequests VALUES('" + ++currentClubRequestId + "',"
														+ " '" + clubRequestIn.nameOfRequestSender + "',"
														+ " '" + clubRequestIn.description + "',"
														+ "'" + clubRequestIn.location + "',"
														+ "'" + clubRequestIn.clubName + "');";
			
			//execute SQL query
			st.executeUpdate(sqlQuery);
			
			result = true;

		} 
		catch (SQLException e) {
			System.err.println("SQL error: setNewCreateClubRequest");
		}
		
		return result;
	}

	public void updateClubInfo(String oldName, String newName, String newDesc, String newLocation) {
		ClubObject oldInfo = getClubByClubName(oldName);
		String id = oldInfo.id;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "UPDATE Clubs SET name = '" + newName + "',"
								+ " description = '" + newDesc + "',"
								+ " location = '" + newLocation + "'"
										+ "WHERE id = '" + id + "';";
			
			//execute SQL query
			st.executeUpdate(sqlQuery);
		} 
		catch (SQLException e) {
			System.err.println("SQL error: updateClubInfo");
		}

	}

	public ArrayList<ClubAdminRequestObject> getAllAdminRequests() {
		ArrayList<ClubAdminRequestObject> requestList = new ArrayList<ClubAdminRequestObject>();
		
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "SELECT * FROM ClubAdminRequests;";
			
			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			
			//convert retrieved rows to clubInfoObject[]
			while (rs.next()) {
				ClubAdminRequestObject clubAdminRequest = new ClubAdminRequestObject(rs.getString(1),
															   rs.getString(2), 
															   rs.getString(3), 
															   rs.getString(4),
															   rs.getString(5),
															   rs.getString(6),
															   rs.getString(7),
															   rs.getString(8));
				requestList.add(clubAdminRequest);
			}
		} 
		catch (SQLException e) {
			System.err.println("SQL error: getAllClubAdminRequests");
		}
		
		return requestList;
	}

	public boolean removeAdminRequest(String id) {
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "DELETE FROM ClubAdminRequests WHERE id = '" + id + "';";
		
			//execute SQL query
			st.executeUpdate(sqlQuery);
			
			result = true;
		}
		catch (SQLException e) {
			System.err.println("SQL error: removeAdminRequest");
		}
		
		return result;
	}

	public boolean setNewClubAdmin(ClubAdminAccountObject clubAdmin) {
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "INSERT INTO ClubAdminAccounts VALUES('" + clubAdmin.id + "',"
														+ " '" + clubAdmin.password + "',"
														+ " '" + clubAdmin.firstName + "',"
														+ " '" + clubAdmin.lastName + "',"
														+ "'" + clubAdmin.email + "',"
														+ "'" + clubAdmin.clubName + "');";
			
			//execute SQL query
			st.executeUpdate(sqlQuery);
			
			result = true;

		} 
		catch (SQLException e) {
			System.err.println("SQL error: setNewClubAdmin");
		}
		return result;
	}

	public ArrayList<ClubRequestObject> getAllClubRequests() {
		ArrayList<ClubRequestObject> requestList = new ArrayList<ClubRequestObject>();
		
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "SELECT * FROM ClubRequests;";
			
			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			
			//convert retrieved rows to clubInfoObject[]
			while (rs.next()) {
				ClubRequestObject clubRequest = new ClubRequestObject(rs.getString(1),
															   rs.getString(2), 
															   rs.getString(3), 
															   rs.getString(4),
															   rs.getString(5));
				requestList.add(clubRequest);
			}
		} 
		catch (SQLException e) {
			System.err.println("SQL error: getAllClubRequests");
		}
		
		return requestList;
	}
	
	public ClubAdminRequestObject getClubAdminRequestByID(String requestId) {
		ClubAdminRequestObject request = null;
		
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "SELECT * FROM ClubAdminRequests WHERE id = '" + requestId + "';";
			
			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			
			rs.next();
		
			request = new ClubAdminRequestObject(rs.getString(1),
											rs.getString(2), 
											rs.getString(3), 
											rs.getString(4),
											rs.getString(5),
											rs.getString(6),
											rs.getString(7),
											rs.getString(8));
			
		} 
		catch (SQLException e) {
			System.err.println("SQL error: getClubAdminRequestByID");
		}
		
		return request;
	}
	
	public ClubRequestObject getClubRequestByID(String id) {
		ClubRequestObject request = null;
		
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "SELECT * FROM ClubRequests WHERE id = '" + id + "';";
			
			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
		
			rs.next();
			
			request = new ClubRequestObject(rs.getString(1),
											rs.getString(2), 
											rs.getString(3), 
											rs.getString(4),
											rs.getString(5));
			
		} 
		catch (SQLException e) {
			System.err.println("SQL error: getClubRequestByID");
		}
		
		return request;
	}

	public void removeClubRequest(String id) {
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "DELETE FROM ClubRequests WHERE id = '" + id + "';";
		
			//execute SQL query
			st.executeUpdate(sqlQuery);
			
		}
		catch (SQLException e) {
			System.err.println("SQL error: removeClubRequest");
		}
	}

	public void setNewClub(ClubObject clubIn, String clubAdminFirstName) {
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "INSERT INTO Clubs VALUES('" + ++currentClubId + "',"
														+ " '" + clubIn.name + "',"
														+ " '" + clubIn.description + "',"
														+ "'" + clubIn.location + "',"
														+ "'" + clubIn.clubAdmin + "');";
			
			//execute SQL query
			st.executeUpdate(sqlQuery);
			
			//set name of the new club to the admin
			String sqlQuery2 = "UPDATE ClubAdminAccounts SET clubName = '" + clubIn.name + "' WHERE firstName = '" + clubAdminFirstName + "';";
			st.executeUpdate(sqlQuery2);
		} 
		catch (SQLException e) {
			System.err.println("SQL error: setNewClub");
		}
	}

	public MainAdminAccountObject getMainAdminAccount(String id, String password) {
		MainAdminAccountObject account = null;
		try {
			Statement st = connection.createStatement();
		
			String sqlQuery = "SELECT * FROM MainAdminAccounts WHERE username = '" + id + "' AND password = '" + password + "';";
			ResultSet rs = st.executeQuery(sqlQuery);
			
			rs.next();
			
			account = new MainAdminAccountObject(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));		
		}
		catch (SQLException e) {
			System.err.println("SQL error: getMainAdminAccount");
		}
		
		return account;
	}
}