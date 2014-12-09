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
import entities.enums.Specialization;
import model.backend.Backend;

public class DatabaseList implements Backend
{

	//region attributes
	
	private ArrayList<Allergy> allergies= new ArrayList<Allergy>();
	private ArrayList<PatientAllergy> patientAllergies=new ArrayList<PatientAllergy>();
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>() ;
	private ArrayList<Password> passwords= new ArrayList<Password>();
	private ArrayList<Medicine> medicines= new ArrayList<Medicine>();
	private ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
	private ArrayList<Patient> patients =new ArrayList<Patient>() ;
	private ArrayList<MedicineAllergy> medicineAllergies = new ArrayList<MedicineAllergy>();
	private ArrayList<Treatment> treatments =new ArrayList<Treatment>();
	private int AllergyCounter=0;
	private int MedicineCounter=0;
	private int TreatmentCounter=0;
	
	//endregion
	
	@SuppressWarnings("deprecation") // Date is deprecated, should change Date to GeorgianCalender in next version.
	public void setLists()
	{
		try
		{
			this.addAllergy(new Allergy(0, "Paracetamol hypersensitivity",
					"������ � ���������, ����� ����� �� �����."));
			
			this.addDoctor(new Doctor(333658712, "����", "����", Gender.MALE, new Date(1970, 5, 12), new Date(2002, 7, 1), 
					"moti_kereker321@yahoo.com", (float)130000.0, "050777654", Specialization.FAMILY));
			
			this.addMedicine(new Medicine(0, "����� �����",
					"Microcrystalline cellulose, stearic acid, crospovidone, silicon dioxide, hydroxypropyl"
				+	"methylcellulose, FD&C red #40, FD&C yellow #6, polyethylene glycol 400, titanium dioxide,"
				+	"polysorbate 80, purified water. "
				, "Acetylsalicylic acid 250 mg, Paracetamol 250 mg, Caffeine anhydrous 65 mg",
				MedicineType.PILL_TABLET, new Date(2016, 3, 1)));
			
			this.addMedicineAllergy(new MedicineAllergy(0, 0));
			
			/*this.addPassword(password);
			
			this.addPatient(patient);
			
			this.addPatientAllergy(patientAllergy);
			
			this.addPrescription(prescription);
			
			this.addTreatment(treatment);
			*/
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
				throw new Exception("������ �� ��� ����� ���� �������!");
		allergy.setAllergyID(AllergyCounter++);
		allergies.add(allergy);
	}

	@Override
	public void addDoctor(Doctor doctor) throws Exception
	{
		for (Doctor doctorItem : doctors)
			if (doctorItem.equals(doctor))
				throw new Exception("������ �� ��� ���� ���� �������!");
		doctors.add(doctor);

	}

	@Override
	public void addMedicine(Medicine medicine) throws Exception
	{
		for (Medicine medicineItem : medicines)
			if (medicineItem.equals(medicine))
				throw new Exception("����� �� ��� ����� ���� �������!");
		medicine.setMedicineID(MedicineCounter++);
		medicines.add(medicine);

	}

	@Override
	public void addMedicineAllergy(MedicineAllergy medicineAllergy)
			throws Exception
	{
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
			if (medicineAllergyItem.equals(medicineAllergy))
				throw new Exception("������ �� ��� ������ ������ ��!");
		medicineAllergies.add(medicineAllergy);

	}

	@Override
	public void addPassword(Password password) throws Exception
	{
		for (Password  passwordItem : passwords)
			if (passwordItem.getPasswordUserID() == password.getPasswordUserID()) // user can have only one password
				throw new Exception("������ �� ��� ������ ������ ��!");
		 passwords.add(password);

	}

	@Override
	public void addPatient(Patient patient) throws Exception
	{
		for (Patient patientItem : patients)
			if (patientItem.equals(patient))
				throw new Exception("������ �� ��� ���� ���� �������!");
		patients.add(patient);

	}

	@Override
	public void addPatientAllergy(PatientAllergy patientAllergy)
			throws Exception
	{
		for (PatientAllergy patientAllergyItem : patientAllergies)
			if (patientAllergyItem.equals(patientAllergy))
				throw new Exception("������ �� ��� ������ ������� ��!");
		patientAllergies.add(patientAllergy);

	}

	@Override
	public void addPrescription(Prescription prescription) throws Exception
	{
		for (Prescription prescriptionItem : prescriptions)
			if (prescriptionItem.equals(prescription))
				throw new Exception("����� �� ��� ����� ������ ��!");
		prescriptions.add(prescription);

	}

	@Override
	public void addTreatment(Treatment treatment) throws Exception
	{
		for (Treatment treatmentItem : treatments)
			if (treatmentItem.equals(treatment))
				throw new Exception("����� �� ��� ���� ���� �������!");
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
		
		throw new Exception("�� ����� ������ ������.");
	}

	@Override
	public void deleteDoctor(long doctorID) throws Exception
	{
		for (Doctor doctorItem : doctors)
		{
			if (doctorItem.getDoctorID() == doctorID)
			{
				doctors.remove(doctorItem);
				return;
			}
		}
		
		throw new Exception("�� ����� ������ ������.");

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
		
		throw new Exception("�� ����� ����� ������.");

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
		
		throw new Exception("�� ����� ������� ������.");

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
		
		throw new Exception("�� ����� ����� ������.");

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
			throw new Exception("�� ����� ����� ����� - ������ ������.");
		
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
			throw new Exception("�� ����� ����� ����� - ������ ������.");
		
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
			throw new Exception("�� ����� ����� ������ - ������ ������.");
		
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
			throw new Exception("�� ����� ����� ������ - ������ ������.");
		
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
			throw new Exception("�� ����� ����� ����� - ����� ������.");
		
	}

	@Override
	public void deletePrescriptionByTreatment(long teatmentID) throws Exception
	{
		boolean oneDeleted = false;
		
		for (Prescription prescriptionItem : prescriptions)
		{
			if (prescriptionItem.getPrescriptionTreatmentID() == teatmentID)
			{
				prescriptions.remove(prescriptionItem);
				oneDeleted = true;
			}
		}
		
		if (!oneDeleted)
			throw new Exception("�� ����� ����� ����� - ����� ������.");
		
	}
	
	@Override
	public void deletePasswordByUserID(long userID) throws Exception
	{
		for (Password passwordItem : passwords)
		{
			if (passwordItem.getPasswordUserID() == userID)
			{
				passwords.remove(passwordItem);
				return;
			}
		}
		
		throw new Exception("�� ����� ����� ������.");

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
		
		throw new Exception("�� ����� ������ �������");
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
		
		throw new Exception("�� ����� ������ �������");

	}

	@Override
	public void updateMedicine(Medicine medicine) throws Exception
	{
		for (Medicine medicineItem : medicines)
			if (medicine.equals(medicineItem))
			{
				medicineItem.setMedicineActiveIngredients(medicine.getMedicineActiveIngredients());
				medicineItem.setMedicineExpDate(medicine.getMedicineExpDate());
				medicineItem.setMedicineIngredients(medicine.getMedicineIngredients());
				medicineItem.setMedicineName(medicine.getMedicineName());
				medicineItem.setMedicineType(medicine.getMedicineType());
				return;
			}
		
		throw new Exception("�� ����� ����� �������");
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
		
		throw new Exception("�� ����� ����� ����� - ������ �������");

	}

	@Override
	public void updatePassword(Password password, String newPassword) throws Exception
	{
		for (Password passwordItem : passwords)
			if (password.equals(passwordItem))
			{
				passwordItem.setPasswordWord(newPassword);
				return;
			}
		
		throw new Exception("����� �����");

	}
	
	@Override
	public void updatePassword(Password oldPassword, String newPassword, Permit permit) throws Exception
	{
		for (Password passwordItem : passwords)
			if (oldPassword.equals(passwordItem))
			{
				passwordItem.setPasswordWord(newPassword);
				
				if (oldPassword.getPasswordPermit() != Permit.ADMIN || // do not allow change to admin's premision.
						permit != Permit.ADMIN)						// do not allow other users to turn admins.
					passwordItem.setPasswordPermit(permit);
				else
					throw new Exception("����� ������ (�)����� ����.");
				return;
			}
		
		throw new Exception("����� �����");

	}

	@Override
	public void updatePatient(Patient patient) throws Exception
	{
		for (Patient patientItem : patients)
			if (patient.equals(patientItem))
			{
				patientItem.setHumanGender(patient.getPatientGender());
				patientItem.setPatientDoB(patient.getPatientDoB());
				patientItem.setPatientEmailAdress(patient.getPatientEmailAdress());
				patientItem.setPatientFirstName(patient.getPatientFirstName());
				patientItem.setPatientLastName(patient.getPatientFirstName());
				patientItem.setPatientPhoneNumber(patient.getPatientPhoneNumber());
				patientItem.setPatientServiceClass(patient.getPatientServiceClass());
				return;
			}
		
		throw new Exception("�� ���� ������ �������");

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
		
		throw new Exception("�� ���� ����� ������ - ������ �������");

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
		
		throw new Exception("�� ���� ����� ����� - ����� �������");

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
		
		throw new Exception("�� ���� ����� ����� �������");

	}
	//endregion

	//region getFunctions
	@Override
	public ArrayList<Allergy> getAllergyList() throws Exception
	{
		if (allergies.size() != 0)
			return allergies;
		else
			throw new Exception("����� �������� ����!");
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
	public ArrayList<Doctor> getDoctorList() throws Exception
	{
		if (doctors.size() != 0)
			return doctors;
		else
			throw new Exception("����� ��������� ����!");
	}

	@Override
	public ArrayList<Medicine> getMedicineList() throws Exception
	{
		if (medicines.size() != 0)
			return medicines;
		else
			throw new Exception("����� ������� ����!");
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
			throw new Exception("����� ��������� ����!");
	}

	@Override
	public MedicineAllergy getConectorMedicineAllergy(long medicineID, long allergyID)
			throws Exception
	{
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
			if (medicineAllergyItem.getAllergyID() == allergyID &&
					medicineAllergyItem.getMedicineID() == medicineID)
				return medicineAllergyItem;
		
		throw new Exception("��� ����� ��� ����� �� ������� ��!");


	}

	@Override
	public PatientAllergy getConectorPatientAllergy(long patientID, long allergyID)
			throws Exception
	{
		for (PatientAllergy patientAllergyItem : patientAllergies)
			if (patientAllergyItem.getAllergyID() == allergyID &&
				patientAllergyItem.getPatientID() == patientID)
				return patientAllergyItem;
		
		throw new Exception("��� ����� ��� ������ �� ������� ��!");

	}

	@Override
	public Prescription getConectorPrescription(long treatmentID, long medicineID)
			throws Exception
	{
		for (Prescription prescriptionItem : prescriptions)
			if (prescriptionItem.getPrescriptionTreatmentID() == treatmentID &&
					prescriptionItem.getPrescriptionMedicineID() == medicineID)
				return prescriptionItem;
		
		throw new Exception("��� ����� ��� ����� �� ������ ��!");

	}
	//endregion

	@Override
	public Permit checkPassword(long loginID, String password) throws Exception
	{
		for (Password passwordItem : passwords)
			if (passwordItem.getPasswordUserID() == loginID &&
				passwordItem.getPasswordWord() == password)
				return passwordItem.getPasswordPermit();
		
		throw new Exception("�� ����� �� ����� �����!");
	}

}
