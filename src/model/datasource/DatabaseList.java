package model.datasource;

import java.util.ArrayList;
import java.util.Date;

import entities.Allergy;
import entities.Doctor;
import entities.Medicine;
import entities.MedicineAllergy;
import entities.Password;
import entities.Patient;
import entities.PatientAllergy;
import entities.Prescription;
import entities.Treatment;
import entities.enums.Gender;
import entities.enums.MedicineType;
import entities.enums.Permit;
import entities.enums.ServiceClass;
import entities.enums.Specialization;
import model.backend.Backend;

public class DatabaseList implements Backend
{

	//region attributes
	
	private ArrayList<Allergy> allergies;
	private ArrayList<PatientAllergy> patientAllergies;
	private ArrayList<Doctor> doctors;
	private ArrayList<Password> passwords;
	private ArrayList<Medicine> medicines;
	private ArrayList<Prescription> prescriptions;
	private ArrayList<Patient> patients;
	private ArrayList<MedicineAllergy> medicineAllergies;
	private ArrayList<Treatment> treatments;
	private int AllergyCounter;
	private int MedicineCounter;
	private int TreatmentCounter;
	
	//endregion
	
	/**
	 * 
	 */
	public DatabaseList()
	{
		super();
		allergies = new ArrayList<Allergy>();
		patientAllergies = new ArrayList<PatientAllergy>();
		doctors = new ArrayList<Doctor>();
		medicines = new ArrayList<Medicine>();
		prescriptions = new ArrayList<Prescription>();
		patients = new ArrayList<Patient>();
		medicineAllergies = new ArrayList<MedicineAllergy>();
		passwords = new ArrayList<Password>();
		treatments = new ArrayList<Treatment>();
		AllergyCounter = 0;
		MedicineCounter = 0;
		TreatmentCounter = 0;
	}

