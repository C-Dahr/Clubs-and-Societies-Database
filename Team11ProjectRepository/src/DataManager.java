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
	private ClubAdminRequests clubAdminRequests;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ClubRequests clubRequests;
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
				club.name = rs.getString(1);
				club.description = rs.getString(2);
				club.location = rs.getString(3);
				club.clubAdmin = rs.getString(4);
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
	public Object getClubByClubName(String clubName) {
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
	public ArrayList getClubEventsByClubName(String clubName) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
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
	 * @param clubName
	 * @param formInfo
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNewClubEvent(String clubName, Object formInfo) {
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
	public ArrayList getAllClubRequests() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param suggestedClubName
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean removeClubRequest(String suggestedClubName) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param clubInfo
	 * @return
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean setNewClub(Object clubInfo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return false;
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