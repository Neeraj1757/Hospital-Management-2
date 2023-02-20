package ManaPackage2;

import java.util.Scanner;

import ManaPackage2.Patient;
import ManaPackage2.PatientDao;
import ManaPackage2.PatientDaoInterface;

public class Main {
	public static void main(String[] args) {
		// Scanner class to accept data from the user
		Scanner sc = new Scanner(System.in);
		// Object Creation of PatientDaoInterface
		// dao refers to the Data Access Object
		PatientDaoInterface dao = new PatientDao();
		// The main interface of the Hospital Management Application
		System.out.println("Welcome to Hospital Management Application");
		while (true) {
			System.out.println("\n1.Add New Patient" + "\n2.Display All Patients Details" + "\n3.Get patient details based on id"
					+ "\n4.Delete Patient" + "\n5.Edit Patient details" + "\n6.Quit Application");
			System.out.println("Enter choice");
			int ch = sc.nextInt();
			// Using switch cases for different modules of application
			switch (ch) {
			case 1:
				// Case 1 for adding a new patient
				System.out.println("Add New Patient");
				System.out.println("Enter Patient Name");
				String name = sc.next();
				System.out.println("Enter Age");
				int age = sc.nextInt();
				if (age<=100) {
				System.out.println("Enter Sex(M/F)");
				String sex = sc.next();
							if (sex.equals("M")||sex.equals("F")){
							System.out.println("Enter Address");
							String address = sc.next();
							// Creating objects for patient along with parameters
							Patient pt = new Patient(name, age, sex, address);
							boolean ans = dao.insertPatient(pt);
								if (ans)
								System.out.println("Patient Added Successfully!");
								else
								System.out.println("Something went wrong, Please try again.");
							}
							else {
							System.err.println("Something went wrong, Please enter valid sex(M/F)");
							}
				}
				else {
					System.err.println("Something went wrong, Please enter valid age!");
				}

				break;
			case 2:
				// Case 2 for displaying all the patients details
				System.out.println("Display All Patients details ");
				dao.showAllPatient();

				break;
			case 3:
				// Case 3 for displaying the patients details based on patient id
				System.out.println("Get Patient details based on id");
				System.out.println("Enter Patient id");
				int id = sc.nextInt();
				boolean f = dao.showPatientById(id);
				if (!f)
					System.err.println("Patient with this id does not exist, ENTER A VALID ID");

				break;
			case 4:
				// Case 4 for deleting the patient details from the database
				System.out.println("Delete Patient");
				System.out.println("Enter id to delete");
				int id2 = sc.nextInt();
				boolean ff = dao.delete(id2);
				if (ff)
					System.out.println("Record deleted successfully!");
				else
					System.err.println("Something went wrong, Please try again.");
				break;
			case 5:
				// Case 5 for updating the patient details
				System.out.println("Edit patient details");
				System.out.println("\n1.Edit name\n2.Edit age");
				System.out.println("Enter 1 or 2");
				int choice = sc.nextInt();
				if (choice == 1) {
					System.out.println("Enter Id");
					int id3 = sc.nextInt();
					System.out.println("Enter New Name");
					String pname = sc.next();
					Patient ptd = new Patient();
					ptd.setName(pname);
					boolean flag = dao.update(id3, pname, choice, ptd);		
					if (flag) {
						System.out.println("Name updated successfully");
					}
					else {
						System.err.println("Something went wrong, Please try again.");
					}
				}
				// Updating patient age by id
				else if (choice == 2) {
					System.out.println("Enter Id");
					int id3 = sc.nextInt();
					System.out.println("Enter New Age");
					int age1 = sc.nextInt();
					Patient ptd = new Patient();
					ptd.setAge(age1);
					boolean flag = dao.update1(id3 ,age1, choice, ptd);
					if (flag) {
						System.out.println("Age updated successfully");
					}
					else {
						System.err.println("Something went wrong, Please try again.");
					}
				}
				break;
			case 6:
				// Case 6 for terminating
				System.out.println("Thank You for using Hospital Management Application!");
				System.exit(0);
			default:
				System.err.println("Please Enter valid choice.");
			}
		}

	}
}