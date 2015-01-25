package model.backend;

import java.util.ArrayList;

import entities.*;
import entities.enums.*;

public interface Backend
{	
	public void setLists();
	
	//region addFunctions
	
	/**
	 * add allergy to database.
	 * @param allergy
	 * @throws Exception
	 */
	public void addAllergy (Allergy allergy) throws Exception;
	
	/**
	 * add doctor to database.
	 * @param doctor
	 * @throws Exception
	 */
	public void addDoctor (Doctor doctor) throws Exception;
	
	/**
	 * add medicine to database.
	 * @param medicine
	 * @throws Exception
	 */
	public void addMedicine (Medicine medicine) throws Exception;
	
	/**
	 * add medicine allergy contor to database.
	 * @param medicineAllergy
	 * @throws Exception
	 */
	public void addMedicineAllergy (MedicineAllergy medicineAllergy) throws Exception;
	
	/**
	 * add password to database.
	 * @param password
	 * @throws Exception
	 */
	public void addPassword (Password password) throws Exception;
	
	/**
	 * add patient to database.
	 * @param patient
	 * @throws Exception
	 */
	public void addPatient (Patient patient) throws Exception;
	
	/**
	 * add patient allergy contor to database.
	 * @param patientAllergy
	 * @throws Exception
	 */
	public void addPatientAllergy (PatientAllergy patientAllergy) throws Exception;
	
	/**
	 * add a prescription to database.
	 * @param prescription
	 * @throws Exception
	 */
	public void addPrescription (Prescription prescription) throws Exception;
	
	/**
	 * add treatment to database
	 * @param treatment
	 * @return id of new treatment, -1 if error.
	 * @throws Exception
	 */
	public long addTreatment (Treatment treatment) throws Exception;
	
	//endregion
	
	//region deleteFunctions
	
	/**
	 * delete allergy from database.
	 * @param allergyID
	 * @throws Exception
	 */
	public void deleteAllergy (long allergyID) throws Exception;
	
	/**
	 * delete doctor from database.
	 * @param doctorID
	 * @throws Exception
	 */
	public void deleteDoctor (long doctorID) throws Exception;
	
	/**
	 * delete medcine from database.
	 * @param medicineID
	 * @throws Exception
	 */
	public void deleteMedicine (long medicineID) throws Exception;
	
	/**
	 * delete patient from database.
	 * @param patientID
	 * @throws Exception
	 */
	public void deletePatient (long patientID) throws Exception;
	
	/**
	 * delete treatment from database.
	 * @param treatmentID
	 * @throws Exception
	 */
	public void deleteTreatment (long treatmentID) throws Exception;
	
	
	/**
	 * delete medicine allergy contor via the allergy id.
	 * @param allergyID
	 * @throws Exception
	 */
	public void deleteMedicineAllergyByAllergy (long allergyID) throws Exception;
	
	/**
	 * delete medicine allergy contor via the medicine id.
	 * @param medicineID
	 * @throws Exception
	 */
	public void deleteMedicineAllergyByMedicine (long medicineID) throws Exception;
	
	/**
	 * delete patient allergy contor via the patient id.
	 * @param patientID
	 * @throws Exception
	 */
	public void deletePatientAllergyByPatient (long patientID) throws Exception;
	
	/**
	 * delete patient allergy contor via the allergy id.
	 * @param allergyID
	 * @throws Exception
	 */
	public void deletePatientAllergyByAllergy (long allergyID) throws Exception;
	
	/**
	 * delete prescription via the medicine id.
	 * @param medicineID
	 * @throws Exception
	 */
	public void deletePrescriptionByMedicine (long medicineID) throws Exception;
	
	/**
	 * delete prescription via the treatment id.
	 * @param treatmentID
	 * @throws Exception
	 */
	public void deletePrescriptionByTreatment (long treatmentID) throws Exception;
	
	//endregion

	//region updateFunctions
	
	/**
	 * update allergy.
	 * @param allergy
	 * @throws Exception
	 */
	public void updateAllergy (Allergy allergy) throws Exception;
	
	/**
	 * update doctor.
	 * @param doctor
	 * @throws Exception
	 */
	public void updateDoctor (Doctor doctor) throws Exception;
	
	/**
	 * update medicine
	 * @param medicine
	 * @throws Exception
	 */
	public void updateMedicine (Medicine medicine) throws Exception;
	
