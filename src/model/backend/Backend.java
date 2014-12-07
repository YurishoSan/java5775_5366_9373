package model.backend;

import java.util.ArrayList;

import entities.*;
import entities.enums.*;

public interface Backend
{
	//region addFunctions
	
	public void addAllergy (Allergy allergy) throws Exception;
	public void addDoctor (Doctor doctor) throws Exception;
	public void addMedicine (Medicine medicine) throws Exception;
	public void addMedicineAllergy (MedicineAllergy medicineAllergy) throws Exception;
	public void addPassword (Password password) throws Exception;
	public void addPatient (Patient patient) throws Exception;
	public void addPatientAllergy (PatientAllergy patientAllergy) throws Exception;
	public void addPrescription (Prescription prescription) throws Exception;
	public void addTreatment (Treatment treatment) throws Exception;
	
	//endregion
	
	//region deleteFunctions
	
	public void deleteAllergy (long allergyID) throws Exception;
	public void deleteDoctor (long doctorID) throws Exception;
	public void deleteMedicine (long medicineID) throws Exception;
	public void deletePatient (long patientID) throws Exception;
	public void deleteTreatment (long treatmentID) throws Exception;
	
	public void deleteMedicineAllergyByAllergy (long allergyID) throws Exception;
	public void deleteMedicineAllergyByMedicine (long medicineID) throws Exception;
	public void deletePatientAllergyByPatient (long patientID) throws Exception;
	public void deletePatientAllergyByAllergy (long medicineID) throws Exception;
	public void deletePrescriptionByMedicine (long medicineID) throws Exception;
	public void deletePrescriptionByTreatment (long teatmentID) throws Exception;
	public void deletePasswordByUserID (long userID) throws Exception;
	
	//endregion

	//region updateFunctions
	
	public void updateAllergy (Allergy allergy) throws Exception;
	public void updateDoctor (Doctor doctor) throws Exception;
	public void updateMedicine (Medicine medicine) throws Exception;
	public void updateMedicineAllergy (MedicineAllergy medicineAllergy) throws Exception;
	public void updatePassword (Password password) throws Exception;
	public void updatePatient (Patient patient) throws Exception;
	public void updatePatientAllergy (PatientAllergy patientAllergy) throws Exception;
	public void updatePrescription (Prescription prescription) throws Exception;
	public void updateTreatment (Treatment treatment) throws Exception;
	
	//endregion

	//region getFunctions
	
	public ArrayList<Allergy> getAllergyList () throws Exception;
	public ArrayList<Allergy> getAllergyByPatientList (long patientID) throws Exception;
	public ArrayList<Doctor> getDoctorList () throws Exception;
	public ArrayList<Medicine> getMedicineList () throws Exception;
	public ArrayList<Medicine> getMedicineByTreatmentList (long treatmentID) throws Exception;
	public ArrayList<Patient> getPatientList () throws Exception;
	public ArrayList<Treatment> getTreatmentByDoctorList (long doctorID) throws Exception;
	
	public void getConectorMedicineAllergy (long MedicineID, long AllergyID) throws Exception;
	public void getConectorPatientAllergy (long PatientID, long AllergyID) throws Exception;
	public void getConectorPrescription (long TreatmentID, long MedicineID) throws Exception;
	
	//endregion
	
	public Permit checkPassword (long loginID, long password) throws Exception;
}
