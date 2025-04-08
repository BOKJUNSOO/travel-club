package io.junesoo.java.travelClub.ui.menu;
import io.junesoo.java.travelClub.ui.console.ClubConsole;

import java.util.Scanner;

public class ClubMenu {
    private Scanner scanner;
    private ClubConsole console;

    // I/O Stream
    public ClubMenu() {
        this.scanner = new Scanner(System.in);
        this.console = new ClubConsole();
    }

    public void show() {
        int inputNumber = 0;

        while(true) {
            displayMenu();
            inputNumber = selectMenu();

            switch (inputNumber) {
                case 1:
                    console.register();
                    break; // switch 문이 종료된다
                case 2:
                    console.findAll();
                    break;
                case 3:
                    //
                    break;
                case 4:
                    //
                    break;
                case 5:
                    //
                    break;
                case 6:
                    //
                    break;
                case 0:
                    //
                    return;
                default:
                    System.out.println("Choose again");
            }
        }

    }

    // 프로그램 시작시 console에 출력
    private void displayMenu() {
        System.out.println("............");
        System.out.println("Club Menu");
        System.out.println("............");
        System.out.println("1. Register");
        System.out.println("2. Find(All)");
        System.out.println("3. Find(ID)");
        System.out.println("4. Find(Name)");
        System.out.println("5. Modify");
        System.out.println("6. Remove");
        System.out.println("............");
        System.out.println("0. Previous");
        System.out.println("............");
    }

    private int selectMenu() {
        System.out.print("Select : ");
        int menuNumber = scanner.nextInt(); // stdin Buffer -> int 변환
        if (menuNumber >= 0 && menuNumber <= 6){
            scanner.nextLine(); // buffer에 남아있는 입력값의 끝을 지우기 위한 메서드
            return menuNumber;
        } else {
            System.out.println("It`s a invalid number -->" + menuNumber);
            return -1;
        }
    }
}
