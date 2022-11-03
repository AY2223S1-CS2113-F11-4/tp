# User Guide

## Introduction

OneDoc is a desktop application for doctors to manage patients’ profile, visit records, prescriptions records and
medicine information via Command Line Interface.

- [User Guide](#user-guide)
    * [Introduction](#introduction)
    * [Quick Start](#quick-start)
    * [Features](#features)
        + [Main Menu](#main-menu)
            - [Going to main menu: `main`](#going-to-main-menu-main)
            - [Choosing an option: `index`](#choosing-an-option-index)
        + [1. Patient](#1-patient)
            - [Adding a new patient: `add`](#adding-a-new-patient-add)
            - [Viewing all patients: `viewAll`](#viewing-all-patients-viewall)
            - [Retrieving a patient's records: `retrieve`](#retrieving-a-patients-records-retrieve)
            - [Modifying the details of a patient: `edit`](#modifying-the-details-of-a-patient-edit)
        + [2.Visit](#2-visit)
            - [Adding a visit: add](#adding-a-visit-add)
            - [Adding/editing a reason for existing visit: `edit`](#addingediting-a-reason-for-existing-visit-edit)
            - [Deleting a reason for existing visit: `deleteReason`](#deleting-a-reason-for-existing-visit-deletereason)
            - [Viewing all visits: `viewAll`](#viewing-all-visits-viewall)
            - [Viewing a patient's visits: `viewPatient`](#viewing-a-patients-visits-viewpatient)
            - [Viewing a specific visit: `viewVisit`](#viewing-a-specific-visit-viewvisit)
        + [3. Prescription](#3-prescription)
            - [Adding a new prescription: `add`](#adding-a-new-prescription-add)
            - [Modifying a patient’s prescription: `edit`](#modifying-a-patients-prescription-edit)
            - [Viewing list of all existing Prescriptions: `viewAll`](#viewing-list-of-all-existing-prescriptions-viewall)
            - [Viewing all prescriptions of a patient:: `viewPatientPres`](#viewing-all-prescriptions-of-a-patient-viewpatientpres)
            - [Viewing all active prescriptions of a patient:: `viewActPatientPres`](#viewing-all-active-prescriptions-of-a-patient-viewactpatientpres)
            - [Changing prescription status to active: `activate`](#changing-prescription-status-to-active-activate)
            - [Changing prescription status to inactive: `deactivate`](#changing-prescription-status-to-inactive-deactivate)
        + [Exit Program: `bye`](#exit-program-bye)
    * [FAQ](#faq)
    * [Command Summary](#command-summary)

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Download the latest version of `OneDoc` from [here](http://link.to/duke).

## Features

### Main Menu

The main menu will allow the user to choose between three options: (1) Patient, (2) Visit, and (3) Prescription

#### Going to main menu: `main`

Allow the user to view and go to main menu at any point of the program

Format / Example: `main`

Expected Output:

```
Hello welcome to
ıllıllı OneDoc ıllıllı
Please choose one of the following options:
1 - Patients
2 - Visits
3 - Prescription
bye - Quit OneDoc
```

#### Choosing an option: `index`

Chooses an option for the user to continue with. The application will direct the user to 3 different pages accordingly.

Format: `index`

* The `index` can be 1, 2, or 3 to indicate a sub-menu, or bye to exit the program

Example of usage:

* `1`
* `bye`

### 1. Patient

#### Adding a new patient: `add`

Add a new patient to the list of patients.

Format: `add n/[name] g/[M/F] d/[DOB] i/[ID]`

* `DOB` should be in "DD-MM-YYYY" format.
* None of the fields should be empty
* `ID` should be unique, if you attempt to add a patient with an `ID` that is
  already an `ID` of another patient, an error will be thrown.

Example of usage:

`add n/John g/M d/12-12-2001 i/T0707075F`

Expected Output:

```
Ok! I've added a patient! The patient's details are as follows:
	____________________________________________________________
	Patient #1
	Name: John
	Gender: Male
	Date of Birth: 12-12-2001
	ID: T0707075F
	____________________________________________________________
```

#### Viewing all patients: `viewAll`

Lists all patients in the system.

Format: `viewAll`

Expected Output:

```
Here are the list of patients in the system
	____________________________________________________________
    Patient #1
	Name: John Doe
	Gender: Male
	Date of Birth: 09-09-1978
	ID: T2
	____________________________________________________________
    Patient #2
	Name: Jane Doe
	Gender: Female
	Date of Birth: 09-09-1978
	ID: T1
	____________________________________________________________
    Patient #3
	Name: John
	Gender: Male
	Date of Birth: 12-12-2001
	ID: T0707075F
	____________________________________________________________
```

#### Retrieving a patient's records: `retrieve`

Retrieves all information about the patient that matches the input `ID`

Format: `retrieve i/ID`

* `ID` is case-insensitive

Example of usage:

`retrieve i/T0707075f`

Example Output:

```
The patient with the supplied ID was found! Here are the details of the patient: 
	____________________________________________________________
	Patient #3
	Name: John
	Gender: Male
	Date of Birth: 12-12-2001
	ID: T0707075F
	____________________________________________________________
```

#### Modifying the details of a patient: `edit`

Modifies a part of an existing patient's record, given updated information and patient `ID`

* `DOB` must be in DD-MM-YYYY format

Acceptable Formats:

* `edit i/ID n/name`
* `edit i/ID g/[M/F]`
* `edit i/ID d/DOB`

Example of usage:

`edit i/t0707075F d/21-02-1992`

Expected Output:

```
Alright, I've modified the details of the patient! Here are the new details of the patient:
    ____________________________________________________________
    Patient #3
    Name: John
    Gender: Male
    Date of Birth: 21-02-1992
    ID: T0707075F
    ____________________________________________________________
```

### 2. Visit

#### Adding a visit: `add`

Adds a new visit to the list of visits.

Acceptable Formats:

1.`add i/[ID] d/[date] t/[time]`

2.`add i/[ID] d/[date] t/[time] r/[reason]`

* The `ID` should be the ID of a patient that is already present in the patient list
* `date` must be in DD-MM-YYYY format
* `time` must be in HH:MM format
* The `reason` is optional, and can be in any alphabets, numbers and spaces.

Example of usage:

`add i/S123 d/30-02-2020 t/15:00 r/flu`

Expected Output:

```
You have added a visit!
	____________________________________________________________
	ID: S123
	Date: 30-02-2020
	Time: 15:00
	Reason: flu
	____________________________________________________________
```

#### Adding/editing a reason for existing visit: `edit`

Add/edit reason for an existing visit in the list of visits

Format: `edit x/[index] r/[reason]`

* The `index` refers to the overall index of the visit (VisitIndex), in the list of visits
* `reason` can be in any alphabets, numbers and spaces, but cannot be left blank.

Example of usage:

`edit x/3 r/fever`

Expected Output:

```
You have edited reason for the visit. Here's the updated visit!
	____________________________________________________________
	ID: S123
	Date: 30-02-2020
	Time: 15:00
	Reason: fever
	____________________________________________________________
```

#### Deleting a reason for existing visit: `deleteReason`

Add/edit reason for an existing visit in the list of visits

Format: `deleteReason x/[index]`

* The `index` refers to the overall index of the visit (VisitIndex), in the list of visits

Example of usage:

`deleteReason x/3`

Expected Output:

```
You have deleted the reason for the visit. Here's the updated visit!
	____________________________________________________________
	ID: S123
	Date: 30-02-2020
	Time: 15:00
	Reason: NIL
	____________________________________________________________
```

#### Viewing all visits: `viewall`

View all the current visits in the list of visits.

Format: `viewall`

Example of usage:

`viewall`

Expected Output:

```
Here are the list of visits in the system:
	____________________________________________________________
    VisitIndex #1)
	ID: T1
	Date: 08-11-2022
	Time: 08:00
	Reason: checkup
	____________________________________________________________
    VisitIndex #2)
	ID: T2
	Date: 08-15-2022
	Time: 09:00
	Reason: new medication
	____________________________________________________________
    VisitIndex #3)
	ID: S123
	Date: 30-02-2020
	Time: 15:00
	Reason: NIL
	____________________________________________________________

```

#### Viewing a patient's visits: `viewPatient`

View all visits belonging to a specific patient.

Format: `viewPatient i/[ID]`

* The `ID` should be the ID of a patient that is already present in the patient list

Example of usage:

`viewPatient i/S123`

Expected Output:

```
Here are the list of visits for Patient with ID: S123
	____________________________________________________________
    VisitIndex #3)
	ID: S123
	Date: 30-02-2020
	Time: 15:00
	Reason: NIL
	____________________________________________________________
```

#### Viewing a specific visit: `viewVisit`

Viewing a specific visit belonging to some patient.

Format: `viewVisit x/[index]`

* The `index` refers to the overall index of the visit (VisitIndex), in the list of visits

Example of usage:

`viewVisit x/3`

Expected Output:

```
Here is the visit with VisitIndex 3:
	____________________________________________________________
	ID: S123
	Date: 30-02-2020
	Time: 15:00
	Reason: NIL
	____________________________________________________________
```

### 3. Prescription

#### Adding a new prescription: `add`

Add a new prescription to the list of prescriptions.

Format: `add i/patientID n/medicine_name d/medicine_dosage t/time_interval`

* The `patientID` should be the ID of a patient that is already in the patient list
* The `patientID` is case-insensitive
* The `medicine_name` should be either one or two words
* The `medicine_dosage` should be formatted as a number followed by a unit
* The `time_interval` can be in any alphabets, numbers and spaces but not other characters
* The prescription can only be added if it does not exist in the list.

Example of usage:

`add i/T1 n/Problaxan d/10 mg t/take 15 minutes after every meal`

Expected Output:

```
You have added a prescription!
    ____________________________________________________________
    Prescription #3
    ID: T1
    Medicine: Problaxan
    Dosage: 10 mg
    Time Interval: take 15 minutes after every meal
    Status: Active
    ____________________________________________________________
```

#### Modifying a patient’s prescription: `edit`

Modifies one part of a prescription’s record

Format: `edit x/index n/medicine_name` or `edit x/index d/medicine_dosage` or `edit x/index t/time_interval`

* The `index` must be an integer within the range from 1 to the total number of prescriptions in the list
* The `medicine_name` should be either one or two words
* The `medicine_dosage` should be formatted as a number followed by a unit
* The `time_interval` can be in any alphabets, numbers and spaces but not other characters
* The prescription can only be edited if the updated version does not exist in the list.

Example of usage:

`edit x/3 d/20 mg`

Expected output:

```
You have edited the prescription!
    ____________________________________________________________
    Prescription #3
    ID: T1
    Medicine: Problaxan
    Dosage: 20 mg
    Time Interval: take 15 minutes after every meal
    Status: Active
    ____________________________________________________________
```

#### Viewing list of all existing prescriptions: `viewAll`

Display the list of all prescription records for all patients

Format: `viewAll`

Expected output:

* Assume there are currently 2 prescription records in the system.

```
Here are all the prescriptions:
    ____________________________________________________________
    Prescription #1
    ID: T1
    Medicine: cough syrup
    Dosage: 10 mL
    Time Interval: every 3 hours
    Status: Inactive
    ____________________________________________________________
    Prescription #2
    ID: T2
    Medicine: penicillin
    Dosage: 1 tablet
    Time Interval: every 3 days
    Status: Active
    ____________________________________________________________
```

#### Viewing all prescriptions of a patient: `viewPatientPres`

Views all prescription records for a specific patient

Format: `viewPatientPres i/patientID`

* The `patientID` should be the ID of a patient that is already in the patient list
* The `patientID` is case-insensitive

Example of usage:

`viewPatientPres i/T1`

Expected output:

```
Here are all the prescriptions:
    ____________________________________________________________
    Prescription #1
    ID: T1
    Medicine: cough syrup
    Dosage: 10 mL
    Time Interval: every 3 hours
    Status: Inactive
    ____________________________________________________________
```

#### Viewing all active prescriptions of a patient: `viewActPatientPres`

Views all active prescription records for a patient

Format: `viewActPatientPres i/patientID`

* The `patientID` should be the ID of a patient that is already in the patient list
* The `patientID` is case-insensitive

Example of usage:

`viewActPatientPres i/T1`

Expected output:

* If the patient with ID `T1` has no active prescription and `viewActPatientPres i/T1` is executed.

```
There are currently no active prescriptions from this patient.
```

* If the patient with ID `T2` has active prescription and `viewActPatientPres i/T2` is executed, only his active
  prescriptions would be shown.

```
Here are all the active prescriptions:
    ____________________________________________________________
    Prescription #2
    ID: T2
    Medicine: penicillin
    Dosage: 1 tablet
    Time Interval: every 3 days
    Status: Active
    ____________________________________________________________
```

#### Changing prescription status to active: `activate`

Changes a specific prescription record to be active

Format: `activate x/index`

* The `index` must be an integer within the range from 1 to the total number of prescriptions in the list

Example of usage:

`activate x/3`

Expected output:

```
Ok, I've activated the prescription below:
    ____________________________________________________________
    Prescription #3
    ID: T1
    Medicine: Problaxan
    Dosage: 20 mg
    Time Interval: take 15 minutes after every meal
    Status: Active
    ____________________________________________________________
```

#### Changing prescription status to inactive: `deactivate`

Changes a specific prescription record to be inactive

Format: `deactivate x/index`

* The `index` must be an integer within the range from 1 to the total number of prescriptions in the list

Example of usage:

`deactivate x/3`

Expected output:

```
Ok, I've deactivated the prescription below:
    ____________________________________________________________
    Prescription #3
    ID: T1
    Medicine: Problaxan
    Dosage: 20 mg
    Time Interval: take 15 minutes after every meal
    Status: Inactive
    ____________________________________________________________
```

### Exit program: `bye`

Quit the program.

Format: `bye`

Expected output:

```
Goodbye!
```

## FAQ

**Q**: How do I transfer my data to another computer?

**A**: The data is stored in the /data folder of the computer where you ran the program, under the files `patient.txt`,
`prescription.txt`, and `visit.txt`. In order to transfer the data to another computer, move the /data folder to a
new directory on your new computer along with the OneDoc JAR file, and the JAR file in that directory.

## Command Summary

| Action                                          | Format, Examples                                                                                                                                                                                                  |
|-------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Go to the main menu and choose accordingly      | Format: ‘main’, then the user  will to choose between three options:<br/>Patient(1), Visit(2), and Prescription(3)                                                                                                |
| Add patient                                     | Format: add i/ID d/date_of_visit t/time_of_visit [r/reason] (in Patient i.e. input ‘1’ in the main menu) <br/>Example: add i/S7093944G n/John Smith d/30/2/2022 t/16:00:00 r/Having Flu                           |
| View all patients                               | Format: viewAll (in Patient i.e. input ‘1’ in the main menu)                                                                                                                                                      |
| Retrieve information about a patient            | Format: retrieve i/ID  (in Patient i.e. input ‘1’ in the main menu)                                                                                                                                               |  
| Modifying a patient’s record                    | Format: edit i/ID [n/name] [g/M/F] [d/date_of_birth] (in Patient i.e. input ‘1’ in the main menu)                                                                                                                 |
| Add a patient visit                             | Format: add i/ID d/date_of_visit t/time_of_visit [r/reason] (in Visit i.e. input ‘2’ in the main menu)<br/>Example: add i/S7093944G n/John Smith d/30/2/2022 t/16:00:00 r/Having Flu                              |  
| Add/Edit a reason for a patient visit           | Format: reason x/index [r/reason] (in Visit i.e. input ‘2’ in the main menu)<br/>Example: reason x/4 r/Having Flu and Fever                                                                                       |
| Delete a Reason for patient visit               | Format: deleteReason x/index (in Visit i.e. input ‘2’ in the main menu)<br/>Example: reason x/4                                                                                                                   |  
| View a list of all patients visits              | Format: viewAll (in Visit i.e. input ‘2’ in the main menu)                                                                                                                                                        |
| View a list of all visits for one patient       | Format: viewPatient i/ID (in Visit i.e. input ‘2’ in the main menu)                                                                                                                                               |  
| Viewing information for patient’ specific visit | Format: viewVisit x/index (in Visit i.e. input ‘2’ in the main menu)<br/>Example: viewVisit x/5                                                                                                                   |
| Add a new prescription record                   | Format: add i/ID n/medicine_name d/medicine_dosage t/time_interval(in Prescription i.e. input ‘3’ in the main menu)<br/>Example: add i/S7093944G n/Problaxan d/10 mg t/take 15 minutes after every meal, 3x a day |  
| Modifying a patient’s prescription              | Format: edit x/[index] ([n/medicine_name] or [d/medicine_dosage] or [t/time_interval]) (in Prescription i.e. input ‘3’ in the main menu)<br/>Example: edit i/4 d/20 mg                                            |
| View a list of existing prescriptions           | Format: viewAll (in Prescription i.e. input ‘3’ in the main menu)                                                                                                                                                 |  
| View all patient’s prescription                 | Format: viewPatientPres i/ID (in Prescription i.e. input ‘3’ in the main menu)                                                                                                                                    |
| View all patient’s active prescription          | Format: viewActPatientPres i/ID (in Prescription i.e. input ‘3’ in the main menu)                                                                                                                                 |  
| Change prescription status to active            | Format: activate x/[index] (in Prescription i.e. input ‘3’ in the main menu)                                                                                                                                      |
| Change prescription status to inactive          | Format: deactivate x/[index] (in Prescription i.e. input ‘3’ in the main menu)                                                                                                                                    |  
| Exiting the program                             | Format: bye                                                                                                                                                                                                       |

* Add todo `todo n/TODO_NAME d/DEADLINE`
