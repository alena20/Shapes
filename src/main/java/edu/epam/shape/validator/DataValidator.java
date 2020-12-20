package edu.epam.shape.validator;

public class DataValidator {
    private static final String DELIMITER = " ";
    private static final String NUMBER_REGEX = "^-?\\d*(\\.\\d+)?$";
    private static final int LENGTH = 8;

    public boolean validateInput(String line){
        String [] data = line.split(DELIMITER);
        if (data.length != LENGTH){
            return false;
        }
        int i = 0;
        while (i < data.length) {
            if(!isNumber(data[i])) {
                return false;
            }
            i++;
        }
        return true;
    }
    public boolean isNumber(String number){
        return number.matches(NUMBER_REGEX);
    }
}
