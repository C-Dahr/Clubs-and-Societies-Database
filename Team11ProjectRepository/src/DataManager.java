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
 * @author dmccardl
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
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
	private ClubAdminRequests clubAdminRequests;
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
	private MainAdminAccounts mainAdminAccounts;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ClubAdminAccounts clubAdminAccounts;

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
	public boolean setNewAdminRequest(Object adminRequest) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
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
	public ArrayList getClubsFromFilterSearch(ArrayList parameters) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
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
			System.err.println("SQL error: getClubByClubName");
		}
		
		return club;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id
	 * @param password
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object getClubAdminAccount(String id, String password) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param createClubRequest
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean setNewCreateClubRequest(ClubRequestObject clubRequestIn) {
		// begin-user-code
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "INSERT INTO ClubRequests VALUES('" + clubRequestIn.requestID + "',"
														+ " '" + clubRequestIn.clubName + "',"
														+ " '" + clubRequestIn.description + "',"
														+ "'" + clubRequestIn.location + "',"
														+ "'" + clubRequestIn.nameOfRequestSender + "');";
			
			//execute SQL query
			st.executeQuery(sqlQuery);
			
			result = true;

		} 
		catch (SQLException e) {
			System.err.println("SQL error: setNewCreateClubRequest");
		}
		
		return result;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubName
	 * @param formInfo
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void updateClubInfo(String oldName, String newName, String newDesc, String newLocation) {
		// begin-user-code
		// TODO Auto-generated method stub

		ClubObject oldInfo = getClubByClubName(oldName);
		String id = oldInfo.id;
		try {
			Statement st = connection.createStatement();
			
			//create query string
			String sqlQuery = "UPDATE Clubs SET Name = '" + newName + "',"
								+ " Description = '" + newDesc + "',"
								+ " Location = '" + newLocation + "'"
										+ "WHERE id = '" + id + "';";
			
			//execute SQL query
			st.executeQuery(sqlQuery);
		} 
		catch (SQLException e) {
			System.err.println("SQL error: updateClubInfo");
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList getAllAdminRequests() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
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
		return false;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubAdminInfo
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean setNewClubAdmin(Object clubAdminInfo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
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

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param id
	 * @param password
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object getMainAdminAccount(String id, String password) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}