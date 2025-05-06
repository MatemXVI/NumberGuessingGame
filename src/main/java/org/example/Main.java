package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int minScope = 1, maxScope = 101;
        int randomNumber = random.nextInt(minScope, maxScope);
        int userNumber;
        int attempts = 0, wins = 0;
        boolean isDrawn = false;
        System.out.println("LOSOWANIE LICZB");
        System.out.println("Wersja 1.0, Autor: Mateusz Milczarek");
        while(!isDrawn){
            System.out.println("Podaj liczbę do wylosowania z zakresu 1-100.");
            try {
                userNumber = Integer.parseInt(br.readLine());
                if(userNumber >= 1 && userNumber <= 100){
                    attempts++;
                    if(userNumber == randomNumber){
                        wins++;
                        System.out.println("Brawo! To jest ta liczba!");
                        if(attempts == 1)
                            System.out.println("Gratulujemy trafienia za pierwszym razem!");
                        System.out.println("Liczba prób: " + attempts);
                        System.out.println("Czy chcesz zagrać jeszcze raz? Naciśnij T jeśli chcesz to zrobić lub dowolny klawisz jeżeli chcesz wyjść.");
                        String want = br.readLine();
                        if((want.equals("t") || (want.equals("T")))){
                            attempts = 0;
                            randomNumber = random.nextInt(minScope, maxScope);
                        }else{
                            System.out.println("Dziękujemy za zabawę! Liczba zwycięstw: " + wins);
                            isDrawn = true;
                        }
                    }else{
                        System.out.println("Pomyśl o liczbie " + (userNumber < randomNumber ? "większej" : "mniejszej") + "...");
                    }
                }else{
                    System.out.println("Liczba jest niepoprawna!");
                }
            } catch (IOException e) {
                System.out.println("Wystąpił błąd przetwarzania danych");
            } catch (NumberFormatException e) {
                System.out.println("Nie podano liczby!");
            }
        }
    }
}