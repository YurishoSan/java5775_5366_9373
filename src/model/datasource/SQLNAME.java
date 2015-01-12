/**
 * 
 */
package model.datasource;

/**
 * @author Yurisho
 *
 */
public class SQLNAME
{

	public static final int DATABASE_VERSION = 10;
	
	public static final String DATABASE_NAME = "java53669373";
	
	public static final String TABLE_ALLERGY = "allergy_table";
	public static final String TABLE_DOCTOR = "doctor_table";
	public static final String TABLE_MEDICINE = "medicine_table";
	public static final String TABLE_MEDICINE_ALLERGY = "medicine_allergy_table";
	public static final String TABLE_PASSWORD = "password_table";
	public static final String TABLE_PATIENT = "patient_table";
	public static final String TABLE_PATIENT_ALLERGY = "patient_allergy_table";
	public static final String TABLE_PRESCRIPTION = "prescription_table";
	public static final String TABLE_TREATMENT = "treatment_table";
	
	public static final String KEY_ALLERGY_ID = "allergy_id";
	public static final String KEY_ALLERGY_NAME = "allergy_name";
	public static final String KEY_ALLERGY_NOTES = "allergy_notes";
	
	public static final String KEY_DOCTOR_ID = "doctor_id";
	public static final String KEY_DOCTOR_FIRST_NAME = "doctor_first_name";
	public static final String KEY_DOCTOR_LAST_NAME = "doctor_last_name";
	public static final String KEY_DOCTOR_GENDER = "doctor_gender";
	public static final String KEY_DOCTOR_DOB = "doctor_date_of_birth";
	public static final String KEY_DOCTOR_EMAIL_ADDRESS = "doctor_email_address";
	public static final String KEY_DOCTOR_DOJ = "doctor_date_of_join";
	public static final String KEY_DOCTOR_SALARY = "doctor_salary";
	public static final String KEY_DOCTOR_PHONE_NUMBER = "doctor_phone_number";
	public static final String KEY_DOCTOR_SPECIALIZATION = "doctor_specialization";
	
	public static final String KEY_MEDICINE_ID = "medicine_id";
	public static final String KEY_MEDICINE_NAME = "medicine_name";
	public static final String KEY_MEDICINE_INGREDIENTS = "medicine_ingredients";
	public static final String KEY_MEDICINE_ACTIVE_INGREDIENTS = "medicine_active_ingredients";
	public static final String KEY_MEDICINE_TYPE = "medicine_type";
	
	public static final String KEY_MEDICINE_ALLERGY_MEDICINE_ID = "medicine_allergy_medcine_id"; 
	public static final String KEY_MEDICINE_ALLERGY_ALLERGY_ID = "medicien_allergy_allergy_id";
	
	public static final String KEY_PASSWORD_USER_ID = "password_user_id";
	public static final String KEY_PASSWORD_WORD =  "password_word";
	public static final String KEY_PASSWORD_PERMIT = "password_permit";
	
	public static final String KEY_PATIENT_ID = "patient_id";
	public static final String KEY_PATIENT_FIRST_NAME = "patient_first_name";
	public static final String KEY_PATIENT_LAST_NAME = "patient_last_name";
	public static final String KEY_PATIENT_GENDER = "patient_gender";
	public static final String KEY_PATIENT_DOB = "patient_date_of_birth";
	public static final String KEY_PATIENT_EMAIL_ADDRESS = "patient_email_address";
	public static final String KEY_PATIENT_SERVICE_CLASS = "patient_service_class";
	public static final String KEY_PATIENT_PHONE_NUMBER = "patient_phone_number";
	
	public static final String KEY_PATIENT_ALLERGY_PATIENT_ID = "patient_allergy_patient_id";
	public static final String KEY_PATIENT_ALLERGY_ALLERGY_ID = "patient_allergy_allergy_id";
	
	public static final String KEY_PRESCRIPTION_TREATMENT_ID = "prescription_treatment_id";
	public static final String KEY_PRESCRIPTION_MEDICINE_ID = "prescription_medicine_id";
	public static final String KEY_PRESCRIPTION_MEDICINE_EXPERATION_DATE = "prescription_medicine_experation_date";
	
	public static final String KEY_TREATMENT_ID = "treatment_id";
	public static final String KEY_TREATMENT_DOCTOR_ID = "treatment_doctor_id";
	public static final String KEY_TREATMENT_PATIENT_ID = "treatment_patient_id";
	public static final String KEY_TREATMENT_DATE = "treatment_date";
	public static final String KEY_TREATMENT_LOCATION = "treatment_location";
	public static final String KEY_TREATMENT_SUMMARY = "treatment_summarty";
	public static final String KEY_TREATMENT_DONE = "treatment_done";
}