	@SuppressWarnings("deprecation") // Date is deprecated, should change Date to GeorgianCalender in next version.
	@Override
	public void setLists()
	{
		try
		{
			this.addAllergy(new Allergy(0, "Paracetamol hypersensitivity",
					"אלרגיה ל פאראסטמול, הרכיב הפעיל של אקמול."));
			this.addAllergy(new Allergy(1, "test",
					"אלרגיה ל פאראסטמול, הרכיב הפעיל של אקמול."));
			
			this.addDoctor(new Doctor(1, "test", "testy", Gender.MALE, new Date(1970, 5, 12), new Date(2002, 7, 1), 
					"moti_kereker321@yahoo.com", (float)130000.0, "050777654", Specialization.FAMILY));
			this.addDoctor(new Doctor(333658712, "מוטי", "קרקר", Gender.MALE, new Date(1970, 5, 12), new Date(2002, 7, 1), 
					"moti_kereker321@yahoo.com", (float)130000.0, "050777654", Specialization.FAMILY));
			
			this.addMedicine(new Medicine(0, "אקמול פוקוס",
					"Microcrystalline cellulose, stearic acid, crospovidone, silicon dioxide, hydroxypropyl"
				+	"methylcellulose, FD&C red #40, FD&C yellow #6, polyethylene glycol 400, titanium dioxide,"
				+	"polysorbate 80, purified water. ",
				"Acetylsalicylic acid 250 mg, Paracetamol 250 mg, Caffeine anhydrous 65 mg",
				MedicineType.PILL_TABLET));
			
			this.addMedicineAllergy(new MedicineAllergy(0, 0));
			
			this.addPassword(new Password(1, "1", Permit.DOCTOR));
			this.addPassword(new Password(333658712, "1234", Permit.DOCTOR));
			
			this.addPatient(new Patient(544812123, "שלומי", "סבבה", Gender.MALE, new Date(1980, 11, 15), "sabamba@gmail.com",
					ServiceClass.GOLD, "035432213"));
			
			//this.addPatientAllergy(patientAllergy);
			
			//this.addPrescription(prescription);
			
			//this.addTreatment(treatment);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	//region addFunctions
	
	@Override
	public void addAllergy(Allergy allergy) throws Exception
	{
		for (Allergy allergyItem : allergies)
			if (allergyItem.equals(allergy))
				throw new Exception("אלרגיה זו כבר קיימת במסד הנתונים!");
		allergy.setAllergyID(AllergyCounter++);
		allergies.add(allergy);
	}

	@Override
	public void addDoctor(Doctor doctor) throws Exception
	{
		for (Doctor doctorItem : doctors)
			if (doctorItem.equals(doctor))
				throw new Exception("דוקטור זה כבר קיים במסד הנתונים!");
		doctors.add(doctor);

	}

	@Override
	public void addMedicine(Medicine medicine) throws Exception
	{
		for (Medicine medicineItem : medicines)
			if (medicineItem.equals(medicine))
				throw new Exception("תרופה זו כבר קיימת במסד הנתונים!");
		medicine.setMedicineID(MedicineCounter++);
		medicines.add(medicine);

	}

	@Override
	public void addMedicineAllergy(MedicineAllergy medicineAllergy)
			throws Exception
	{
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
			if (medicineAllergyItem.equals(medicineAllergy))
				throw new Exception("אלרגיה זו כבר מחוברת לתרופה זו!");
		medicineAllergies.add(medicineAllergy);

	}

	@Override
	public void addPassword(Password password) throws Exception
	{
		for (Password  passwordItem : passwords)
			if (passwordItem.getPasswordUserID() == password.getPasswordUserID()) // user can have only one password
				throw new Exception("למשתמש זה יש כבר סיסמה!");
		 passwords.add(password);

	}

	@Override
	public void addPatient(Patient patient) throws Exception
	{
		for (Patient patientItem : patients)
			if (patientItem.equals(patient))
				throw new Exception("פציינט זה כבר קיים במסד הנתונים!");
		patients.add(patient);

	}

	@Override
	public void addPatientAllergy(PatientAllergy patientAllergy)
			throws Exception
	{
		for (PatientAllergy patientAllergyItem : patientAllergies)
			if (patientAllergyItem.equals(patientAllergy))
				throw new Exception("אלרגיה זו כבר מחוברת לפציינט זה!");
		patientAllergies.add(patientAllergy);

	}

	@Override
	public void addPrescription(Prescription prescription) throws Exception
	{
		for (Prescription prescriptionItem : prescriptions)
			if (prescriptionItem.equals(prescription))
				throw new Exception("תרופה זו כבר ניתנה בטיפול זה!");
		prescriptions.add(prescription);

	}

	@Override
	public void addTreatment(Treatment treatment) throws Exception
	{
		for (Treatment treatmentItem : treatments)
			if (treatmentItem.equals(treatment))
				throw new Exception("טיפול זה כבר קיים במסד הנתונים!");
		treatment.setTreatmentID(TreatmentCounter++);
		treatments.add(treatment);

	}
	//endregion

	//region deleteFuctions
	@Override
	public void deleteAllergy(long allergyID) throws Exception
	{
		deleteMedicineAllergyByAllergy(allergyID);
		deletePatientAllergyByAllergy(allergyID);
		
		for (Allergy allergyItem : allergies)
		{
			if (allergyItem.getAllergyID() == allergyID)
			{
				allergies.remove(allergyItem);
				return;
			}
		}
		
		throw new Exception("לא נמצאה אלרגיה למחיקה.");
	}

	@Override
	public void deleteDoctor(long doctorID) throws Exception
	{
		for (Doctor doctorItem : doctors)
		{
			if (doctorItem.getDoctorID() == doctorID)
			{
				deletePasswordByUserID(doctorID);
				doctors.remove(doctorItem);
				return;
			}
		}
		
		throw new Exception("לא נמצאה דוקטור למחיקה.");

	}

	@Override
	public void deleteMedicine(long medicineID) throws Exception
	{
		deleteMedicineAllergyByMedicine(medicineID);
		deletePrescriptionByMedicine(medicineID);
		
		for (Medicine medicineItem : medicines)
		{
			if (medicineItem.getMedicineID() == medicineID)
			{
				medicines.remove(medicineItem);
				return;
			}
		}
		
		throw new Exception("לא נמצאה תרופה למחיקה.");

	}

	@Override
	public void deletePatient(long patientID) throws Exception
	{
		deletePatientAllergyByPatient(patientID);
		
		for (Patient patientItem : patients)
		{
			if (patientItem.getPatientID() == patientID)
			{
				patients.remove(patientItem);
				return;
			}
		}
		
		throw new Exception("לא נמצאה פציינאט למחיקה.");

	}

	@Override
	public void deleteTreatment(long treatmentID) throws Exception
	{
		deletePrescriptionByTreatment(treatmentID);
		
		for (Treatment treatmentItem : treatments)
		{
			if (treatmentItem.getTreatmentID() == treatmentID)
			{
				treatments.remove(treatmentItem);
				return;
			}
		}
		
		throw new Exception("לא נמצאה טיפול למחיקה.");

	}
	
	@Override
	public void deleteMedicineAllergyByAllergy(long allergyID) throws Exception
	{
		boolean oneDeleted = false;
		
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
		{
			if (medicineAllergyItem.getAllergyID() == allergyID)
			{
				medicineAllergies.remove(medicineAllergyItem);
				oneDeleted = true;
			}
		}
		
		if (!oneDeleted)
			throw new Exception("לא נמצאה קישור תרופה - אלרגיה למחיקה.");
		
	}

	@Override
	public void deleteMedicineAllergyByMedicine(long medicineID)
			throws Exception
	{
		boolean oneDeleted = false;
		
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
		{
			if (medicineAllergyItem.getMedicineID() == medicineID)
			{
				medicineAllergies.remove(medicineAllergyItem);
				oneDeleted = true;
			}
		}
		
		if (!oneDeleted)
			throw new Exception("לא נמצאה קישור תרופה - אלרגיה למחיקה.");
		
	}

	@Override
	public void deletePatientAllergyByPatient(long patientID) throws Exception
	{
		boolean oneDeleted = false;
		
		for (PatientAllergy patientAllergyItem : patientAllergies)
		{
			if (patientAllergyItem.getPatientID() == patientID)
			{
				patientAllergies.remove(patientAllergyItem);
				oneDeleted = true;
			}
		}
		
		if (!oneDeleted)
			throw new Exception("לא נמצאה קישור פציינט - אלרגיה למחיקה.");
		
	}

	@Override
	public void deletePatientAllergyByAllergy(long allergyID) throws Exception
	{
		boolean oneDeleted = false;
		
		for (PatientAllergy patientAllergyItem : patientAllergies)
		{
			if (patientAllergyItem.getAllergyID() == allergyID)
			{
				patientAllergies.remove(patientAllergyItem);
				oneDeleted = true;
			}
		}
		if (!oneDeleted)
			throw new Exception("לא נמצאה קישור פציינט - אלרגיה למחיקה.");
		
	}

	@Override
	public void deletePrescriptionByMedicine(long medicineID) throws Exception
	{
		boolean oneDeleted = false;
		
		for (Prescription prescriptionItem : prescriptions)
		{
			if (prescriptionItem.getPrescriptionMedicineID() == medicineID)
			{
				prescriptions.remove(prescriptionItem);
				oneDeleted = true;
			}
		}
		
		if (!oneDeleted)
			throw new Exception("לא נמצאה קישור תרופה - טיפול למחיקה.");
		
	}

	@Override
	public void deletePrescriptionByTreatment(long treatmentID) throws Exception
	{
		boolean oneDeleted = false;
		
		for (Prescription prescriptionItem : prescriptions)
		{
			if (prescriptionItem.getPrescriptionTreatmentID() == treatmentID)
			{
				prescriptions.remove(prescriptionItem);
				oneDeleted = true;
			}
		}
		
		if (!oneDeleted)
			throw new Exception("לא נמצאה קישור תרופה - טיפול למחיקה.");
		
	}
	
	private void deletePasswordByUserID(long userID) throws Exception
	{
		for (Password passwordItem : passwords)
		{
			if (passwordItem.getPasswordUserID() == userID)
			{
				passwords.remove(passwordItem);
				return;
			}
		}
		
		throw new Exception("לא נמצאה סיסמה למחיקה.");

	}
	
	//endregion

	//region updateFunctions
	@Override
	public void updateAllergy(Allergy allergy) throws Exception
	{
		for (Allergy allergyItem : allergies)
			if (allergy.equals(allergyItem))
			{
				allergyItem.setAllergyName(allergy.getAllergyName());
				allergyItem.setAllergyNotes(allergy.getAllergyNotes());
				return;
			}
		
		throw new Exception("לא נמצאה אלרגיה לעידכון");
	}

	@Override
	public void updateDoctor(Doctor doctor) throws Exception
	{
		for (Doctor doctorItem : doctors)
			if (doctor.equals(doctorItem))
			{
				doctorItem.setDoctorDoB(doctor.getDoctorDoB());
				doctorItem.setDoctorDoJ(doctor.getDoctorDoJ());
				doctorItem.setDoctorEmailAdress(doctor.getDoctorEmailAdress());
				doctorItem.setDoctorFirstName(doctor.getDoctorFirstName());
				doctorItem.setDoctorGender(doctor.getDoctorGender());
				doctorItem.setDoctorLastName(doctor.getDoctorLastName());
				doctorItem.setDoctorPhoneNumber(doctor.getDoctorPhoneNumber());
				doctorItem.setDoctorSalary(doctor.getDoctorSalary());
				doctorItem.setDoctorSpecialization(doctor.getDoctorSpecialization());
				return;
			}
		
		throw new Exception("לא נמצאה דוקטור לעידכון");

	}

	@Override
	public void updateMedicine(Medicine medicine) throws Exception
	{
		for (Medicine medicineItem : medicines)
			if (medicine.equals(medicineItem))
			{
				medicineItem.setMedicineActiveIngredients(medicine.getMedicineActiveIngredients());
				medicineItem.setMedicineIngredients(medicine.getMedicineIngredients());
				medicineItem.setMedicineName(medicine.getMedicineName());
				medicineItem.setMedicineType(medicine.getMedicineType());
				return;
			}
		
		throw new Exception("לא נמצאה תרופה לעידכון");
	}

	@Override
	public void updateMedicineAllergy(MedicineAllergy medicineAllergy)
			throws Exception
	{
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
			if (medicineAllergy.equals(medicineAllergyItem))
			{
				//add updated attributes here, if any.
				return;
			}
		
		throw new Exception("לא נמצאה קישור תרופה - אלרגיה לעידכון");

	}

	@Override
	public void updatePassword(Password oldPassword, String newPassword) throws Exception
	{
		for (Password passwordItem : passwords)
			if (oldPassword.equals(passwordItem))
			{
				passwordItem.setPasswordWord(newPassword);
				return;
			}
		
		throw new Exception("סיסמה שגויה");

	}
	
	@Override
	public void updatePassword(Password oldPassword, String newPassword, Permit permit) throws Exception
	{
		for (Password passwordItem : passwords)
			if (oldPassword.equals(passwordItem))
			{	
				if (oldPassword.getPasswordPermit() != Permit.ADMIN || // do not allow change to admin's premision.
						permit != Permit.ADMIN)						// do not allow other users to turn admins.
					passwordItem.setPasswordPermit(permit);
				else
					throw new Exception("שינוי הרשאות (ל)אדמין אסור.");
				
				passwordItem.setPasswordWord(newPassword);
				
				return;
			}
		
		throw new Exception("סיסמה שגויה");

	}

	@Override
	public void updatePatient(Patient patient) throws Exception
	{
		for (Patient patientItem : patients)
			if (patient.equals(patientItem))
			{
				patientItem.setPatientGender(patient.getPatientGender());
				patientItem.setPatientDoB(patient.getPatientDoB());
				patientItem.setPatientEmailAdress(patient.getPatientEmailAdress());
				patientItem.setPatientFirstName(patient.getPatientFirstName());
				patientItem.setPatientLastName(patient.getPatientFirstName());
				patientItem.setPatientPhoneNumber(patient.getPatientPhoneNumber());
				patientItem.setPatientServiceClass(patient.getPatientServiceClass());
				return;
			}
		
		throw new Exception("לא נמצא פציינט לעידכון");

	}

	@Override
	public void updatePatientAllergy(PatientAllergy patientAllergy)
			throws Exception
	{
		for (PatientAllergy patientAllergyItem : patientAllergies)
			if (patientAllergy.equals(patientAllergyItem))
			{
				//add updated attributes here, if any.
				return;
			}
		
		throw new Exception("לא נמצא קישור פציינט - אלרגיה לעידכון");

	}

	@Override
	public void updatePrescription(Prescription prescription) throws Exception
	{
		for (Prescription prescriptionItem : prescriptions)
			if (prescription.equals(prescriptionItem))
			{
				//add updated attributes here, if any.
				return;
			}
		
		throw new Exception("לא נמצא קישור תרופה - טיפול לעידכון");

	}

	@Override
	public void updateTreatment(Treatment treatment) throws Exception
	{
		for (Treatment treatmentItem : treatments)
			if (treatment.equals(treatmentItem))
			{
				treatmentItem.setTreatmentDate(treatment.getTreatmentDate());
				treatmentItem.setTreatmentDoctorID(treatment.getTreatmentDoctorID());
				treatmentItem.setTreatmentDone(treatment.isTreatmentDone());
				treatmentItem.setTreatmentLocation(treatment.getTreatmentLocation());
				treatmentItem.setTreatmentPatientID(treatment.getTreatmentPatientID());
				treatmentItem.setTreatmentSummary(treatment.getTreatmentSummary());
				return;
			}
		
		throw new Exception("לא נמצא קישור טיפול לעידכון");

	}
	//endregion

	//region getFunctions
	@Override
	public ArrayList<Allergy> getAllergyList() throws Exception
	{
		if (allergies.size() != 0)
			return allergies;
		else
			throw new Exception("רשימת האלרגיות ריקה!");
	}

	@Override
	public ArrayList<Allergy> getAllergyByPatientList(long patientID)
			throws Exception
	{
		ArrayList<Allergy> allergyByPatient = new ArrayList<Allergy>();
		for (PatientAllergy patientAllergyItem : patientAllergies)
			if (patientAllergyItem.getPatientID() == patientID)
				for (Allergy allergyItem : allergies)
					if (allergyItem.getAllergyID() == patientAllergyItem.getAllergyID())
						allergyByPatient.add(allergyItem);
		
		return allergyByPatient; // even if list is empty, it is acceptable result.
	}
	
	@Override
	public ArrayList<Allergy> getAllergyByMedicineList(long medicineID)
			throws Exception
	{
		ArrayList<Allergy> allergyByPatient = new ArrayList<Allergy>();
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
			if (medicineAllergyItem.getMedicineID() == medicineID)
				for (Allergy allergyItem : allergies)
					if (allergyItem.getAllergyID() == medicineAllergyItem.getAllergyID())
						allergyByPatient.add(allergyItem);
		
		return allergyByPatient; // even if list is empty, it is acceptable result.
	}

	@Override
	public ArrayList<Doctor> getDoctorList() throws Exception
	{
		if (doctors.size() != 0)
			return doctors;
		else
			throw new Exception("רשימת הדוקטורים ריקה!");
	}

	@Override
	public ArrayList<Medicine> getMedicineList() throws Exception
	{
		if (medicines.size() != 0)
			return medicines;
		else
			throw new Exception("רשימת התרופות ריקה!");
	}

	@Override
	public ArrayList<Medicine> getMedicineByTreatmentList(long treatmentID)
			throws Exception
	{
		ArrayList<Medicine> medicineByTreatment = new ArrayList<Medicine>();
		for (Prescription prescriptionItem : prescriptions)
			if (prescriptionItem.getPrescriptionTreatmentID() == treatmentID)
				for (Medicine medicineItem : medicines)
					if (medicineItem.getMedicineID() == prescriptionItem.getPrescriptionMedicineID())
						medicineByTreatment.add(medicineItem);
		
		return medicineByTreatment; // even if list is empty, it is acceptable result.
	}

	@Override
	public ArrayList<Patient> getPatientList() throws Exception
	{
		if (patients.size() != 0)
			return patients;
		else
			throw new Exception("רשימת הפציינטים ריקה!");
	}

	@Override
	public MedicineAllergy getConectorMedicineAllergy(long medicineID, long allergyID)
			throws Exception
	{
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
			if (medicineAllergyItem.getAllergyID() == allergyID &&
					medicineAllergyItem.getMedicineID() == medicineID)
				return medicineAllergyItem;
		
		throw new Exception("אין קישור בין תרופה זו ואלרגיה זו!");


	}

	@Override
	public PatientAllergy getConectorPatientAllergy(long patientID, long allergyID)
			throws Exception
	{
		for (PatientAllergy patientAllergyItem : patientAllergies)
			if (patientAllergyItem.getAllergyID() == allergyID &&
				patientAllergyItem.getPatientID() == patientID)
				return patientAllergyItem;
		
		throw new Exception("אין קישור בין פציינט זה ואלרגיה זו!");

	}

	@Override
	public Prescription getConectorPrescription(long treatmentID, long medicineID)
			throws Exception
	{
		for (Prescription prescriptionItem : prescriptions)
			if (prescriptionItem.getPrescriptionTreatmentID() == treatmentID &&
					prescriptionItem.getPrescriptionMedicineID() == medicineID)
				return prescriptionItem;
		
		throw new Exception("אין קישור בין תרופה זו וטיפול זה!");

	}
	//endregion

	@Override
	public Permit checkPassword(long loginID, String password) throws Exception
	{
		for (Password passwordItem : passwords)
			if (passwordItem.getPasswordUserID() == loginID &&
				passwordItem.getPasswordWord().equals(password))
				return passwordItem.getPasswordPermit();
		
		throw new Exception("שם משתמש או סיסמה שגויה!");
	}

	@Override
	public boolean isEmpty() throws Exception
	{
		return (doctors.size() == 0)? true : false;
	}

}
