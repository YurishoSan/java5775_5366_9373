package model.datasource;

import java.util.ArrayList;

import entities.Allergy;
import entities.Doctor;
import entities.Medicine;
import entities.MedicineAllergy;
import entities.Password;
import entities.Patient;
import entities.PatientAllergy;
import entities.Prescription;
import entities.Treatment;
import entities.enums.Permit;
import model.backend.Backend;

public class DatabaseList implements Backend
{

	public DatabaseList()
	{
		// TODO Auto-generated constructor stub
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
				throw new Exception("אלרגיה זו כבר מחוברת לתרופה זו!");
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
		treatment.setMedicineID(TreatmentCounter++);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMedicine(long medicineID) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePassword(long passwordID) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePatient(long patientID) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTreatment(long treatmentID) throws Exception
	{
		// TODO Auto-generated method stub

	}
	
	@Override
	public void deleteMedicineAllergyByAllergy(long allergyID) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMedicineAllergyByMedicine(long medicineID)
			throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePatientAllergyByPatient(long patientID) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePatientAllergyByAllergy(long medicineID) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTreatmetByMedicine(long medicineID) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTreatmetByTreatment(long teatmentID) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	
	//endregion

	//region updateFunctions
	@Override
	public void updateAllergy(Allergy allergy) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDoctor(Doctor doctor) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMedicine(Medicine medicine) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMedicineAllergy(MedicineAllergy medicineAllergy)
			throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(Password password) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePatient(Patient patient) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePatientAllergy(PatientAllergy patientAllergy)
			throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePrescription(Prescription prescription) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTreatment(Treatment treatment) throws Exception
	{
		// TODO Auto-generated method stub

	}
	//endregion

	//region getFunctions
	@Override
	public ArrayList<Allergy> getAllergyList() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Allergy> getAllergyByPatientList(long patientID)
			throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Doctor> getDoctorList() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Medicine> getMedicineList() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Medicine> getMedicineByTreatmentList(long treatmentID)
			throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Patient> getPatientList() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Treatment> getTreatmentByDoctorList(long doctorID)
			throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getConectorMedicineAllergy(long MedicineID, long AllergyID)
			throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void getConectorPatientAllergy(long PatientID, long AllergyID)
			throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void getConectorPrescription(long TreatmentID, long MedicineID)
			throws Exception
	{
		// TODO Auto-generated method stub

	}
	//endregion

	@Override
	public Permit checkPassword(long loginID, long password) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
