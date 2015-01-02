/**
 * 
 */
package model.datasource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Yurisho
 *
 */
public class DatabaseSqlite extends SQLiteOpenHelper implements Backend
{
	@SuppressLint("SimpleDateFormat")
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public DatabaseSqlite(Context context)
	{
		super(context, SQLNAME.DATABASE_NAME, null, SQLNAME.DATABASE_VERSION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite
	 * .SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		String CREATE_TABLE;

		CREATE_TABLE = "CREATE TABLE " + SQLNAME.TABLE_ALLERGY + "("
				+ SQLNAME.KEY_ALLERGY_ID + " INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ SQLNAME.KEY_ALLERGY_NAME + " TEXT,"
				+ SQLNAME.KEY_ALLERGY_NOTES + " TEXT" + ")";
		db.execSQL(CREATE_TABLE);

		CREATE_TABLE = "CREATE TABLE " + SQLNAME.TABLE_DOCTOR + "("
				+ SQLNAME.KEY_DOCTOR_ID + " INTEGER PRIMARY KEY,"
				+ SQLNAME.KEY_DOCTOR_FIRST_NAME + " TEXT,"
				+ SQLNAME.KEY_DOCTOR_LAST_NAME + " TEXT,"
				+ SQLNAME.KEY_DOCTOR_GENDER + " TEXT," + SQLNAME.KEY_DOCTOR_DOB
				+ " TEXT," + SQLNAME.KEY_DOCTOR_EMAIL_ADDRESS + " TEXT,"
				+ SQLNAME.KEY_DOCTOR_DOJ + " TEXT," + SQLNAME.KEY_DOCTOR_SALARY
				+ " REAL," + SQLNAME.KEY_DOCTOR_PHONE_NUMBER + " TEXT,"
				+ SQLNAME.KEY_DOCTOR_SPECIALIZATION + " TEXT" + ")";
		db.execSQL(CREATE_TABLE);

		CREATE_TABLE = "CREATE TABLE " + SQLNAME.TABLE_MEDICINE + "("
				+ SQLNAME.KEY_MEDICINE_ID + " INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ SQLNAME.KEY_MEDICINE_NAME + " TEXT,"
				+ SQLNAME.KEY_MEDICINE_INGREDIENTS + " TEXT,"
				+ SQLNAME.KEY_MEDICINE_ACTIVE_INGREDIENTS + " TEXT,"
				+ SQLNAME.KEY_MEDICINE_TYPE + " TEXT" + ")";
		db.execSQL(CREATE_TABLE);

		CREATE_TABLE = "CREATE TABLE " + SQLNAME.TABLE_MEDICINE_ALLERGY + "("
				+ SQLNAME.KEY_MEDICINE_ALLERGY_ALLERGY_ID + " INTEGER,"
				+ SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID + " INTEGER,"
				+ "constraint pk1 primary key ("
				+ SQLNAME.KEY_MEDICINE_ALLERGY_ALLERGY_ID + ", "
				+ SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID + "),"
				+ "constraint fk1 foreign key ("
				+ SQLNAME.KEY_MEDICINE_ALLERGY_ALLERGY_ID + ") references "
				+ SQLNAME.TABLE_ALLERGY + "(" + SQLNAME.KEY_ALLERGY_ID
				+ ")on delete SET NULL ," + "constraint fk2 foreign key ("
				+ SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID + ") references "
				+ SQLNAME.TABLE_MEDICINE + "(" + SQLNAME.KEY_MEDICINE_ID
				+ ") on delete SET NULL on update SET NULL)";
		db.execSQL(CREATE_TABLE);

		CREATE_TABLE = "CREATE TABLE " + SQLNAME.TABLE_PASSWORD + "("
				+ SQLNAME.KEY_PASSWORD_USER_ID + " INTEGER,"
				+ SQLNAME.KEY_PASSWORD_WORD + " TEXT,"
				+ SQLNAME.KEY_PASSWORD_PERMIT + " TEXT,"
				+ "constraint pk1 primary key (" + SQLNAME.KEY_PASSWORD_USER_ID
				+ ", " + SQLNAME.KEY_PASSWORD_WORD + "),"
				+ "constraint fk1 foreign key (" + SQLNAME.KEY_PASSWORD_USER_ID
				+ ") references " + SQLNAME.TABLE_DOCTOR + "("
				+ SQLNAME.KEY_DOCTOR_ID
				+ ")on delete SET NULL on update SET NULL)";
		db.execSQL(CREATE_TABLE);

		CREATE_TABLE = "CREATE TABLE " + SQLNAME.TABLE_PATIENT + "("
				+ SQLNAME.KEY_PATIENT_ID + " INTEGER PRIMARY KEY,"
				+ SQLNAME.KEY_PATIENT_FIRST_NAME + " TEXT,"
				+ SQLNAME.KEY_PATIENT_LAST_NAME + " TEXT,"
				+ SQLNAME.KEY_PATIENT_GENDER + " TEXT,"
				+ SQLNAME.KEY_PATIENT_DOB + " TEXT,"
				+ SQLNAME.KEY_PATIENT_EMAIL_ADDRESS + " TEXT,"
				+ SQLNAME.KEY_PATIENT_SERVICE_CLASS + " TEXT,"
				+ SQLNAME.KEY_PATIENT_PHONE_NUMBER + " TEXT" + ")";
		db.execSQL(CREATE_TABLE);

		CREATE_TABLE = "CREATE TABLE " + SQLNAME.TABLE_PATIENT_ALLERGY + "("
				+ SQLNAME.KEY_PATIENT_ALLERGY_ALLERGY_ID + " INTEGER,"
				+ SQLNAME.KEY_PATIENT_ALLERGY_PATIENT_ID + " INTEGER,"
				+ "constraint pk1 primary key ("
				+ SQLNAME.KEY_PATIENT_ALLERGY_ALLERGY_ID + ", "
				+ SQLNAME.KEY_PATIENT_ALLERGY_PATIENT_ID + "),"
				+ "constraint fk1 foreign key ("
				+ SQLNAME.KEY_PATIENT_ALLERGY_ALLERGY_ID + ") references "
				+ SQLNAME.TABLE_ALLERGY + "(" + SQLNAME.KEY_ALLERGY_ID
				+ ")on delete SET NULL ," + "constraint fk2 foreign key ("
				+ SQLNAME.KEY_PATIENT_ALLERGY_PATIENT_ID + ") references "
				+ SQLNAME.TABLE_PATIENT + "(" + SQLNAME.KEY_PATIENT_ID
				+ ") on delete SET NULL on update SET NULL)";
		db.execSQL(CREATE_TABLE);

		CREATE_TABLE = "CREATE TABLE " + SQLNAME.TABLE_PRESCRIPTION + "("
				+ SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID + " INTEGER,"
				+ SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID + " INTEGER,"
				+ SQLNAME.KEY_PRESCRIPTION_MEDICINE_EXPERATION_DATE
				+ " STRING," + "constraint pk1 primary key ("
				+ SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID + ", "
				+ SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID + "),"
				+ "constraint fk1 foreign key ("
				+ SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID + ") references "
				+ SQLNAME.TABLE_TREATMENT + "(" + SQLNAME.KEY_TREATMENT_ID
				+ ")on delete SET NULL ," + "constraint fk2 foreign key ("
				+ SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID + ") references "
				+ SQLNAME.TABLE_MEDICINE + "(" + SQLNAME.KEY_MEDICINE_ID
				+ ") on delete SET NULL on update SET NULL)";
		db.execSQL(CREATE_TABLE);

		CREATE_TABLE = "CREATE TABLE " + SQLNAME.TABLE_PATIENT + "("
				+ SQLNAME.KEY_TREATMENT_ID + " INTEGER PRIMARY KEY,"
				+ SQLNAME.KEY_TREATMENT_DOCTOR_ID + " INTEGER, "
				+ SQLNAME.KEY_TREATMENT_PATIENT_ID + " INTEGER, "
				+ SQLNAME.KEY_TREATMENT_DATE + " TEXT,"
				+ SQLNAME.KEY_TREATMENT_LOCATION + " TEXT,"
				+ SQLNAME.KEY_TREATMENT_SUMMARY + " TEXT,"
				+ SQLNAME.KEY_TREATMENT_DONE + " INTEGER,"
				+ "constraint fk1 foreign key ("
				+ SQLNAME.KEY_TREATMENT_DOCTOR_ID + ") references "
				+ SQLNAME.TABLE_DOCTOR + "(" + SQLNAME.KEY_DOCTOR_ID
				+ ")on delete SET NULL ," + "constraint fk2 foreign key ("
				+ SQLNAME.KEY_TREATMENT_PATIENT_ID + ") references "
				+ SQLNAME.TABLE_PATIENT + "(" + SQLNAME.KEY_PATIENT_ID
				+ ") on delete SET NULL on update SET NULL)";
		
	}

	@Override
	public void setLists()
	{
		try
		{
			this.addAllergy(new Allergy(0, "Paracetamol hypersensitivity",
					"אלרגיה ל פאראסטמול, הרכיב הפעיל של אקמול."));
			this.addAllergy(new Allergy(1, "test",
					"אלרגיה ל פאראסטמול, הרכיב הפעיל של אקמול."));

			this.addDoctor(new Doctor(1, "test", "testy", Gender.MALE,
					new Date(1970, 5, 12), new Date(2002, 7, 1),
					"moti_kereker321@yahoo.com", (float) 130000.0, "050777654",
					Specialization.FAMILY));
			this.addDoctor(new Doctor(333658712, "מוטי", "קרקר", Gender.MALE,
					new Date(1970, 5, 12), new Date(2002, 7, 1),
					"moti_kereker321@yahoo.com", (float) 130000.0, "050777654",
					Specialization.FAMILY));

			this.addMedicine(new Medicine(
					0,
					"אקמול פוקוס",
					"Microcrystalline cellulose, stearic acid, crospovidone, silicon dioxide, hydroxypropyl"
							+ "methylcellulose, FD&C red #40, FD&C yellow #6, polyethylene glycol 400, titanium dioxide,"
							+ "polysorbate 80, purified water. ",
					"Acetylsalicylic acid 250 mg, Paracetamol 250 mg, Caffeine anhydrous 65 mg",
					MedicineType.PILL_TABLET));

			this.addMedicineAllergy(new MedicineAllergy(0, 0));

			this.addPassword(new Password(1, "1", Permit.DOCTOR));
			this.addPassword(new Password(333658712, "1234", Permit.DOCTOR));

			this.addPatient(new Patient(544812123, "שלומי", "סבבה",
					Gender.MALE, new Date(1980, 11, 15), "sabamba@gmail.com",
					ServiceClass.GOLD, "035432213"));

			// this.addPatientAllergy(patientAllergy);

			// this.addPrescription(prescription);

			// this.addTreatment(treatment);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite
	 * .SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS " + SQLNAME.TABLE_ALLERGY);
		db.execSQL("DROP TABLE IF EXISTS " + SQLNAME.TABLE_DOCTOR);
		db.execSQL("DROP TABLE IF EXISTS " + SQLNAME.TABLE_MEDICINE);
		db.execSQL("DROP TABLE IF EXISTS " + SQLNAME.TABLE_MEDICINE_ALLERGY);
		db.execSQL("DROP TABLE IF EXISTS " + SQLNAME.TABLE_PASSWORD);
		db.execSQL("DROP TABLE IF EXISTS " + SQLNAME.TABLE_PATIENT);
		db.execSQL("DROP TABLE IF EXISTS " + SQLNAME.TABLE_PATIENT_ALLERGY);
		db.execSQL("DROP TABLE IF EXISTS " + SQLNAME.TABLE_PRESCRIPTION);
		db.execSQL("DROP TABLE IF EXISTS " + SQLNAME.TABLE_TREATMENT);

		onCreate(db);
	}

	// region addFunctions

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#addAllergy(entities.Allergy)
	 */
	@Override
	public void addAllergy(Allergy allergy) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_ALLERGY_ID, allergy.getAllergyID());
		values.put(SQLNAME.KEY_ALLERGY_NAME, allergy.getAllergyName());
		values.put(SQLNAME.KEY_ALLERGY_NOTES, allergy.getAllergyNotes());

		db.insertWithOnConflict(SQLNAME.TABLE_ALLERGY, null, values,
				SQLiteDatabase.CONFLICT_IGNORE);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#addDoctor(entities.Doctor)
	 */
	@Override
	public void addDoctor(Doctor doctor) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_DOCTOR_ID, doctor.getDoctorID());
		values.put(SQLNAME.KEY_DOCTOR_FIRST_NAME, doctor.getDoctorFirstName());
		values.put(SQLNAME.KEY_DOCTOR_LAST_NAME, doctor.getDoctorLastName());
		values.put(SQLNAME.KEY_DOCTOR_GENDER, doctor.getDoctorGender().name());
		values.put(SQLNAME.KEY_DOCTOR_DOB,
				dateFormat.format(doctor.getDoctorDoB()));
		values.put(SQLNAME.KEY_DOCTOR_EMAIL_ADDRESS,
				doctor.getDoctorEmailAdress());
		values.put(SQLNAME.KEY_DOCTOR_DOJ,
				dateFormat.format(doctor.getDoctorDoJ()));
		values.put(SQLNAME.KEY_DOCTOR_SALARY, doctor.getDoctorSalary());
		values.put(SQLNAME.KEY_DOCTOR_PHONE_NUMBER,
				doctor.getDoctorPhoneNumber());
		values.put(SQLNAME.KEY_DOCTOR_SPECIALIZATION, doctor
				.getDoctorSpecialization().name());

