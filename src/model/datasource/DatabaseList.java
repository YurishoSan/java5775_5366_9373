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
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
		{
			if (medicineAllergyItem.getAllergyID() == allergyID)
			{
				medicineAllergies.remove(medicineAllergyItem);
				return;
			}
		}
		
		throw new Exception("�� ����� ����� ����� - ������ ������.");
		
	}

	@Override
	public void deleteMedicineAllergyByMedicine(long medicineID)
			throws Exception
	{
		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
		{
			if (medicineAllergyItem.getMedicineID() == medicineID)
			{
				medicineAllergies.remove(medicineAllergyItem);
				return;
			}
		}
		
		throw new Exception("�� ����� ����� ����� - ������ ������.");
		
	}

	@Override
	public void deletePatientAllergyByPatient(long patientID) throws Exception
	{
		for (PatientAllergy patientAllergyItem : patientAllergies)
		{
			if (patientAllergyItem.getPatientID() == patientID)
			{
				patientAllergies.remove(patientAllergyItem);
				return;
			}
		}
		
		throw new Exception("�� ����� ����� ������ - ������ ������.");
		
	}

	@Override
	public void deletePatientAllergyByAllergy(long allergyID) throws Exception
	{
		for (PatientAllergy patientAllergyItem : patientAllergies)
		{
			if (patientAllergyItem.getAllergyID() == allergyID)
			{
				patientAllergies.remove(patientAllergyItem);
				return;
			}
		}
		
		throw new Exception("�� ����� ����� ������ - ������ ������.");
		
	}

	@Override
	public void deletePrescriptionByMedicine(long medicineID) throws Exception
	{
		for (Prescription prescriptionItem : prescriptions)
		{
			if (prescriptionItem.getPrescriptionMedicineID() == medicineID)
			{
				prescriptions.remove(prescriptionItem);
				return;
			}
		}
		
		throw new Exception("�� ����� ����� ����� - ����� ������.");
		
	}

	@Override
	public void deletePrescriptionByTreatment(long teatmentID) throws Exception
	{
		for (Prescription prescriptionItem : prescriptions)
		{
			if (prescriptionItem.getPrescriptionTreatmentID() == teatmentID)
			{
				prescriptions.remove(prescriptionItem);
				return;
			}
		}
		
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
