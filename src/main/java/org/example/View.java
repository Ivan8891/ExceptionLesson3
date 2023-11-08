package org.example;

import java.util.Scanner;

public class View {
    public static String inputData(String message){
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        return data;
    }

    /*public void creatPerson()  {
        Person person = new Person();
        person.setPerson(inputData("Введите ФИО, пол, дату рождения и пол через пробел"));
        try {
            person.correctPerson();
        }
        catch (IncorrectGenderException e){
            System.out.println(e);
            person.setGender(inputData("Введите пол"));
        }
        catch (IncorrectDateException e){
            System.out.println(e);
            person.setDate(inputData("Введите дату"));
        }
        catch (IncorrectPhoneException e){
            System.out.println(e);
            person.setPhone(inputData("Введите телефон"));
        }
        catch (IncorrectFioException e){
            System.out.println(e);
            person.setFio(inputData("Введите ФИО"));
        }
        System.out.println(person);
    }*/

}
