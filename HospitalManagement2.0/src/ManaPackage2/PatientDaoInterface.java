package ManaPackage2;
import ManaPackage2.Patient;
public interface PatientDaoInterface {
	// specifies the behaviour of a class by providing an abstract class
	public boolean insertPatient(Patient p);
	public boolean delete(int id);
	public boolean update(int id, String update, int choice, Patient p);
	public void showAllPatient();
	public boolean showPatientById(int id);
	boolean update1(int id, String update, int ch, Patient p);
	boolean update1(int id, int update, int ch, Patient p);
}