		db.insertWithOnConflict(SQLNAME.TABLE_DOCTOR, null, values,
				SQLiteDatabase.CONFLICT_IGNORE);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#addMedicine(entities.Medicine)
	 */
	@Override
	public void addMedicine(Medicine medicine) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_MEDICINE_ID, medicine.getMedicineID());
		values.put(SQLNAME.KEY_MEDICINE_NAME, medicine.getMedicineName());
		values.put(SQLNAME.KEY_MEDICINE_INGREDIENTS,
				medicine.getMedicineIngredients());
		values.put(SQLNAME.KEY_MEDICINE_ACTIVE_INGREDIENTS,
				medicine.getMedicineActiveIngredients());
		values.put(SQLNAME.KEY_MEDICINE_TYPE, medicine.getMedicineType().name());

		db.insertWithOnConflict(SQLNAME.TABLE_MEDICINE, null, values,
				SQLiteDatabase.CONFLICT_IGNORE);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#addMedicineAllergy(entities.MedicineAllergy)
	 */
	@Override
	public void addMedicineAllergy(MedicineAllergy medicineAllergy)
			throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID,
				medicineAllergy.getMedicineID());
		values.put(SQLNAME.KEY_MEDICINE_ALLERGY_ALLERGY_ID,
				medicineAllergy.getAllergyID());

		db.insertWithOnConflict(SQLNAME.TABLE_MEDICINE_ALLERGY, null, values,
				SQLiteDatabase.CONFLICT_IGNORE);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#addPassword(entities.Password)
	 */
	@Override
	public void addPassword(Password password) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		/*
		 * if (checkPassword(password.getPasswordUserID(),
		 * password.getPasswordWord()) != Permit.DENIED) // user can have //
		 * only one // password throw new Exception("למשתמש זה יש כבר סיסמה!");
		 */

		values.put(SQLNAME.KEY_PASSWORD_USER_ID, password.getPasswordUserID());
		values.put(SQLNAME.KEY_PASSWORD_WORD, password.getPasswordWord());
		values.put(SQLNAME.KEY_PASSWORD_PERMIT, password.getPasswordPermit()
				.name());

		db.insertWithOnConflict(SQLNAME.TABLE_PASSWORD, null, values,
				SQLiteDatabase.CONFLICT_IGNORE);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#addPatient(entities.Patient)
	 */
	@Override
	public void addPatient(Patient patient) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_PATIENT_ID, patient.getPatientID());
		values.put(SQLNAME.KEY_PATIENT_FIRST_NAME,
				patient.getPatientFirstName());
		values.put(SQLNAME.KEY_PATIENT_LAST_NAME, patient.getPatientLastName());
		values.put(SQLNAME.KEY_PATIENT_GENDER, patient.getPatientGender()
				.name());
		values.put(SQLNAME.KEY_PATIENT_DOB,
				dateFormat.format(patient.getPatientDoB()));
		values.put(SQLNAME.KEY_PATIENT_EMAIL_ADDRESS,
				patient.getPatientEmailAdress());
		values.put(SQLNAME.KEY_PATIENT_SERVICE_CLASS, patient
				.getPatientServiceClass().name());
		values.put(SQLNAME.KEY_PATIENT_PHONE_NUMBER,
				patient.getPatientPhoneNumber());

		db.insertWithOnConflict(SQLNAME.TABLE_PATIENT, null, values,
				SQLiteDatabase.CONFLICT_IGNORE);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#addPatientAllergy(entities.PatientAllergy)
	 */
	@Override
	public void addPatientAllergy(PatientAllergy patientAllergy)
			throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_PATIENT_ALLERGY_PATIENT_ID,
				patientAllergy.getPatientID());
		values.put(SQLNAME.KEY_PATIENT_ALLERGY_ALLERGY_ID,
				patientAllergy.getAllergyID());

		db.insertWithOnConflict(SQLNAME.TABLE_PATIENT_ALLERGY, null, values,
				SQLiteDatabase.CONFLICT_IGNORE);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#addPrescription(entities.Prescription)
	 */
	@Override
	public void addPrescription(Prescription prescription) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID,
				prescription.getPrescriptionTreatmentID());
		values.put(SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID,
				prescription.getPrescriptionMedicineID());
		values.put(SQLNAME.KEY_PRESCRIPTION_MEDICINE_EXPERATION_DATE,
				dateFormat.format(prescription
						.getPrescriptionMedicineExperationDate()));

		db.insertWithOnConflict(SQLNAME.TABLE_PRESCRIPTION, null, values,
				SQLiteDatabase.CONFLICT_IGNORE);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#addTreatment(entities.Treatment)
	 */
	@Override
	public void addTreatment(Treatment treatment) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_TREATMENT_ID, treatment.getTreatmentID());
		values.put(SQLNAME.KEY_TREATMENT_DOCTOR_ID,
				treatment.getTreatmentDoctorID());
		values.put(SQLNAME.KEY_TREATMENT_PATIENT_ID,
				treatment.getTreatmentPatientID());
		values.put(SQLNAME.KEY_TREATMENT_DATE,
				dateFormat.format(treatment.getTreatmentDate()));
		values.put(SQLNAME.KEY_TREATMENT_LOCATION,
				treatment.getTreatmentLocation());
		values.put(SQLNAME.KEY_TREATMENT_SUMMARY,
				treatment.getTreatmentSummary());
		values.put(SQLNAME.KEY_TREATMENT_DONE,
				(treatment.isTreatmentDone()) ? 1 : 0);

		db.insertWithOnConflict(SQLNAME.TABLE_TREATMENT, null, values,
				SQLiteDatabase.CONFLICT_IGNORE);
		db.close();
	}

	// endregion

	// region deleteFunctions

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deleteAllergy(long)
	 */
	@Override
	public void deleteAllergy(long allergyID) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_ALLERGY, SQLNAME.KEY_ALLERGY_ID + " = ?",
				new String[] { String.valueOf(allergyID) });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deleteDoctor(long)
	 */
	@Override
	public void deleteDoctor(long doctorID) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_DOCTOR, SQLNAME.KEY_DOCTOR_ID + " = ?",
				new String[] { String.valueOf(doctorID) });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deleteMedicine(long)
	 */
	@Override
	public void deleteMedicine(long medicineID) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_MEDICINE, SQLNAME.KEY_MEDICINE_ID + " = ?",
				new String[] { String.valueOf(medicineID) });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deletePatient(long)
	 */
	@Override
	public void deletePatient(long patientID) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_PATIENT, SQLNAME.KEY_PATIENT_ID + " = ?",
				new String[] { String.valueOf(patientID) });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deleteTreatment(long)
	 */
	@Override
	public void deleteTreatment(long treatmentID) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_TREATMENT, SQLNAME.KEY_TREATMENT_ID + " = ?",
				new String[] { String.valueOf(treatmentID) });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deleteMedicineAllergyByAllergy(long)
	 */
	@Override
	public void deleteMedicineAllergyByAllergy(long allergyID) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_ALLERGY, SQLNAME.KEY_ALLERGY_ID + " = ?",
				new String[] { String.valueOf(allergyID) });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deleteMedicineAllergyByMedicine(long)
	 */
	@Override
	public void deleteMedicineAllergyByMedicine(long medicineID)
			throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_MEDICINE_ALLERGY,
				SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID + " = ?",
				new String[] { String.valueOf(medicineID) });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deletePatientAllergyByPatient(long)
	 */
	@Override
	public void deletePatientAllergyByPatient(long patientID) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_PATIENT_ALLERGY,
				SQLNAME.KEY_PATIENT_ALLERGY_PATIENT_ID + " = ?",
				new String[] { String.valueOf(patientID) });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deletePatientAllergyByAllergy(long)
	 */
	@Override
	public void deletePatientAllergyByAllergy(long allergyID) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_PATIENT_ALLERGY,
				SQLNAME.KEY_PATIENT_ALLERGY_ALLERGY_ID + " = ?",
				new String[] { String.valueOf(allergyID) });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deletePrescriptionByMedicine(long)
	 */
	@Override
	public void deletePrescriptionByMedicine(long medicineID) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_PRESCRIPTION,
				SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID + " = ?",
				new String[] { String.valueOf(medicineID) });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#deletePrescriptionByTreatment(long)
	 */
	@Override
	public void deletePrescriptionByTreatment(long treatmentID)
			throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(SQLNAME.TABLE_PRESCRIPTION,
				SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID + " = ?",
				new String[] { String.valueOf(treatmentID) });
	}

	// endregion

	// region updateFunction

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#updateAllergy(entities.Allergy)
	 */
	@Override
	public void updateAllergy(Allergy allergy) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_ALLERGY_NAME, allergy.getAllergyName());
		values.put(SQLNAME.KEY_ALLERGY_NOTES, allergy.getAllergyNotes());

		db.update(SQLNAME.TABLE_ALLERGY, values, SQLNAME.KEY_ALLERGY_ID
				+ " = ?",
				new String[] { String.valueOf(allergy.getAllergyID()) });
		db.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#updateDoctor(entities.Doctor)
	 */
	@Override
	public void updateDoctor(Doctor doctor) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_DOCTOR_FIRST_NAME, doctor.getDoctorFirstName());
		values.put(SQLNAME.KEY_DOCTOR_LAST_NAME, doctor.getDoctorLastName());
		values.put(SQLNAME.KEY_DOCTOR_GENDER, doctor.getDoctorGender().name());
		values.put(SQLNAME.KEY_DOCTOR_DOB,
				dateFormat.format(doctor.getDoctorDoB()));
		values.put(SQLNAME.KEY_DOCTOR_EMAIL_ADDRESS,
				doctor.getDoctorEmailAdress());
		values.put(SQLNAME.KEY_DOCTOR_DOJ,
				dateFormat.format(doctor.getDoctorDoJ()));
		values.put(SQLNAME.KEY_DOCTOR_SALARY, doctor.getDoctorSalary());
		values.put(SQLNAME.KEY_DOCTOR_PHONE_NUMBER,
				doctor.getDoctorPhoneNumber());
		values.put(SQLNAME.KEY_DOCTOR_SPECIALIZATION, doctor
				.getDoctorSpecialization().name());

		db.update(SQLNAME.TABLE_DOCTOR, values, SQLNAME.KEY_DOCTOR_ID + " = ?",
				new String[] { String.valueOf(doctor.getDoctorID()) });
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#updateMedicine(entities.Medicine)
	 */
	@Override
	public void updateMedicine(Medicine medicine) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_MEDICINE_NAME, medicine.getMedicineName());
		values.put(SQLNAME.KEY_MEDICINE_INGREDIENTS,
				medicine.getMedicineIngredients());
		values.put(SQLNAME.KEY_MEDICINE_ACTIVE_INGREDIENTS,
				medicine.getMedicineActiveIngredients());
		values.put(SQLNAME.KEY_MEDICINE_TYPE, medicine.getMedicineType().name());

		db.update(SQLNAME.TABLE_ALLERGY, values, SQLNAME.KEY_ALLERGY_ID
				+ " = ?",
				new String[] { String.valueOf(medicine.getMedicineID()) });
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * model.backend.Backend#updateMedicineAllergy(entities.MedicineAllergy)
	 */
	@Override
	public void updateMedicineAllergy(MedicineAllergy medicineAllergy)
			throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		// add updated attributes here, if an

		// db.update(SQLNAME.TABLE_MEDICINE_ALLERGY, values, /* what check goes
		// here? */);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#updatePassword(entities.Password,
	 * java.lang.String)
	 */
	@Override
	public void updatePassword(Password oldPassword, String newPassword)
			throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		if (checkPassword(oldPassword.getPasswordUserID(),
				oldPassword.getPasswordWord()) == Permit.DENIED)
			throw new Exception("סיסמה שגויה");

		values.put(SQLNAME.KEY_PASSWORD_WORD, newPassword);

		db.update(
				SQLNAME.TABLE_PASSWORD,
				values,
				SQLNAME.KEY_PASSWORD_USER_ID + " = ?",
				new String[] { String.valueOf(oldPassword.getPasswordUserID()) });
		db.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#updatePassword(entities.Password,
	 * java.lang.String, entities.enums.Permit)
	 */
	@Override
	public void updatePassword(Password oldPassword, String newPassword,
			Permit permit) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		if (checkPassword(oldPassword.getPasswordUserID(),
				oldPassword.getPasswordWord()) == Permit.DENIED)
			throw new Exception("סיסמה שגויה");

		if (oldPassword.getPasswordPermit() != Permit.ADMIN || // do not allow
																// change to
																// admin's
																// premision.
				permit != Permit.ADMIN) // do not allow other users to turn
										// admins.
			values.put(SQLNAME.KEY_PASSWORD_PERMIT, permit.name());
		else
			throw new Exception("שינוי הרשאות (ל)אדמין אסור.");

		values.put(SQLNAME.KEY_PASSWORD_WORD, newPassword);

		db.update(
				SQLNAME.TABLE_PASSWORD,
				values,
				SQLNAME.KEY_PASSWORD_USER_ID + " = ?",
				new String[] { String.valueOf(oldPassword.getPasswordUserID()) });
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#updatePatient(entities.Patient)
	 */
	@Override
	public void updatePatient(Patient patient) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_PATIENT_FIRST_NAME,
				patient.getPatientFirstName());
		values.put(SQLNAME.KEY_PATIENT_LAST_NAME, patient.getPatientLastName());
		values.put(SQLNAME.KEY_PATIENT_GENDER, patient.getPatientGender()
				.name());
		values.put(SQLNAME.KEY_PATIENT_DOB,
				dateFormat.format(patient.getPatientDoB()));
		values.put(SQLNAME.KEY_PATIENT_EMAIL_ADDRESS,
				patient.getPatientEmailAdress());
		values.put(SQLNAME.KEY_PATIENT_SERVICE_CLASS, patient
				.getPatientServiceClass().name());
		values.put(SQLNAME.KEY_PATIENT_PHONE_NUMBER,
				patient.getPatientPhoneNumber());

		db.update(SQLNAME.TABLE_PATIENT, values, SQLNAME.KEY_PATIENT_ID
				+ " = ?",
				new String[] { String.valueOf(patient.getPatientID()) });
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#updatePatientAllergy(entities.PatientAllergy)
	 */
	@Override
	public void updatePatientAllergy(PatientAllergy patientAllergy)
			throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		// add updated attributes here, if an

		// db.update(SQLNAME.TABLE_PATIENT_ALLERGY, values, /* what check goes
		// here? */);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#updatePrescription(entities.Prescription)
	 */
	@Override
	public void updatePrescription(Prescription prescription) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		// add updated attributes here, if an

		// db.update(SQLNAME.TABLE_PRESCRIPTION, values, /* what check goes
		// here? */);
		db.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#updateTreatment(entities.Treatment)
	 */
	@Override
	public void updateTreatment(Treatment treatment) throws Exception
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(SQLNAME.KEY_TREATMENT_DOCTOR_ID,
				treatment.getTreatmentDoctorID());
		values.put(SQLNAME.KEY_TREATMENT_PATIENT_ID,
				treatment.getTreatmentPatientID());
		values.put(SQLNAME.KEY_TREATMENT_DATE,
				dateFormat.format(treatment.getTreatmentDate()));
		values.put(SQLNAME.KEY_TREATMENT_LOCATION,
				treatment.getTreatmentLocation());
		values.put(SQLNAME.KEY_TREATMENT_SUMMARY,
				treatment.getTreatmentSummary());
		values.put(SQLNAME.KEY_TREATMENT_DONE,
				(treatment.isTreatmentDone()) ? 1 : 0);

		db.update(SQLNAME.TABLE_TREATMENT, values, SQLNAME.KEY_TREATMENT_ID
				+ " = ?",
				new String[] { String.valueOf(treatment.getTreatmentID()) });
		db.close();

	}

	// endregion

	// region getFunction

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getAllergyList()
	 */
	@Override
	public ArrayList<Allergy> getAllergyList() throws Exception
	{
		ArrayList<Allergy> allergyList = new ArrayList<Allergy>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_ALLERGY;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst())
		{
			do
			{
				Allergy allergy = new Allergy();

				allergy.setAllergyID(cursor.getLong(0));
				allergy.setAllergyName((String) cursor.getString(1));
				allergy.setAllergyNotes((String) cursor.getString(2));

				allergyList.add(allergy);
			} while (cursor.moveToNext());
		}
		return allergyList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getAllergyByPatientList(long)
	 */
	@Override
	public ArrayList<Allergy> getAllergyByPatientList(long patientID)
			throws Exception
	{
		ArrayList<Allergy> allergyList = new ArrayList<Allergy>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_ALLERGY
				+ " tAllergy, " + SQLNAME.TABLE_PATIENT + " tPatient, "
				+ SQLNAME.TABLE_PATIENT_ALLERGY + " tAllergyPatient "
				+ "WHERE tPatient." + SQLNAME.KEY_PATIENT_ID + " = '"
				+ patientID + "'" + " AND tPatient." + SQLNAME.KEY_PATIENT_ID
				+ " = " + "tAllergyPatient."
				+ SQLNAME.KEY_PATIENT_ALLERGY_PATIENT_ID + " AND tAllergy."
				+ SQLNAME.KEY_ALLERGY_ID + " = " + "tAllergyPatient."
				+ SQLNAME.KEY_PATIENT_ALLERGY_ALLERGY_ID;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst())
		{
			do
			{
				Allergy allergy = new Allergy();

				allergy.setAllergyID(cursor.getLong(0));
				allergy.setAllergyName((String) cursor.getString(1));
				allergy.setAllergyNotes((String) cursor.getString(2));

				allergyList.add(allergy);
			} while (cursor.moveToNext());
		}
		return allergyList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getAllergyByMedicineList(long)
	 */
	@Override
	public ArrayList<Allergy> getAllergyByMedicineList(long medicineID)
			throws Exception
	{
		ArrayList<Allergy> allergyList = new ArrayList<Allergy>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_ALLERGY
				+ " tAllergy, " + SQLNAME.TABLE_MEDICINE + " tMedicine, "
				+ SQLNAME.TABLE_MEDICINE_ALLERGY + " tAllergyMedicine "
				+ "WHERE tMedicine." + SQLNAME.KEY_MEDICINE_ID + " = '"
				+ medicineID + "'" + " AND tMedicine."
				+ SQLNAME.KEY_MEDICINE_ID + " = " + "tAllergyMedicine."
				+ SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID + " AND tAllergy."
				+ SQLNAME.KEY_ALLERGY_ID + " = " + "tAllergyMedicine."
				+ SQLNAME.KEY_MEDICINE_ALLERGY_ALLERGY_ID;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst())
		{
			do
			{
				Allergy allergy = new Allergy();

				allergy.setAllergyID(cursor.getLong(0));
				allergy.setAllergyName((String) cursor.getString(1));
				allergy.setAllergyNotes((String) cursor.getString(2));

				allergyList.add(allergy);
			} while (cursor.moveToNext());
		}
		return allergyList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getDoctorList()
	 */
	@Override
	public ArrayList<Doctor> getDoctorList() throws Exception
	{
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_DOCTOR;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst())
		{
			do
			{
				Doctor doctor = new Doctor();

				doctor.setDoctorID(cursor.getLong(0));
				doctor.setDoctorFirstName(cursor.getString(1));
				doctor.setDoctorLastName(cursor.getString(2));
				doctor.setDoctorGender(Gender.valueOf(cursor.getString(3)));
				doctor.setDoctorDoB(dateFormat.parse(cursor.getString(4)));
				doctor.setDoctorEmailAdress(cursor.getString(5));
				doctor.setDoctorDoJ(dateFormat.parse(cursor.getString(6)));
				doctor.setDoctorSalary(cursor.getFloat(7));
				doctor.setDoctorPhoneNumber(cursor.getString(8));
				doctor.setDoctorSpecialization(Specialization.valueOf(cursor
						.getString(9)));

				doctorList.add(doctor);
			} while (cursor.moveToNext());
		}
		return doctorList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getMedicineList()
	 */
	@Override
	public ArrayList<Medicine> getMedicineList() throws Exception
	{
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_MEDICINE;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst())
		{
			do
			{
				Medicine medicine = new Medicine();

				medicine.setMedicineID(cursor.getLong(0));
				medicine.setMedicineName(cursor.getString(1));
				medicine.setMedicineIngredients(cursor.getString(2));
				medicine.setMedicineActiveIngredients(cursor.getString(3));
				medicine.setMedicineType(MedicineType.valueOf(cursor
						.getString(4)));

				medicineList.add(medicine);
			} while (cursor.moveToNext());
		}
		return medicineList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getMedicineByTreatmentList(long)
	 */
	@Override
	public ArrayList<Medicine> getMedicineByTreatmentList(long treatmentID)
			throws Exception
	{
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_MEDICINE
				+ " tMedicine, " + SQLNAME.TABLE_TREATMENT + " tTreatment, "
				+ SQLNAME.TABLE_PRESCRIPTION + " tPrescription "
				+ "WHERE tTreatment." + SQLNAME.KEY_TREATMENT_ID + " = '"
				+ treatmentID + "'" + " AND tMedicine."
				+ SQLNAME.KEY_MEDICINE_ID + " = " + "tPrescription."
				+ SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID + " AND tTreatment."
				+ SQLNAME.KEY_TREATMENT_ID + " = " + "tPresrcription."
				+ SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst())
		{
			do
			{
				Medicine medicine = new Medicine();

				medicine.setMedicineID(cursor.getLong(0));
				medicine.setMedicineName(cursor.getString(1));
				medicine.setMedicineIngredients(cursor.getString(2));
				medicine.setMedicineActiveIngredients(cursor.getString(3));
				medicine.setMedicineType(MedicineType.valueOf(cursor
						.getString(4)));

				medicineList.add(medicine);
			} while (cursor.moveToNext());
		}
		return medicineList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getPatientList()
	 */
	@Override
	public ArrayList<Patient> getPatientList() throws Exception
	{
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_PATIENT;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst())
		{
			do
			{
				Patient patient = new Patient();

				patient.setPatientID(cursor.getLong(0));
				patient.setPatientFirstName(cursor.getString(1));
				patient.setPatientLastName(cursor.getString(2));
				patient.setPatientGender(Gender.valueOf(cursor.getString(3)));
				patient.setPatientDoB(dateFormat.parse(cursor.getString(4)));
				patient.setPatientEmailAdress(cursor.getString(5));
				patient.setPatientServiceClass(ServiceClass.valueOf(cursor
						.getString(6)));
				patient.setPatientPhoneNumber(cursor.getString(7));

				patientList.add(patient);
			} while (cursor.moveToNext());
		}
		return patientList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getConectorMedicineAllergy(long, long)
	 */
	@Override
	public MedicineAllergy getConectorMedicineAllergy(long medicineID,
			long allergyID) throws Exception
	{
		ArrayList<MedicineAllergy> medicineAllergies = getMedicineAllergyList();

		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
			if (medicineAllergyItem.getAllergyID() == allergyID
					&& medicineAllergyItem.getMedicineID() == medicineID)
				return medicineAllergyItem;

		throw new Exception("אין קישור בין תרופה זו ואלרגיה זו!");

	}

	private ArrayList<MedicineAllergy> getMedicineAllergyList()
			throws ParseException
	{
		ArrayList<MedicineAllergy> medicineAllergyList = new ArrayList<MedicineAllergy>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_MEDICINE_ALLERGY;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst())
		{
			do
			{
				MedicineAllergy medicineAllergy = new MedicineAllergy();

				medicineAllergy.setAllergyID(cursor.getLong(0));
				medicineAllergy.setMedicineID(cursor.getLong(1));

				medicineAllergyList.add(medicineAllergy);

			} while (cursor.moveToNext());
		}

		return medicineAllergyList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getConectorPatientAllergy(long, long)
	 */
	@Override
	public PatientAllergy getConectorPatientAllergy(long patientID,
			long allergyID) throws Exception
	{
		ArrayList<PatientAllergy> patientAllergies = getPatientAllergyList();

		for (PatientAllergy patientAllergyItem : patientAllergies)
			if (patientAllergyItem.getAllergyID() == allergyID
					&& patientAllergyItem.getPatientID() == patientID)
				return patientAllergyItem;

		throw new Exception("אין קישור בין פציינט זה ואלרגיה זו!");
	}

	private ArrayList<PatientAllergy> getPatientAllergyList()
	{
		ArrayList<PatientAllergy> patientAllergyList = new ArrayList<PatientAllergy>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_PATIENT_ALLERGY;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst())
		{
			do
			{
				PatientAllergy patientAllergy = new PatientAllergy();

				patientAllergy.setAllergyID(cursor.getLong(0));
				patientAllergy.setPatientID(cursor.getLong(1));

				patientAllergyList.add(patientAllergy);

			} while (cursor.moveToNext());
		}
		return patientAllergyList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#getConectorPrescription(long, long)
	 */
	@Override
	public Prescription getConectorPrescription(long treatmentID,
			long medicineID) throws Exception
	{
		ArrayList<Prescription> prescriptions = getPrescriptionList();

		for (Prescription prescriptionItem : prescriptions)
			if (prescriptionItem.getPrescriptionTreatmentID() == treatmentID
					&& prescriptionItem.getPrescriptionMedicineID() == medicineID)
				return prescriptionItem;

		throw new Exception("אין קישור בין תרופה זו וטיפול זה!");
	}

	// endregion

	private ArrayList<Prescription> getPrescriptionList() throws Exception
	{
		ArrayList<Prescription> prescriptionList = new ArrayList<Prescription>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_PRESCRIPTION;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst())
		{
			do
			{
				Prescription prescription = new Prescription();

				prescription.setPrescriptionTreatmentID(cursor.getLong(0));
				prescription.setPrescriptionMedicineID(cursor.getLong(1));
				prescription.setPrescriptionMedicineExperationDate(dateFormat
						.parse(cursor.getString(2)));

				prescriptionList.add(prescription);

			} while (cursor.moveToNext());
		}

		return prescriptionList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.backend.Backend#checkPassword(long, java.lang.String)
	 */
	@Override
	public Permit checkPassword(long loginID, String password) throws Exception
	{
		ArrayList<Password> passwords = getPasswordList();

		for (Password passwordItem : passwords)
			if (passwordItem.getPasswordUserID() == loginID
					&& passwordItem.getPasswordWord().equals(password))
				return passwordItem.getPasswordPermit();

		throw new Exception("שם משתמש או סיסמה שגויה!");
	}

	private ArrayList<Password> getPasswordList()
	{
		ArrayList<Password> passwordList = new ArrayList<Password>();
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_PASSWORD;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst())
		{
			do
			{
				Password password = new Password();

				password.setPasswordUserID(cursor.getLong(0));
				password.setPasswordWord(cursor.getString(1));
				password.setPasswordPermit(Permit.valueOf(cursor.getString(2)));

				passwordList.add(password);

			} while (cursor.moveToNext());
		}

		return passwordList;
	}

	@Override
	public boolean isEmpty() throws Exception
	{
		String selectQuery = "SELECT * FROM " + SQLNAME.TABLE_DOCTOR;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) // Always one row returned.
		{
		    if (cursor.getLong(0) == 0) // Zero count means empty table.
		    	return true;
		    return false;
		}
		return true;
	}
}
