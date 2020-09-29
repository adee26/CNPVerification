
package service;

import entities.Client;

public class Verification {

    public static boolean isValid(Client client) {
        boolean isValid = false;
        boolean length = Verification.checkLength(client.CNP);
        if(length == false){
            return isValid;
        }
        boolean year = Verification.checkYear(client);
        if(year == false){
            return  isValid;
        }
        boolean date = Verification.checkDate(client.CNP);
        if(date == false){
            return isValid;
        }
        boolean location = Verification.checkLocation(client.CNP);
        if(location == false){
            return isValid;
        }

        isValid = true;
        return isValid;
    }

    public static boolean isMajor(String CNP) {
        boolean isMajor = false;
        int currentYear = 2020;
        String yearOfBirth = "";
        String firstCNPNumber = CNP.substring(0, 1);
        if (firstCNPNumber.equals("1") || firstCNPNumber.equals("2")) {
            yearOfBirth = "19" + CNP.substring(1, 3);
        } else if (firstCNPNumber.equals("5") || firstCNPNumber.equals("6")) {
            yearOfBirth = "20" + CNP.substring(1, 3);
        }
        int age = currentYear - Integer.parseInt(yearOfBirth);
        if (age >= 18) {
            isMajor = true;
        }
        return isMajor;
    }

    public static boolean checkLength(String CNP){
        boolean CNPLength = false;
        if(CNP.length() == 13){
            CNPLength = true;
        }
        return CNPLength;
    }

    public static boolean checkYear(Client client){
        boolean validYear = false;
        int year = CNPYear.year(client.CNP);
        if(year<=2020){
            validYear = true;
        }
        return validYear;
    }

    public static boolean checkDate(String CNP){
        boolean validDate = false;
        String extractMonth = CNP.substring(3,5);
        int month = Integer.parseInt(extractMonth);
        if(month>12){
            return validDate;
        }
        String extractDate = CNP.substring(5,7);
        int day = Integer.parseInt(extractDate);
        if(month == 2 && day >29){
            return validDate;
        }else if(month == 4 || month ==6 || month == 9 || month == 11){
            if(day>30){
                return validDate;
            }
        }else if(day>31){
            return validDate;
        }else{
            validDate = true;
        }


        return validDate;
    }

    public static boolean checkLocation(String CNP){
        boolean validLocation = false;
        String extractLocation = CNP.substring(7,9);
        int location = Integer.parseInt(extractLocation);
        if(location>52){
            return validLocation;
        }else{
            validLocation = true;
        }
        return validLocation;
    }
}







