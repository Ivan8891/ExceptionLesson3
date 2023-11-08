package org.example;

public class Controller {

    public static void correctPerson (String[] personData) throws IncorrectGenderException,
                                                                    IncorrectFioException,
                                                                    IncorrectPhoneException,
                                                                    IncorrectDateException{
        if (personData[0] == null || personData[1] == null || personData[2] == null){
            throw new IncorrectFioException("Неудалось распознать ФИО, повторите ввод.");
        }
        if (personData[3] == null){
            throw new IncorrectDateException("Вы ввели не корректную дату рождения, повторите ввод.");
        }
        if (personData[4] == null){
            throw new IncorrectPhoneException("Вы ввели не корректный телефон, повторите ввод.");
        }
        if (personData[5] == null){
            throw new IncorrectGenderException("Вы ввели не корректный пол, повторите ввод.");
        }
    }
    public static boolean fotmatDate(String date){
        String dateOut= "";
        for(int i=0; i < date.length(); i++){
            if(Character.isDigit(date.charAt(i))) dateOut+="n";
            else dateOut+="s";
        }
        if(dateOut.equals("nnsnnsnnnn") ||
                dateOut.equals("nsnnsnnnn") ||
                dateOut.equals("nnsnsnnnn") ||
                dateOut.equals("nsnsnnnn")) return true;
        else return false;
    }

    public static int charType(String text){
        int str = 0;
        int num = 0;
        for(int i=0; i < text.length(); i++){
            if(Character.isDigit(text.charAt(i))) num += 1;
            else if(Character.isLetter(text.charAt(i))) str += 1;
        }
        if(str == text.length()) return 1;
        else if (num == text.length()) return 0;
        else return -1;
    }
    public static String[] splitData(String personData) throws DataException{
        String[] arrayData = personData.split(" ");
        if(arrayData.length == 6) return arrayData;
        else {
            throw new DataException("Ошибка: неверное количество полей. Повторите ввод.");
        }
    }
    public static String[] recognize (String[] personData) {
        String[] recognizeData = new String[6];
        int fioIndex = 0;
        for(String line: personData){
            if(line.length() == 1 &&
                    (line.equalsIgnoreCase("f") ||
                            line.equalsIgnoreCase("m"))) recognizeData[5] = line;
            else if(line.length()>1 &&
                    charType(line)==1 && fioIndex <= 2) {
                    recognizeData[fioIndex] = line;
                    fioIndex++;
            }
            else if(line.length()==10 &&
                    charType(line)==0) recognizeData[4] = line;
            else if((line.length()>=8 && line.length()<=10) &&
                    charType(line) == -1 &&
                    fotmatDate(line)) recognizeData[3] = line;
        }
        return recognizeData;
    }
    public static String recognize (String personData) {
        if(personData.length() == 1 &&
                (personData.equalsIgnoreCase("f") ||
                        personData.equalsIgnoreCase("m"))) return personData;
        else if(personData.length()>1 &&
                charType(personData)==1) {
                return personData;
        }
        else if(personData.length()==10 &&
                charType(personData)==0) return personData;
        else if((personData.length()>=8 && personData.length()<=10) &&
                charType(personData) == -1 &&
                fotmatDate(personData)) return personData;
        else return null;
    }

}
