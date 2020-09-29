package service;

public class CNPYear {


    public static int year(String CNP){
        String yearOfBirth = "";
        String firstNumber = CNP.substring(0,1);
        if(firstNumber.equals("1")  || firstNumber.equals("2")){
            yearOfBirth ="19" + CNP.substring(1,3);
        }else if(firstNumber.equals("3") || firstNumber.equals("4")){
            yearOfBirth = "18" + CNP.substring(1,3);
        }else if(firstNumber.equals("5") || firstNumber.equals("6")) {
            yearOfBirth = "20" + CNP.substring(1, 3);
        }
        int year = Integer.parseInt(yearOfBirth);
        return year;
    }


}
