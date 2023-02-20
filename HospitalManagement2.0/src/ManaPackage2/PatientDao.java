package ManaPackage2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientDao implements PatientDaoInterface {
	@Override
	public boolean insertPatient(Patient p) {
		boolean flag = false;
		try {
			// Returns a new instance of the provider's class that implements the
			// DBConnection class
			Connection con = DBConnection.createConnection();
			// Inserting Data
			String query = "insert into patient_details2(patient_name,age,sex,address) value(?,?,?,?)";
			// preparedStatement object provides a feature to execute a parameterized query.
			// To return the object of preparedStatement.
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, p.getName());
			pst.setInt(2, p.getAge());
			pst.setString(3, p.getSex());
			pst.setString(4, p.getAddress());
			// execution of Update
			// execution of DML statement update which return int value, count of the
			// effected rows
			pst.executeUpdate();
			flag = true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		// deleting patient details
		boolean flag = false;
		try {
			Connection con = DBConnection.createConnection();
			String query = "delete from patient_details2 where patient_id=" + id;
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(int id, String update, int ch, Patient p) {
		// updating patient details
		int choice = ch;
		boolean flag = false;
		try {
			if (choice == 1) {
				// returns the new instance of the data providers class that implements
				// DBConnection class
				Connection con = DBConnection.createConnection();
				String query = "update patient_details2 set patient_name=? where patient_id=?";
				PreparedStatement ps = con.prepareStatement(query);
				// updating the patient name based on patient id
				ps.setString(1, update);
				ps.setInt(2, id);
				// execution of DML statement update which return int value, count of the
				// effected rows
				ps.executeUpdate();
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update1(int id, int update, int ch, Patient p) {
		int choice = ch;
		boolean flag = false;
		try {
			if (choice == 2) {
				// returns the new instance of the data providers class that implements
				// DBConnection class
				Connection con = DBConnection.createConnection();
				String query = "update patient_details2 set age=? where patient_id=?";
				PreparedStatement ps = con.prepareStatement(query);
				// updating the patient age based on patient id
				ps.setInt(1, update);
				ps.setInt(2, id);
				// execution of DML statement update which return int value, count of the
				// effected rows
				ps.executeUpdate();
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public void showAllPatient() {
		try {
			// getting all patients details
			// returns a new instance of the provider's class that implements the
			// DBConnection class
			Connection con = DBConnection.createConnection();
			// query is used to update the details and run the queries
			String query = "select * from patient_details2";
			// To return the object of the prepared statement
			Statement stmt = con.createStatement();
			// executing result query
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("Patient Id: " + rs.getInt(1) + "\n" + "Name: " + rs.getString(2) + "\n" + "Age: "
						+ rs.getInt(3) + "\n" + "Sex: " + rs.getString(4) + "\n" + "Address: " + rs.getString(5));
				System.out.println("----------------------------------");

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public boolean showPatientById(int id) {
		boolean flag = false;
		try {
			// getting passenger details by passenger id
			// returns a new instance of the provider's class that implements the
			// DBConnection class
			Connection con = DBConnection.createConnection();
			String query = "select * from patient_details2 where patient_id=" + id;
			Statement stmt = con.createStatement();
			// executing the result query
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("Patient Id: " + rs.getInt(1) + "\n" + "Name: " + rs.getString(2) + "\n" + "Age: "
						+ rs.getInt(3) + "\n" + "Sex: " + rs.getString(4) + "\n" + "Address: " + rs.getString(5));
				System.out.println("----------------------------------");
				flag = true;

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean update1(int id, String update, int ch, Patient p) {
		return false;
	}
}