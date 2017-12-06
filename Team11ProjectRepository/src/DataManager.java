/**
 * 
 */
import java.sql.*;
import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author tharvey2
 */
public class DataManager {
	Connection connection = null;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ClubObject clubs;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ClubEvents clubEvents;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ClubAdminRequestObject clubAdminRequests;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ClubRequestObject clubRequests;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private MainAdminAccountObject mainAdminAccounts;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ClubAdminAccountObject clubAdminAccounts;

	/*
	 * Constructor
	 */
	public DataManager() {
		 try {
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	     } catch (Exception e) {
	      System.err.println(e.toString());
	     }
		String url = "jdbc:mysql://cs2043.cs.unb.ca:3306/dmccardl";
		try {
		connection = DriverManager.getConnection(url, "dmccardl", "ZZ3Af3RC");
		} catch (SQLException e) {
		System.err.println("Database connection error.");
		}
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param adminRequest
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean setNewAdminRequest(ClubAdminRequestObject adminRequest) {
		// begin-user-code
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "INSERT INTO ClubAdminRequests VALUES('" + adminRequest.requestID + "',"
														+ " '" + adminRequest.nameOfRequestSender + "',"
														+ " '" + adminRequest.id + "',"
														+ " '" + adminRequest.password + "',"
														+ "'" + adminRequest.firstName + "',"
														+ "'" + adminRequest.lastName + "',"
														+ "'" + adminRequest.email + "',"
														+ "'" + adminRequest.clubName + "');";
			
			//execute SQL query
			st.executeQuery(sqlQuery);
			
			result = true;

		} 
		catch (SQLException e) {
			System.err.println("SQL error: setNewClubAdminRequest");
		}
		return result;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<ClubObject> getAllClubs() {
		// begin-user-code
		// TODO Auto-generated method stub
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
	

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param parameters
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<ClubObject> getClubsFromFilterSearch(ArrayList<String> keywords) {
		// begin-user-code
		// TODO Auto-generated method stub
		ArrayList<ClubObject> clubList = new ArrayList<ClubObject>();
		try {
			Statement st = connection.createStatement();
			
			String sqlQuery = "SELECT * FROM Clubs WHERE ";
			for(int i = 0; i < keywords.size(); i++) {
				if (i < keywords.size() - 1) 
					sqlQuery += "Name LIKE '%" + keywords.get(i) + "%' OR Description LIKE '%" + keywords.get(i) + "%' OR ";
				else
					sqlQuery += "Name LIKE '%" + keywords.get(i) + "%' OR Description LIKE '%" + keywords.get(i) + "%';";
			}
			
			ResultSet rs = st.executeQuery(sqlQuery);
			
			while (rs.next()) {
				ClubObject club = new ClubObject();
				club.name = rs.getString(1);
				club.description = rs.getString(2);
				club.location = rs.getString(3);
				club.clubAdmin = rs.getString(4);
				clubList.add(club);				
			}
		} catch (SQLException e) {
			System.err.println("SQL error: getClubsFromFilterSearch");
		}
		
		return clubList;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ClubObject getClubByClubName(String clubName) {
		// begin-user-code
		// TODO Auto-generated method stub
		ClubObject club = new ClubObject();
		
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "SELECT * FROM Clubs WHERE Name = '" + clubName + "';";
			
			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			
			club.id = rs.getString(1);
			club.name = rs.getString(2);
			club.description = rs.getString(3);
			club.location = rs.getString(4);
			club.clubAdmin = rs.getString(5);
		} 
		catch (SQLException e) {
			System.err.println("SQL error: getAllClubs");
		}
		
		return club;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	public ClubAdminAccountObject getClubAdminAccount(String id, String password) {
		// begin-user-code
		// TODO Auto-generated method stub
		ClubAdminAccountObject account = null;
		try {
			Statement st = connection.createStatement();
		
			String sqlQuery = "SELECT * FROM ClubAdminAccounts WHERE id = '" + id + "' AND password = '" + password + "';";
			ResultSet rs = st.executeQuery(sqlQuery);
			
			account = new ClubAdminAccountObject(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));		
		}
		catch (SQLException e) {
			System.err.println("SQL error: getClubAdminAccount");
		}
		
		return account;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param createClubRequest
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean setNewCreateClubRequest(Object createClubRequest) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubName
	 * @param formInfo
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void updateClubInfo(String clubName, HashMap formInfo) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<ClubAdminRequestObject> getAllAdminRequests() {
		// begin-user-code
		// TODO Auto-generated method stub
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
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean removeAdminRequest(String id) {
		// begin-user-code
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "DELETE FROM ClubAdminRequests WHERE requestId = '" + id + "';";
		
			//execute SQL query
			st.executeQuery(sqlQuery);
			
			result = true;
		}
		catch (SQLException e) {
			System.err.println("SQL error: removeAdminRequest");
		}
		
		return result;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubAdminInfo
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean setNewClubAdmin(ClubAdminAccountObject clubAdmin) {
		// begin-user-code
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "INSERT INTO ClubAdmins VALUES('" + clubAdmin.id + "',"
														+ " '" + clubAdmin.password + "',"
														+ " '" + clubAdmin.firstName + "',"
														+ " '" + clubAdmin.lastName + "',"
														+ "'" + clubAdmin.email + "',"
														+ "'" + clubAdmin.club + "');";
			
			//execute SQL query
			st.executeQuery(sqlQuery);
			
			result = true;

		} 
		catch (SQLException e) {
			System.err.println("SQL error: setNewClubAdmin");
		}
		return result;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<ClubRequestObject> getAllClubRequests() {
		// begin-user-code
		// TODO Auto-generated method stub
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
		// end-user-code
	}
	
	public ClubAdminRequestObject getClubAdminRequestByID(String requestId) {
		
		ClubAdminRequestObject request = null;
		
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "SELECT * FROM ClubAdminRequests WHERE id = '" + requestId + "';";
			
			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
		
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

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param suggestedClubName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean removeClubRequest(String id) {
		// begin-user-code
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "DELETE FROM ClubRequests WHERE id = '" + id + "';";
		
			//execute SQL query
			st.executeQuery(sqlQuery);
			
			result = true;
		}
		catch (SQLException e) {
			System.err.println("SQL error: removeClubRequest");
		}
		
		return result;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubInfo
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean setNewClub(ClubObject clubIn) {
		// begin-user-code
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "INSERT INTO Clubs VALUES('" + clubIn.id + "',"
														+ " '" + clubIn.name + "',"
														+ " '" + clubIn.description + "',"
														+ " '" + clubIn.name + "',"
														+ "'" + clubIn.location + "',"
														+ "'" + clubIn.clubAdmin + "');";
			
			//execute SQL query
			st.executeQuery(sqlQuery);
			
			result = true;

		} 
		catch (SQLException e) {
			System.err.println("SQL error: setNewClub");
		}
		
		return result;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean removeClub(String clubName) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
		// end-user-code
	}

	public MainAdminAccountObject getMainAdminAccount(String id, String password) {
		// begin-user-code
		// TODO Auto-generated method stub
		MainAdminAccountObject account = null;
		try {
			Statement st = connection.createStatement();
		
			String sqlQuery = "SELECT * FROM MainAdminAccounts WHERE id = '" + id + "' AND password = '" + password + "';";
			ResultSet rs = st.executeQuery(sqlQuery);
			
			account = new MainAdminAccountObject(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));		
		}
		catch (SQLException e) {
			System.err.println("SQL error: getMainAdminAccount");
		}
		
		return account;
			
		// end-user-code
	}
}