	/**
	 * update medicne allergy contor. NOTICE: nothing to update in this version.
	 * @param medicineAllergy
	 * @throws Exception
	 */
	public void updateMedicineAllergy (MedicineAllergy medicineAllergy) throws Exception;
	
	/**
	 * update password, if oldPassword is the current password.
	 * @param oldPassword containing the username, and the old password
	 * @param newPassword new password to String to use from now on.
	 * @throws Exceptionfor all errors, and for when user permit is ADMIN
	 */
	public void updatePassword (Password oldPassword, String newPassword) throws Exception;
	
	/**
	 * update password and change permit, if oldPassword is the current password.
	 * @param oldPassword containing the username, and the old password
	 * @param newPassword new password to String to use from now on.
	 * @param permit new permit.
	 * @throws Exception for all errors, and for when user permit is ADMIN or permit is ADMIN.
	 */
	public void updatePassword (Password oldPassword, String newPassword, Permit permit) throws Exception;
	
	/**
	 * update patient.
	 * @param patient
	 * @throws Exception
	 */
	public void updatePatient (Patient patient) throws Exception;
	
	/**
	 * update patient allergy contor. NOTICE: nothing to update in this version.
	 * @param patientAllergy
	 * @throws Exception
	 */
	public void updatePatientAllergy (PatientAllergy patientAllergy) throws Exception;
	
	/**
	 * update prescription.
	 * @param prescription
	 * @throws Exception
	 */
	public void updatePrescription (Prescription prescription) throws Exception;
	
	/**
	 * update treatment.
	 * @param treatment
	 * @throws Exception
	 */
	public void updateTreatment (Treatment treatment) throws Exception;
	
	//endregion

	//region getFunctions
	
	/**
	 * get list of allergies.
	 * @return list of allergies.
	 * @throws Exception
	 */
	public ArrayList<Allergy> getAllergyList () throws Exception;
	
	/**
	 * get list of allergies of connected to the patient.
	 * @param patientID
	 * @return list of allergies connected to the patient.
	 * @throws Exception
	 */
	public ArrayList<Allergy> getAllergyByPatientList (long patientID) throws Exception;
	
	/**
	 * get list of allergies connected to the medicine.
	 * @param medicineID
	 * @return list of allergies connected to the medicine.
	 * @throws Exception
	 */
	public ArrayList<Allergy> getAllergyByMedicineList (long medicineID) throws Exception;
	
	/**
	 * get list of doctors.
	 * @return list of doctors.
	 * @throws Exception
	 */
	public ArrayList<Doctor> getDoctorList () throws Exception;
	
	/**
	 * get list of medicine.
	 * @return list of medicine.
	 * @throws Exception
	 */
	public ArrayList<Medicine> getMedicineList () throws Exception;
	
	/**
	 * get list of medicine by the treatment they are in.
	 * @param treatmentID
	 * @return list of medicine by the treatment they are in.
	 * @throws Exception
	 */
	public ArrayList<Medicine> getMedicineByTreatmentList (long treatmentID) throws Exception;
	
	/**
	 * get list of patients.
	 * @return list of patients.
	 * @throws Exception
	 */
	public ArrayList<Patient> getPatientList () throws Exception;
	
	/**
	 * get list of medicine-allergy contors.
	 * @param medicineID
	 * @param allergyID
	 * @return list of medicine-allergy contors.
	 * @throws Exception
	 */
	public MedicineAllergy getConectorMedicineAllergy (long medicineID, long allergyID) throws Exception;
	
	/**
	 * get list of patient-allergy contors.
	 * @param patientID
	 * @param allergyID
	 * @return list of patient-allergy contors.
	 * @throws Exception
	 */
	public PatientAllergy getConectorPatientAllergy (long patientID, long allergyID) throws Exception;
	
	/**
	 * get list of prescription contors.
	 * @param treatmentID
	 * @param medicineID
	 * @return list of prescription contors.
	 * @throws Exception
	 */
	public Prescription getConectorPrescription (long treatmentID, long medicineID) throws Exception;
	
	//endregion
	
	/**
	 * check if password is correct
	 * @param loginID doctor trying to log in's id.
	 * @param password password doctor typed.
	 * @return Permit of login - notably DOCTOR if ok, DENIED if wrong, or banned.
	 * @throws Exception
	 */
	public Permit checkPassword (long loginID, String password) throws Exception;

	/**
	 * check if doctors table is empty, as a check if the database is empty.
	 * @return true if empty, false if has at least one row.
	 * @throws Exception
	 */
	public boolean isEmpty() throws Exception;
}
