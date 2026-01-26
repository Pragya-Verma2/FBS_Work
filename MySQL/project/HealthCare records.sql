-- 1. DATABASE CREATION
------------------------------------------------------
CREATE DATABASE HealthCareRecord;
USE HealthCareRecord;

-- 2. TABLE CREATION (DDL)
--------------------------------------------------------

-- =======================================
-- 1. PATIENT
-- =======================================
CREATE TABLE Patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    age INT CHECK (age >= 0),
    blood_type VARCHAR(10),
    phone_no VARCHAR(15) UNIQUE,
    alternative_mno VARCHAR(15),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- =======================================
-- 2. DOCTOR
-- =======================================
CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    doctor_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_no VARCHAR(15),
    specialty VARCHAR(100)
);

-- =======================================
-- 3. DOCTOR SCHEDULES
-- =======================================
CREATE TABLE DoctorSchedules (
    schedule_id INT PRIMARY KEY AUTO_INCREMENT,
    doctor_id INT NOT NULL,
    day_of_week VARCHAR(15) NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 4. APPOINTMENTS
-- =======================================
CREATE TABLE Appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    reason Text,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 5. MEDICATION
-- =======================================
CREATE TABLE Medication (
    medication_id INT PRIMARY KEY AUTO_INCREMENT,
    medication_name VARCHAR(100) NOT NULL,
    medication_type VARCHAR(50),
    strength VARCHAR(50),
     patient_id INT NOT NULL,
	FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 6. PRESCRIPTIONS
-- =======================================
CREATE TABLE Prescriptions (
    prescription_id INT PRIMARY KEY AUTO_INCREMENT,
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    issued_on DATE DEFAULT (CURRENT_DATE),
    notes Text,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 7. PRESCRIPTION ITEM
-- =======================================
CREATE TABLE Prescription_Item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    prescription_id INT NOT NULL,
    medication_id INT NOT NULL,
    dosage VARCHAR(50),
    frequency VARCHAR(50),
    duration_days INT CHECK (duration_days > 0),
    FOREIGN KEY (prescription_id) REFERENCES Prescriptions(prescription_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (medication_id) REFERENCES Medication(medication_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 8. HOSPITALIZATION
-- =======================================
CREATE TABLE Hospitalization (
    hospitalization_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    reason VARCHAR(255),
    admission_date DATE NOT NULL,
    discharge_date DATE,
    admitted_to VARCHAR(100),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 9. BILLING
-- =======================================
CREATE TABLE Billing (
    bill_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    date_issued DATE DEFAULT (CURRENT_DATE),
    total_amount DECIMAL(10,2) CHECK (total_amount >= 0),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 10. PAYMENT
-- =======================================
CREATE TABLE Payment (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    bill_id INT NOT NULL,
    payment_date DATE DEFAULT (CURRENT_DATE),
    amount DECIMAL(10,2) CHECK (amount >= 0),
    method VARCHAR(50) NOT NULL,
    FOREIGN KEY (bill_id) REFERENCES Billing(bill_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 16. ENCOUNTER
-- =======================================
CREATE TABLE Encounter (
    encounter_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    encounter_type VARCHAR(50),
    visit_date_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    reason VARCHAR(255),
    location VARCHAR(100),
    status VARCHAR(50),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
-- =======================================
-- 11. RECORDS
-- =======================================
CREATE TABLE Records (
    record_id INT PRIMARY KEY AUTO_INCREMENT,
    diagnosis VARCHAR(255),
    treatment VARCHAR(255),
    date_of_visit DATE NOT NULL,
	encounter_id int not null,
	FOREIGN KEY (encounter_id) REFERENCES Encounter(encounter_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 12. MEDICAL PROCEDURES
-- =======================================
CREATE TABLE Medical_Procedures (
    procedure_id INT PRIMARY KEY AUTO_INCREMENT,
    record_id INT NOT NULL,
    procedure_name VARCHAR(100) NOT NULL,
    procedure_date DATE,
    FOREIGN KEY (record_id) REFERENCES Records(record_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 13. SURGERIES
-- =======================================
CREATE TABLE Surgeries (
    surgery_id INT PRIMARY KEY AUTO_INCREMENT,
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    surgery_type VARCHAR(100),
    surgery_date DATE,
    outcome VARCHAR(255),
    notes VARCHAR(255),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 14. VACCINATION
-- =======================================
CREATE TABLE Vaccination (
    vaccination_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    vaccination_name VARCHAR(100),
    date_administered DATE,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 15. ALLERGIES
-- =======================================
CREATE TABLE Allergies (
    allergy_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    allergy_name VARCHAR(100),
    reaction VARCHAR(255),
    severity VARCHAR(50),
    recorded_on DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);



-- =======================================
-- 17. DIAGNOSTIC TESTS
-- =======================================
CREATE TABLE Diagnostic_Tests (
    test_id INT PRIMARY KEY AUTO_INCREMENT,
    record_id INT NOT NULL,
    test_name VARCHAR(100),
    test_type VARCHAR(100),
    test_date DATE,
    status VARCHAR(50),
    reference_range VARCHAR(50),
    FOREIGN KEY (record_id) REFERENCES Records(record_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- =======================================
-- 18. INSURANCE
-- =======================================
CREATE TABLE Insurance (
    insurance_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    provider_name VARCHAR(100),
    policy_number VARCHAR(50) UNIQUE,
    valid_from DATE,
    valid_to DATE,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
        ON DELETE CASCADE ON UPDATE CASCADE
);
-- =======================================
-- 19. INSURANCE
-- =======================================
CREATE TABLE test_result (
    result_id INT AUTO_INCREMENT PRIMARY KEY,
    test_id INT NOT NULL,
    result_text VARCHAR(255),
    numeric_value DECIMAL(10,2),
    units VARCHAR(50),
    reference_range VARCHAR(50),
    interpretation VARCHAR(255),
    result_datetime DATETIME,
    FOREIGN KEY (test_id) REFERENCES Diagnostic_Tests(test_id) ON DELETE CASCADE ON UPDATE CASCADE
);
-- =======================================
-- 20. INSURANCE
-- =======================================

Create Table medical_History (
 medical_history_id int primary key auto_increment,
 duration varchar(225),
 Dosage varchar(255),
 prescriptionDate date,
 patient_id int not null,
 FOREIGN KEY (patient_id) REFERENCES patient(patient_id) ON DELETE CASCADE ON UPDATE CASCADE
);


-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

INSERT INTO Patient (patient_name, gender, age, blood_type, phone_no, alternative_mno, created_at) VALUES
('Aarav Sharma', 'Male', 25, 'B+', '9876543201', '9823456701', '2025-01-12'),
('Isha Patel', 'Female', 28, 'O+', '9876543202', '9823456702', '2025-02-18'),
('Rohan Singh', 'Male', 32, 'A+', '9876543203', '9823456703', '2025-03-21'),
('Neha Verma', 'Female', 22, 'AB+', '9876543204', '9823456704', '2025-04-01'),
('Karan Mehta', 'Male', 40, 'O-', '9876543205', '9823456705', '2025-04-12'),
('Simran Kaur', 'Female', 30, 'A-', '9876543206', '9823456706', '2025-05-02'),
('Rajiv Nair', 'Male', 35, 'B-', '9876543207', '9823456707', '2025-05-21'),
('Priya Gupta', 'Female', 27, 'O+', '9876543208', '9823456708', '2025-06-01'),
('Vikram Das', 'Male', 38, 'B+', '9876543209', '9823456709', '2025-06-11'),
('Sneha Rao', 'Female', 24, 'A+', '9876543210', '9823456710', '2025-07-05'),
('Ananya Iyer', 'Female', 26, 'B+', '9876543211', '9823456711', '2025-07-15'),
('Manish Yadav', 'Male', 33, 'O+', '9876543212', '9823456712', '2025-07-20'),
('Divya Jain', 'Female', 31, 'AB+', '9876543213', '9823456713', '2025-07-29'),
('Rahul Reddy', 'Male', 29, 'A-', '9876543214', '9823456714', '2025-08-01'),
('Meera Desai', 'Female', 37, 'O+', '9876543215', '9823456715', '2025-08-09'),
('Aditya Bhat', 'Male', 21, 'B-', '9876543216', '9823456716', '2025-08-15'),
('Kavya Kapoor', 'Female', 23, 'A+', '9876543217', '9823456717', '2025-08-22'),
('Nikhil Joshi', 'Male', 45, 'O+', '9876543218', '9823456718', '2025-09-01'),
('Ritika Malhotra', 'Female', 39, 'AB-', '9876543219', '9823456719', '2025-09-10'),
('Aman Tiwari', 'Male', 28, 'B+', '9876543220', '9823456720', '2025-09-18'),
('Sara Khan', 'Female', 25, 'O+', '9876543221', '9823456721', '2025-09-20'),
('Mohit Arora', 'Male', 36, 'A-', '9876543222', '9823456722', '2025-09-28'),
('Tanya Sinha', 'Female', 27, 'O+', '9876543223', '9823456723', '2025-10-01'),
('Ravi Prasad', 'Male', 31, 'B+', '9876543224', '9823456724', '2025-10-05'),
('Preeti Mishra', 'Female', 34, 'AB+', '9876543225', '9823456725', '2025-10-10');

INSERT INTO Doctor (doctor_name, email, phone_no, specialty) VALUES
('Dr. Arjun Nair', 'arjun.nair@hospital.com', '9012300001', 'Cardiologist'),
('Dr. Neha Kapoor', 'neha.kapoor@hospital.com', '9012300002', 'Dermatologist'),
('Dr. Raj Mehta', 'raj.mehta@hospital.com', '9012300003', 'Neurologist'),
('Dr. Simran Gill', 'simran.gill@hospital.com', '9012300004', 'Pediatrician'),
('Dr. Rakesh Verma', 'rakesh.verma@hospital.com', '9012300005', 'Orthopedic'),
('Dr. Aditi Sharma', 'aditi.sharma@hospital.com', '9012300006', 'ENT Specialist'),
('Dr. Vikas Singh', 'vikas.singh@hospital.com', '9012300007', 'Dentist'),
('Dr. Priya Nanda', 'priya.nanda@hospital.com', '9012300008', 'Gynecologist'),
('Dr. Kunal Patil', 'kunal.patil@hospital.com', '9012300009', 'Oncologist'),
('Dr. Sneha Iyer', 'sneha.iyer@hospital.com', '9012300010', 'General Physician'),
('Dr. Amit Rao', 'amit.rao@hospital.com', '9012300011', 'Surgeon'),
('Dr. Pooja Jain', 'pooja.jain@hospital.com', '9012300012', 'Radiologist'),
('Dr. Ravi Joshi', 'ravi.joshi@hospital.com', '9012300013', 'Pathologist'),
('Dr. Tanvi Bansal', 'tanvi.bansal@hospital.com', '9012300014', 'Cardiologist'),
('Dr. Harsh Gupta', 'harsh.gupta@hospital.com', '9012300015', 'Neurologist'),
('Dr. Anil Sinha', 'anil.sinha@hospital.com', '9012300016', 'Endocrinologist'),
('Dr. Ritu Kaur', 'ritu.kaur@hospital.com', '9012300017', 'Dermatologist'),
('Dr. Kiran Menon', 'kiran.menon@hospital.com', '9012300018', 'Psychiatrist'),
('Dr. Ajay Rathore', 'ajay.rathore@hospital.com', '9012300019', 'Urologist'),
('Dr. Nidhi Deshmukh', 'nidhi.deshmukh@hospital.com', '9012300020', 'Pediatrician'),
('Dr. Sunil Chauhan', 'sunil.chauhan@hospital.com', '9012300021', 'Cardiologist'),
('Dr. Reema Aggarwal', 'reema.aggarwal@hospital.com', '9012300022', 'Gynecologist'),
('Dr. Manav Bhatia', 'manav.bhatia@hospital.com', '9012300023', 'ENT Specialist'),
('Dr. Devika Reddy', 'devika.reddy@hospital.com', '9012300024', 'Surgeon'),
('Dr. Abhay Mishra', 'abhay.mishra@hospital.com', '9012300025', 'General Physician');

INSERT INTO DoctorSchedules (doctor_id, day_of_week, start_time, end_time) VALUES
(1, 'Monday', '09:00:00', '13:00:00'),
(1, 'Wednesday', '09:00:00', '13:00:00'),
(2, 'Tuesday', '10:00:00', '14:00:00'),
(3, 'Monday', '08:00:00', '12:00:00'),
(4, 'Friday', '09:00:00', '13:00:00'),
(5, 'Thursday', '11:00:00', '15:00:00'),
(6, 'Saturday', '09:00:00', '13:00:00'),
(7, 'Monday', '10:00:00', '14:00:00'),
(8, 'Wednesday', '08:30:00', '12:30:00'),
(9, 'Friday', '09:30:00', '13:30:00'),
(10, 'Monday', '09:00:00', '12:00:00'),
(11, 'Thursday', '10:00:00', '14:00:00'),
(12, 'Tuesday', '08:00:00', '12:00:00'),
(13, 'Wednesday', '09:00:00', '13:00:00'),
(14, 'Friday', '09:00:00', '12:30:00'),
(15, 'Monday', '08:30:00', '12:30:00'),
(16, 'Saturday', '10:00:00', '14:00:00'),
(17, 'Tuesday', '09:00:00', '13:00:00'),
(18, 'Thursday', '08:30:00', '12:30:00'),
(19, 'Friday', '09:00:00', '13:00:00'),
(20, 'Monday', '09:30:00', '13:30:00'),
(21, 'Wednesday', '08:00:00', '12:00:00'),
(22, 'Thursday', '09:00:00', '13:00:00'),
(23, 'Friday', '10:00:00', '14:00:00'),
(24, 'Saturday', '09:00:00', '13:00:00'),
(25, 'Tuesday', '08:30:00', '12:30:00');

INSERT INTO Medication (patient_id, medication_name, medication_type, strength) VALUES
(1, 'Paracetamol', 'Tablet', '500mg'),
(2, 'Amoxicillin', 'Capsule', '250mg'),
(3, 'Cetirizine', 'Tablet', '10mg'),
(4, 'Metformin', 'Tablet', '500mg'),
(5, 'Omeprazole', 'Capsule', '20mg'),
(6, 'Azithromycin', 'Tablet', '500mg'),
(7, 'Losartan', 'Tablet', '50mg'),
(8, 'Amlodipine', 'Tablet', '5mg'),
(9, 'Ibuprofen', 'Tablet', '400mg'),
(10, 'Atorvastatin', 'Tablet', '10mg'),
(11, 'Prednisolone', 'Tablet', '20mg'),
(12, 'Folic Acid', 'Tablet', '5mg'),
(13, 'Vitamin D3', 'Capsule', '60000IU'),
(14, 'Ranitidine', 'Tablet', '150mg'),
(15, 'Ciprofloxacin', 'Tablet', '500mg'),
(16, 'Insulin', 'Injection', '10ml'),
(17, 'Pantoprazole', 'Tablet', '40mg'),
(18, 'Salbutamol', 'Inhaler', '100mcg'),
(19, 'Doxycycline', 'Capsule', '100mg'),
(20, 'Levothyroxine', 'Tablet', '50mcg'),
(21, 'Chlorpheniramine', 'Tablet', '4mg'),
(22, 'Amphotericin B', 'Injection', '50mg'),
(23, 'Domperidone', 'Tablet', '10mg'),
(24, 'Clindamycin', 'Capsule', '300mg'),
(25, 'Vitamin B12', 'Injection', '1mg');

INSERT INTO Hospitalization (patient_id, reason, admission_date, discharge_date, admitted_to) VALUES
(1, 'Fever', '2025-09-01', '2025-09-03', 'General Ward'),
(2, 'Accident', '2025-09-02', '2025-09-05', 'ICU'),
(3, 'Surgery', '2025-09-02', '2025-09-06', 'Surgery Ward'),
(4, 'Heart issue', '2025-09-03', '2025-09-07', 'Cardiology'),
(5, 'Infection', '2025-09-03', '2025-09-04', 'General Ward'),
(6, 'Diabetes', '2025-09-04', '2025-09-08', 'Diabetic Ward'),
(7, 'Fracture', '2025-09-05', '2025-09-09', 'Orthopedic'),
(8, 'Migraine', '2025-09-05', '2025-09-06', 'General Ward'),
(9, 'Asthma', '2025-09-06', '2025-09-08', 'Respiratory'),
(10, 'Appendix', '2025-09-07', '2025-09-10', 'Surgery Ward'),
(11, 'Burns', '2025-09-08', '2025-09-15', 'Burn Unit'),
(12, 'Anemia', '2025-09-09', '2025-09-12', 'Hematology'),
(13, 'Eye infection', '2025-09-09', '2025-09-10', 'Ophthalmology'),
(14, 'Dental surgery', '2025-09-10', '2025-09-11', 'Dental'),
(15, 'Allergy', '2025-09-11', '2025-09-12', 'Allergy Unit'),
(16, 'Hypertension', '2025-09-11', '2025-09-13', 'Cardiology'),
(17, 'Liver issue', '2025-09-12', '2025-09-14', 'Gastro'),
(18, 'Fever', '2025-09-13', '2025-09-15', 'General Ward'),
(19, 'Fatigue', '2025-09-14', '2025-09-15', 'General Ward'),
(20, 'Head injury', '2025-09-15', '2025-09-20', 'Neuro Ward'),
(21, 'Infection', '2025-09-16', '2025-09-18', 'General Ward'),
(22, 'Blood loss', '2025-09-17', '2025-09-20', 'ICU'),
(23, 'Surgery', '2025-09-17', '2025-09-21', 'Surgery Ward'),
(24, 'Accident', '2025-09-18', '2025-09-20', 'Trauma'),
(25, 'Asthma', '2025-09-19', '2025-09-22', 'Respiratory');

INSERT INTO Billing (patient_id, date_issued, total_amount) VALUES
(1, '2025-09-03', 1500.00),
(2, '2025-09-05', 12000.00),
(3, '2025-09-06', 5000.00),
(4, '2025-09-07', 8500.00),
(5, '2025-09-04', 2000.00),
(6, '2025-09-08', 3200.00),
(7, '2025-09-09', 4600.00),
(8, '2025-09-06', 1500.00),
(9, '2025-09-08', 4000.00),
(10, '2025-09-10', 9200.00),
(11, '2025-09-15', 7000.00),
(12, '2025-09-12', 1800.00),
(13, '2025-09-10', 1300.00),
(14, '2025-09-11', 2400.00),
(15, '2025-09-12', 1600.00),
(16, '2025-09-13', 3000.00),
(17, '2025-09-14', 4100.00),
(18, '2025-09-15', 1700.00),
(19, '2025-09-15', 2500.00),
(20, '2025-09-20', 7500.00),
(21, '2025-09-18', 2100.00),
(22, '2025-09-20', 5200.00),
(23, '2025-09-21', 9300.00),
(24, '2025-09-20', 4500.00),
(25, '2025-09-22', 3100.00);

INSERT INTO Payment (bill_id, payment_date, amount, method) VALUES
(1, '2025-09-04', 1500.00, 'Cash'),
(2, '2025-09-05', 12000.00, 'Card'),
(3, '2025-09-06', 5000.00, 'UPI'),
(4, '2025-09-07', 8500.00, 'Online Transfer'),
(5, '2025-09-05', 2000.00, 'Cash'),
(6, '2025-09-08', 3200.00, 'Card'),
(7, '2025-09-09', 4600.00, 'UPI'),
(8, '2025-09-06', 1500.00, 'Cash'),
(9, '2025-09-08', 4000.00, 'Card'),
(10, '2025-09-10', 9200.00, 'UPI'),
(11, '2025-09-15', 7000.00, 'Cash'),
(12, '2025-09-12', 1800.00, 'Card'),
(13, '2025-09-10', 1300.00, 'UPI'),
(14, '2025-09-11', 2400.00, 'Online Transfer'),
(15, '2025-09-12', 1600.00, 'Cash'),
(16, '2025-09-13', 3000.00, 'Card'),
(17, '2025-09-14', 4100.00, 'UPI'),
(18, '2025-09-15', 1700.00, 'Cash'),
(19, '2025-09-15', 2500.00, 'Card'),
(20, '2025-09-20', 7500.00, 'Online Transfer'),
(21, '2025-09-18', 2100.00, 'UPI'),
(22, '2025-09-20', 5200.00, 'Cash'),
(23, '2025-09-21', 9300.00, 'Card'),
(24, '2025-09-20', 4500.00, 'Online Transfer'),
(25, '2025-09-22', 3100.00, 'UPI');

INSERT INTO Vaccination (patient_id, vaccination_name, date_administered) VALUES
(1, 'Flu Shot', '2025-08-01'),
(2, 'Hepatitis B', '2025-08-02'),
(3, 'COVID-19 Booster', '2025-08-03'),
(4, 'Tetanus', '2025-08-03'),
(5, 'Typhoid', '2025-08-04'),
(6, 'Polio', '2025-08-05'),
(7, 'MMR', '2025-08-05'),
(8, 'HPV', '2025-08-06'),
(9, 'Flu Shot', '2025-08-06'),
(10, 'COVID-19 Booster', '2025-08-07'),
(11, 'Hepatitis B', '2025-08-07'),
(12, 'Polio', '2025-08-08'),
(13, 'Tetanus', '2025-08-08'),
(14, 'Typhoid', '2025-08-09'),
(15, 'HPV', '2025-08-09'),
(16, 'MMR', '2025-08-10'),
(17, 'COVID-19 Booster', '2025-08-10'),
(18, 'Flu Shot', '2025-08-11'),
(19, 'Polio', '2025-08-11'),
(20, 'Typhoid', '2025-08-12'),
(21, 'HPV', '2025-08-12'),
(22, 'Tetanus', '2025-08-13'),
(23, 'MMR', '2025-08-13'),
(24, 'COVID-19 Booster', '2025-08-14'),
(25, 'Flu Shot', '2025-08-14');

INSERT INTO Allergies (patient_id, allergy_name, reaction, severity, recorded_on) VALUES
(1, 'Dust', 'Sneezing', 'Mild', '2025-08-01'),
(2, 'Pollen', 'Cough', 'Moderate', '2025-08-01'),
(3, 'Milk', 'Rash', 'High', '2025-08-02'),
(4, 'Peanut', 'Swelling', 'Severe', '2025-08-02'),
(5, 'Fish', 'Rash', 'Moderate', '2025-08-03'),
(6, 'Egg', 'Vomiting', 'High', '2025-08-03'),
(7, 'Dust', 'Sneezing', 'Mild', '2025-08-04'),
(8, 'Pollution', 'Breathing issue', 'High', '2025-08-04');

INSERT INTO Surgeries (doctor_id, patient_id, surgery_type, surgery_date, outcome, notes) VALUES
(1, 1, 'Appendectomy', '2025-01-21', 'Successful', 'No complications'),
(2, 2, 'Cataract Surgery', '2025-02-04', 'Successful', 'Patient advised rest'),
(4, 4, 'Hernia Repair', '2025-02-16', 'Successful', 'Sutures removed after 10 days'),
(25, 5, 'Knee Replacement', '2025-02-21', 'Successful', 'Physiotherapy advised'),
(6, 6, 'Hip Replacement', '2025-02-26', 'Successful', 'Patient using walker'),
(2, 7, 'Heart Bypass', '2025-03-02', 'Successful', 'ICU stay 3 days'),
(8,8, 'Tonsillectomy', '2025-03-06', 'Successful', 'Mild throat pain'),
(9, 9, 'C-Section', '2025-03-09', 'Successful', 'Mother and baby healthy'),
(21, 10, 'Hysterectomy', '2025-03-11', 'Successful', 'No complications'),
(1, 1, 'Prostate Surgery', '2025-03-13', 'Successful', 'Catheter removed after 3 days'),
(22, 12, 'Lung Surgery', '2025-03-15', 'Successful', 'Patient advised breathing exercises'),
(13, 13, 'Liver Surgery', '2025-03-17', 'Successful', 'Minor bleeding observed'),
(14, 14, 'Kidney Transplant', '2025-03-19', 'Successful', 'Patient on immunosuppressants'),
(25, 15, 'Spinal Surgery', '2025-03-21', 'Successful', 'Physical therapy recommended'),
(16, 16, 'Eye Laser Surgery', '2025-03-23', 'Successful', 'Vision improved'),
(17, 17, 'Dental Surgery', '2025-03-25', 'Successful', 'Pain managed with medication'),
(18, 18, 'Sinus Surgery', '2025-03-27', 'Successful', 'Patient advised nasal irrigation'),
(19, 19, 'Skin Graft', '2025-03-29', 'Successful', 'Dressing changed daily'),
(20, 20, 'Heart Valve Replacement', '2025-03-31', 'Successful', 'Anticoagulants prescribed'),
(20, 1, 'Bariatric Surgery', '2025-04-02', 'Successful', 'Dietary plan advised'),
(2, 12, 'Arthroscopy', '2025-04-04', 'Successful', 'Physiotherapy advised'),
(23, 3, 'Cleft Lip Repair', '2025-04-06', 'Successful', 'Sutures removed after 7 days'),
(22, 24, 'Hernia Repair', '2025-01-12', 'Successful', 'No complications'),
(25, 25, 'Tonsillectomy', '2025-01-17', 'Successful', 'Patient advised rest');

INSERT INTO Encounter (patient_id, doctor_id, encounter_type, visit_date_time, reason, location, status) VALUES
(1, 1, 'Consultation', '2025-01-10 09:00:00', 'Fever and cold', 'General Ward', 'Completed'),
(2, 2, 'Follow-up', '2025-01-15 10:30:00', 'Blood test review', 'Outpatient Clinic', 'Completed'),
(3, 3, 'Consultation', '2025-01-22 11:00:00', 'Chest pain', 'Cardiology', 'Completed'),
(4, 4, 'Emergency', '2025-02-02 14:15:00', 'Abdominal pain', 'ER', 'Completed'),
(5, 5, 'Consultation', '2025-02-09 08:45:00', 'Back pain', 'Orthopedic', 'Completed'),
(6, 6, 'Consultation', '2025-02-14 10:00:00', 'Routine checkup', 'General Ward', 'Completed'),
(7, 7, 'Follow-up', '2025-02-19 09:30:00', 'Post-surgery review', 'Surgery Ward', 'Completed'),
(8, 8, 'Consultation', '2025-02-24 13:00:00', 'Skin rash', 'Dermatology', 'Completed'),
(9, 9, 'Emergency', '2025-02-28 16:00:00', 'Accident injury', 'ER', 'Completed'),
(10, 10, 'Consultation', '2025-03-04 11:15:00', 'Eye irritation', 'Ophthalmology', 'Completed'),
(11, 11, 'Consultation', '2025-03-07 09:45:00', 'Dental pain', 'Dental Clinic', 'Completed'),
(12, 12, 'Follow-up', '2025-03-09 10:30:00', 'Blood pressure review', 'Outpatient Clinic', 'Completed'),
(13, 13, 'Consultation', '2025-03-11 12:00:00', 'Diabetes check', 'General Ward', 'Completed'),
(14, 14, 'Consultation', '2025-03-13 14:30:00', 'Liver function review', 'Gastroenterology', 'Completed'),
(15, 15, 'Follow-up', '2025-03-15 09:00:00', 'Physiotherapy review', 'Physio Ward', 'Completed'),
(16, 16, 'Consultation', '2025-03-17 10:15:00', 'Kidney function test', 'Nephrology', 'Completed'),
(17, 17, 'Consultation', '2025-03-19 11:30:00', 'Allergy testing', 'Allergy Clinic', 'Completed'),
(18, 18, 'Consultation', '2025-03-21 08:45:00', 'Vaccination', 'Immunization Clinic', 'Completed'),
(19, 19, 'Follow-up', '2025-03-23 09:30:00', 'Blood sugar monitoring', 'General Ward', 'Completed'),
(20, 20, 'Consultation', '2025-03-25 10:00:00', 'Heart checkup', 'Cardiology', 'Completed'),
(21, 21, 'Consultation', '2025-03-27 12:15:00', 'Pulmonary assessment', 'Pulmonology', 'Completed'),
(22, 22, 'Follow-up', '2025-03-29 13:45:00', 'Post-op review', 'Surgery Ward', 'Completed'),
(23, 23, 'Consultation', '2025-03-31 11:00:00', 'Dental cleaning', 'Dental Clinic', 'Completed'),
(24, 24, 'Consultation', '2025-04-02 09:30:00', 'Skin check', 'Dermatology', 'Completed'),
(25, 25, 'Emergency', '2025-04-04 15:00:00', 'Fracture', 'ER', 'Completed');



INSERT INTO Records (encounter_id, diagnosis, treatment, date_of_visit) VALUES
(1, 'Common Cold', 'Rest and Paracetamol', '2025-01-10'),
(2, 'Fever', 'Antibiotics', '2025-01-15'),
(3, 'Diabetes', 'Metformin', '2025-01-22'),
(4, 'Hypertension', 'Losartan', '2025-02-01'),
(5, 'Stomach Ulcer', 'Omeprazole', '2025-02-10'),
(6, 'Allergy', 'Cetirizine', '2025-02-14'),
(7, 'Asthma', 'Inhaler', '2025-02-20'),
(8, 'Vitamin Deficiency', 'Supplements', '2025-02-28'),
(9, 'Toothache', 'Painkillers', '2025-03-01'),
(10, 'Skin Rash', 'Ointment', '2025-03-05'),
(11, 'Headache', 'Paracetamol', '2025-03-10'),
(12, 'Flu', 'Rest and Fluids', '2025-03-15'),
(13, 'High Cholesterol', 'Atorvastatin', '2025-03-18'),
(14, 'Sore Throat', 'Antibiotics', '2025-03-21'),
(15, 'Fracture', 'Surgery', '2025-03-25'),
(16, 'Thyroid Issue', 'Levothyroxine', '2025-04-01'),
(17, 'Heart Pain', 'ECG and Medication', '2025-04-05'),
(18, 'Migraine', 'Pain Relief', '2025-04-09'),
(19, 'Sinus', 'Decongestants', '2025-04-15'),
(20, 'Anemia', 'Iron Tablets', '2025-04-20'),
(21, 'Bronchitis', 'Antibiotics', '2025-04-25'),
(22, 'Indigestion', 'Ranitidine', '2025-04-30'),
(23, 'Eye Infection', 'Eye Drops', '2025-05-05'),
(24, 'Joint Pain', 'Painkillers', '2025-05-10'),
(25, 'Cough', 'Syrup', '2025-05-15');


INSERT INTO Diagnostic_Tests (record_id, test_name, test_type, test_date, status, reference_range) VALUES
(26, 'Blood Test', 'Hematology', '2025-01-11', 'Normal', '4.0-11.0 x10^9/L'),
(27, 'X-Ray', 'Radiology', '2025-01-16', 'Fracture Detected', 'N/A'),
(28, 'ECG', 'Cardiology', '2025-01-23', 'Normal', '60-100 bpm'),
(26, 'Ultrasound', 'Radiology', '2025-02-03', 'Gallstones', 'N/A'),
(27, 'MRI Scan', 'Radiology', '2025-02-10', 'Normal', 'N/A'),
(28, 'CT Scan', 'Radiology', '2025-02-15', 'Normal', 'N/A'),
(29, 'Allergy Test', 'Immunology', '2025-02-20', 'Mild Allergies', 'Negative'),
(30, 'Eye Test', 'Ophthalmology', '2025-02-25', 'Myopia', '20/20'),
(31, 'Hearing Test', 'ENT', '2025-03-01', 'Normal', '0-20 dB'),
(32, 'Blood Sugar Test', 'Biochemistry', '2025-03-05', 'High', '70-110 mg/dL'),
(33, 'Cholesterol Test', 'Biochemistry', '2025-03-08', 'Borderline', '125-200 mg/dL'),
(34, 'Kidney Function Test', 'Biochemistry', '2025-03-10', 'Normal', '0.6-1.3 mg/dL'),
(35, 'Liver Function Test', 'Biochemistry', '2025-03-12', 'Normal', '7-56 U/L'),
(36, 'Stress Test', 'Cardiology', '2025-03-14', 'Normal', 'N/A'),
(36, 'Vaccination Booster', 'Immunology', '2025-03-16', 'Completed', 'N/A'),
(37, 'Bone Density Test', 'Orthopedic', '2025-03-18', 'Low', 'T-score -1 to -2.5'),
(38, 'Urine Test', 'Biochemistry', '2025-03-20', 'Normal', 'Specific gravity 1.005-1.030'),
(39, 'Pulmonary Test', 'Pulmonology', '2025-03-22', 'Normal', 'FEV1 80-120%'),
(40, 'Endoscopy', 'Gastroenterology', '2025-03-24', 'Normal', 'N/A'),
(41, 'Colonoscopy', 'Gastroenterology', '2025-03-26', 'Polyp Found', 'N/A'),
(42, 'Dental X-Ray', 'Dental', '2025-03-28', 'Cavity', 'N/A'),
(37, 'Skin Biopsy', 'Dermatology', '2025-03-30', 'Benign', 'N/A'),
(38, 'CT Angiography', 'Cardiology', '2025-04-01', 'Normal', 'N/A'),
(26, 'MRI Brain', 'Neurology', '2025-04-03', 'Normal', 'N/A'),
(27, 'Thyroid Test', 'Endocrinology', '2025-04-05', 'Normal', '0.4-4.0 mIU/L');


INSERT INTO test_result (test_id, result_text, numeric_value, units, reference_range, interpretation, result_datetime) VALUES
(26, 'WBC Count Normal', 7.5, 'x10^9/L', '4.0-11.0 x10^9/L', 'Normal', '2025-01-11 09:00:00'),
(27, 'Fracture Observed', NULL, NULL, 'N/A', 'Abnormal', '2025-01-16 10:00:00'),
(28, 'ECG Normal', NULL, NULL, '60-100 bpm', 'Normal', '2025-01-23 11:00:00'),
(29, 'Gallstones detected', NULL, NULL, 'N/A', 'Abnormal', '2025-02-03 14:00:00'),
(30, 'MRI Normal', NULL, NULL, 'N/A', 'Normal', '2025-02-10 12:00:00'),
(31, 'CT Scan Normal', NULL, NULL, 'N/A', 'Normal', '2025-02-15 13:30:00'),
(74, 'Mild Allergies', NULL, NULL, 'Negative', 'Mild', '2025-02-20 09:30:00'),
(56, 'Myopia detected', NULL, NULL, '20/20', 'Abnormal', '2025-02-25 10:15:00'),
(28, 'Hearing Normal', NULL, NULL, '0-20 dB', 'Normal', '2025-03-01 11:45:00'),
(37, 'High blood sugar', 150, 'mg/dL', '70-110 mg/dL', 'Abnormal', '2025-03-05 08:30:00'),
(31, 'Borderline Cholesterol', 210, 'mg/dL', '125-200 mg/dL', 'Borderline', '2025-03-08 09:00:00'),
(42, 'Kidney Function Normal', 1.1, 'mg/dL', '0.6-1.3 mg/dL', 'Normal', '2025-03-10 10:30:00'),
(53, 'Liver Function Normal', 40, 'U/L', '7-56 U/L', 'Normal', '2025-03-12 11:00:00'),
(64, 'Stress Test Normal', NULL, NULL, 'N/A', 'Normal', '2025-03-14 14:00:00'),
(65, 'Vaccination Completed', NULL, NULL, 'N/A', 'Normal', '2025-03-16 08:45:00'),
(46, 'Bone Density Low', -2.0, 'T-score', '-1 to -2.5', 'Abnormal', '2025-03-18 09:15:00'),
(37, 'Urine Normal', NULL, NULL, '1.005-1.030', 'Normal', '2025-03-20 10:00:00'),
(28, 'Pulmonary Normal', 95, '%', '80-120%', 'Normal', '2025-03-22 11:30:00'),
(29, 'Endoscopy Normal', NULL, NULL, 'N/A', 'Normal', '2025-03-24 12:00:00'),
(50, 'Polyp Found', NULL, NULL, 'N/A', 'Abnormal', '2025-03-26 13:00:00'),
(51, 'Cavity Observed', NULL, NULL, 'N/A', 'Abnormal', '2025-03-28 09:45:00'),
(52, 'Skin Biopsy Benign', NULL, NULL, 'N/A', 'Normal', '2025-03-30 10:15:00'),
(53, 'CT Angiography Normal', NULL, NULL, 'N/A', 'Normal', '2025-04-01 11:00:00'),
(54, 'MRI Brain Normal', NULL, NULL, 'N/A', 'Normal', '2025-04-03 08:30:00'),
(55, 'Thyroid Test Normal', 2.5, 'mIU/L', '0.4-4.0', 'Normal', '2025-04-05 09:00:00');

INSERT INTO medical_History (duration, Dosage, prescriptionDate, patient_id) VALUES
('5 days', 'Paracetamol 500mg', '2025-01-10', 1),
('10 days', 'Amoxicillin 250mg', '2025-01-12', 2),
('7 days', 'Ibuprofen 400mg', '2025-01-15', 3),
('3 days', 'Cetirizine 10mg', '2025-01-18', 4),
('14 days', 'Metformin 500mg', '2025-01-20', 5),
('5 days', 'Omeprazole 20mg', '2025-01-22', 6),
('7 days', 'Aspirin 75mg', '2025-01-25', 7),
('10 days', 'Azithromycin 500mg', '2025-01-28', 8),
('5 days', 'Losartan 50mg', '2025-01-30', 9),
('3 days', 'Salbutamol 2mg', '2025-02-02', 10),
('14 days', 'Prednisone 10mg', '2025-02-05', 11),
('7 days', 'Amoxicillin-Clavulanate 625mg', '2025-02-08', 12),
('5 days', 'Metoprolol 50mg', '2025-02-10', 13),
('10 days', 'Cefixime 200mg', '2025-02-12', 14),
('7 days', 'Loratadine 10mg', '2025-02-15', 15),
('3 days', 'Hydrochlorothiazide 25mg', '2025-02-18', 16),
('14 days', 'Simvastatin 20mg', '2025-02-20', 17),
('5 days', 'Clindamycin 300mg', '2025-02-22', 18),
('7 days', 'Tramadol 50mg', '2025-02-25', 19),
('10 days', 'Levofloxacin 500mg', '2025-02-28', 20),
('3 days', 'Furosemide 40mg', '2025-03-02', 21),
('5 days', 'Ranitidine 150mg', '2025-03-05', 22),
('7 days', 'Doxycycline 100mg', '2025-03-08', 23),
('14 days', 'Amlodipine 5mg', '2025-03-10', 24),
('10 days', 'Clarithromycin 500mg', '2025-03-12', 25);

INSERT INTO insurance (patient_id, provider_name, policy_number, valid_from, valid_to) VALUES
(1, 'Apollo Insurance', 'AP12345', '2025-01-01', '2026-01-01'),
(2, 'Star Health', 'SH23456', '2025-02-01', '2026-02-01'),
(3, 'Religare Health', 'RH34567', '2025-03-01', '2026-03-01'),
(4, 'ICICI Lombard', 'IL45678', '2025-01-15', '2026-01-15'),
(5, 'HDFC Ergo', 'HE56789', '2025-02-10', '2026-02-10'),
(6, 'Bajaj Allianz', 'BA67890', '2025-03-05', '2026-03-05'),
(7, 'Max Bupa', 'MB78901', '2025-01-20', '2026-01-20'),
(8, 'Tata AIG', 'TA89012', '2025-02-15', '2026-02-15'),
(9, 'SBI General', 'SG90123', '2025-03-10', '2026-03-10'),
(10, 'Future Generali', 'FG01234', '2025-01-25', '2026-01-25'),
(11, 'Apollo Insurance', 'AP11223', '2025-02-05', '2026-02-05'),
(12, 'Star Health', 'SH22334', '2025-03-01', '2026-03-01'),
(13, 'Religare Health', 'RH33445', '2025-01-10', '2026-01-10'),
(14, 'ICICI Lombard', 'IL44556', '2025-02-20', '2026-02-20'),
(15, 'HDFC Ergo', 'HE55667', '2025-03-15', '2026-03-15'),
(16, 'Bajaj Allianz', 'BA66778', '2025-01-05', '2026-01-05'),
(17, 'Max Bupa', 'MB77889', '2025-02-12', '2026-02-12'),
(18, 'Tata AIG', 'TA88990', '2025-03-08', '2026-03-08'),
(19, 'SBI General', 'SG99001', '2025-01-18', '2026-01-18'),
(20, 'Future Generali', 'FG10112', '2025-02-25', '2026-02-25'),
(21, 'Apollo Insurance', 'AP12123', '2025-03-05', '2026-03-05'),
(22, 'Star Health', 'SH23234', '2025-01-12', '2026-01-12'),
(23, 'Religare Health', 'RH34345', '2025-02-18', '2026-02-18'),
(24, 'ICICI Lombard', 'IL45456', '2025-03-20', '2026-03-20'),
(25, 'HDFC Ergo', 'HE56567', '2025-01-22', '2026-01-22');

INSERT INTO appointments (doctor_id, patient_id, appointment_date, reason) VALUES
(1, 1, '2025-05-01 10:00:00', 'Routine Checkup'),
(2, 2, '2025-05-01 11:00:00', 'Fever and Cold'),
(3, 3, '2025-05-02 09:30:00', 'Back Pain'),
(1, 4, '2025-05-02 14:00:00', 'Blood Pressure Check'),
(2, 5, '2025-05-03 10:15:00', 'Diabetes Follow-up'),
(3, 6, '2025-05-03 11:45:00', 'Skin Rash'),
(4, 7, '2025-05-04 13:00:00', 'Allergy Consultation'),
(5, 8, '2025-05-04 15:30:00', 'Migraine'),
(1, 9, '2025-05-05 10:00:00', 'Flu Symptoms'),
(2, 10, '2025-05-05 12:00:00', 'Routine Blood Test'),
(3, 11, '2025-05-06 09:00:00', 'Joint Pain'),
(4, 12, '2025-05-06 11:30:00', 'Eye Checkup'),
(5, 13, '2025-05-07 14:00:00', 'Ear Pain'),
(1, 14, '2025-05-07 16:00:00', 'Vaccination'),
(2, 15, '2025-05-08 10:00:00', 'Chest Pain'),
(3, 16, '2025-05-08 13:30:00', 'Stomach Ache'),
(4, 17, '2025-05-09 09:45:00', 'Thyroid Checkup'),
(5, 18, '2025-05-09 12:15:00', 'Routine Checkup'),
(1, 19, '2025-05-10 10:30:00', 'High Blood Pressure'),
(2, 20, '2025-05-10 11:45:00', 'Fever Follow-up'),
(3, 21, '2025-05-11 09:00:00', 'Skin Allergy'),
(4, 22, '2025-05-11 10:30:00', 'Eye Examination'),
(5, 23, '2025-05-12 14:00:00', 'Dental Checkup'),
(1, 24, '2025-05-12 15:30:00', 'Routine Checkup'),
(2, 25, '2025-05-13 10:00:00', 'Flu Symptoms');


INSERT INTO prescriptions (doctor_id, patient_id, issued_on, notes) VALUES
(1, 1, '2025-05-01', 'Paracetamol 500mg, twice daily for 5 days'),
(2, 2, '2025-05-01', 'Amoxicillin 250mg, three times daily for 7 days'),
(3, 3, '2025-05-02', 'Ibuprofen 400mg, as needed for pain'),
(1, 4, '2025-05-02', 'Cetirizine 10mg, once daily for 3 days'),
(2, 5, '2025-05-03', 'Metformin 500mg, twice daily for 14 days'),
(3, 6, '2025-05-03', 'Omeprazole 20mg, once daily for 5 days'),
(4, 7, '2025-05-04', 'Aspirin 75mg, once daily for 7 days'),
(5, 8, '2025-05-04', 'Azithromycin 500mg, once daily for 5 days'),
(1, 9, '2025-05-05', 'Losartan 50mg, once daily for 10 days'),
(2, 10, '2025-05-05', 'Salbutamol 2mg, as needed for 3 days'),
(3, 11, '2025-05-06', 'Prednisone 10mg, daily for 14 days'),
(4, 12, '2025-05-06', 'Amoxicillin-Clavulanate 625mg, twice daily for 7 days'),
(5, 13, '2025-05-07', 'Metoprolol 50mg, once daily for 5 days'),
(1, 14, '2025-05-07', 'Cefixime 200mg, once daily for 10 days'),
(2, 15, '2025-05-08', 'Loratadine 10mg, once daily for 7 days'),
(3, 16, '2025-05-08', 'Hydrochlorothiazide 25mg, once daily for 3 days'),
(4, 17, '2025-05-09', 'Simvastatin 20mg, once daily for 14 days'),
(5, 18, '2025-05-09', 'Clindamycin 300mg, twice daily for 5 days'),
(1, 19, '2025-05-10', 'Tramadol 50mg, as needed for 7 days'),
(2, 20, '2025-05-10', 'Levofloxacin 500mg, once daily for 10 days'),
(3, 21, '2025-05-11', 'Furosemide 40mg, once daily for 3 days'),
(4, 22, '2025-05-11', 'Ranitidine 150mg, twice daily for 5 days'),
(5, 23, '2025-05-12', 'Doxycycline 100mg, twice daily for 7 days'),
(1, 24, '2025-05-12', 'Amlodipine 5mg, once daily for 14 days'),
(2, 25, '2025-05-13', 'Clarithromycin 500mg, twice daily for 10 days');


INSERT INTO prescription_item (prescription_id, medication_id, dosage, frequency, duration_days) VALUES
(1, 1, '500mg', 'Twice daily', 5),
(2, 2, '250mg', 'Three times daily', 7),
(3, 3, '400mg', 'As needed', 7),
(4, 4, '10mg', 'Once daily', 3),
(5, 5, '500mg', 'Twice daily', 14),
(6, 6, '20mg', 'Once daily', 5),
(7, 7, '75mg', 'Once daily', 7),
(8, 8, '500mg', 'Once daily', 5),
(9, 9, '50mg', 'Once daily', 10),
(10, 10, '2mg', 'As needed', 3),
(11, 1, '10mg', 'Once daily', 14),
(12, 2, '625mg', 'Twice daily', 7),
(13, 3, '50mg', 'Once daily', 5),
(14, 4, '200mg', 'Once daily', 10),
(15, 5, '10mg', 'Once daily', 7),
(16, 6, '25mg', 'Once daily', 3),
(17, 7, '20mg', 'Once daily', 14),
(18, 8, '300mg', 'Twice daily', 5),
(19, 9, '50mg', 'As needed', 7),
(20, 10, '500mg', 'Once daily', 10),
(21, 1, '40mg', 'Once daily', 3),
(22, 2, '150mg', 'Twice daily', 5),
(23, 3, '100mg', 'Twice daily', 7),
(24, 4, '5mg', 'Once daily', 14),
(25, 5, '500mg', 'Twice daily', 10);

INSERT INTO Medical_Procedures (Procedure_ID, Record_ID, Procedure_Name, Procedure_Date) VALUES
(1, 26, 'Physiotherapy', '2025-01-11'),
(2, 27, 'Vaccination', '2025-01-16'),
(3, 27, 'ECG', '2025-01-23'),
(4, 28, 'Ultrasound', '2025-02-03'),
(5, 29, 'Blood Transfusion', '2025-02-10'),
(6, 26, 'Diet Consultation', '2025-02-15'),
(7, 37, 'MRI Scan', '2025-02-20'),
(8, 30, 'X-Ray', '2025-02-25'),
(9, 33, 'CT Scan', '2025-03-01'),
(10, 24, 'Allergy Test', '2025-03-05'),
(11, 35, 'Eye Checkup', '2025-03-08'),
(12, 26, 'Hearing Test', '2025-03-10'),
(13, 31, 'Blood Sugar Test', '2025-03-12'),
(14, 32, 'Cholesterol Test', '2025-03-14'),
(15, 33, 'Kidney Function Test', '2025-03-16'),
(16, 34, 'Liver Function Test', '2025-03-18'),
(17, 35, 'Stress Test', '2025-03-20'),
(18, 36, 'Vaccination Booster', '2025-03-22'),
(19, 37, 'Bone Density Test', '2025-03-24'),
(20, 38, 'Urine Test', '2025-03-26'),
(21, 39, 'Pulmonary Function Test', '2025-03-28'),
(22, 49, 'Endoscopy', '2025-03-30'),
(23, 40, 'Colonoscopy', '2025-04-01'),
(24, 41, 'Dental Cleaning', '2025-04-03'),
(25, 41, 'Skin Biopsy', '2025-04-05');

INSERT INTO Medical_Procedures (Procedure_ID, Record_ID, Procedure_Name, Procedure_Date) VALUES
(1, 26, 'Physiotherapy', '2025-01-11'),
(2, 27, 'Vaccination', '2025-01-16'),
(3, 27, 'ECG', '2025-01-23'),
(4, 28, 'Ultrasound', '2025-02-03'),
(5, 29, 'Blood Transfusion', '2025-02-10'),
(6, 26, 'Diet Consultation', '2025-02-15'),
(7, 30, 'MRI Scan', '2025-02-20'),
(8, 31, 'X-Ray', '2025-02-25'),
(9, 32, 'CT Scan', '2025-03-01'),
(10, 33, 'Allergy Test', '2025-03-05'),
(11, 34, 'Eye Checkup', '2025-03-08'),
(12, 26, 'Hearing Test', '2025-03-10'),
(13, 35, 'Blood Sugar Test', '2025-03-12'),
(14, 36, 'Cholesterol Test', '2025-03-14'),
(15, 37, 'Kidney Function Test', '2025-03-16'),
(16, 38, 'Liver Function Test', '2025-03-18'),
(17, 39, 'Stress Test', '2025-03-20'),
(18, 40, 'Vaccination Booster', '2025-03-22'),
(19, 41, 'Bone Density Test', '2025-03-24'),
(20, 42, 'Urine Test', '2025-03-26'),
(21, 43, 'Pulmonary Function Test', '2025-03-28'),
(22, 44, 'Endoscopy', '2025-03-30'),
(23, 45, 'Colonoscopy', '2025-04-01'),
(24, 46, 'Dental Cleaning', '2025-04-03'),
(25, 47, 'Skin Biopsy', '2025-04-05');


select * from records;
select * from diagnostic_tests;

SELECT test_id, test_name FROM Diagnostic_Tests;
select * from test_result;




create database jobs;
use jobs;
select* from users;
select* from jobs;

use kilo;
select * from users;
select * from jobs;











