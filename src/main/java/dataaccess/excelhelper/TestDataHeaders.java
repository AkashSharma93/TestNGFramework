package dataaccess.excelhelper;

/**
 *  In this Interface, the names of the column headers in the excel file are being stored.
 *  This reduces the amount of typos throughout the code while referring to those headers.
 */
public interface TestDataHeaders {
    String testcaseName     =   "TestCaseName";
    String fromCity         =   "FromCity";
    String toCity           =   "ToCity";
    String fromAirport      =   "FromAirport";
    String toAirport        =   "ToAirport";
    String fromDate         =   "FromDate";
    String toDate           =   "ToDate";
    String travellerName    =   "TravellerName";
    String dateOfBirth      =   "DateOfBirth";
    String passportNumber   =   "PassportNumber";
    String visaType         =   "VisaType";
    String contactNumber    =   "ContactNumber";
    String emailID          =   "EmailID";
}
