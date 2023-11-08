package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Model {

    public void start(){
        boolean cheack;
        String personData;
        String [] personDataArr = new String[0];
        while (true){
            personData = View.inputData("Введите ФИО, год рождения, телефон(10 цифр) и пол(m или f) через пробел. Для отмены введите 'q'.");
            if(personData.equalsIgnoreCase("q")) break;
            try {
               personDataArr = Controller.splitData(personData);
               personDataArr = Controller.recognize(personDataArr);
               Controller.correctPerson(personDataArr);
               cheack = true;
            }
            catch (DataException | IncorrectFioException | IncorrectDateException | IncorrectPhoneException |
                   IncorrectGenderException e){
                System.out.println(e);
                cheack = false;
            }
            if (cheack){
                try (FileWriter writer = new FileWriter(personDataArr[0], true)){
                    writer.write(Arrays.toString(personDataArr)+"\n");
                    System.out.println("Добавлен.");
                }
                catch (IOException e){
                    System.out.println(e);
                }
            }
        }
    }

}
