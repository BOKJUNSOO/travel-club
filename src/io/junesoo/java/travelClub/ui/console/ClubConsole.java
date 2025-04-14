package io.junesoo.java.travelClub.ui.console;

import io.junesoo.java.travelClub.entity.TravelClub;
import io.junesoo.java.travelClub.service.ClubService;
import io.junesoo.java.travelClub.service.ServiceLogicLifeCycler;
import io.junesoo.java.travelClub.service.logic.ClubServiceLogic;
import io.junesoo.java.travelClub.utill.ConsoleUtil;

public class ClubConsole {

    private ConsoleUtil consoleUtil; // find, register에서 사용할 것이기 때문에 field 정의
    
    // service 내의 인터페이스
    private ClubService clubService;

    public ClubConsole() {
        this.consoleUtil = new ConsoleUtil();
        // 이후 변경될 코드
        // this.clubService = new ClubServiceLogic(); // findAll method 사용 가능
        // this.clubService = new ServiceLogicLifeCycler().getClubService();
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }
    public void register() {
        //
        while (true) {
            String clubName = consoleUtil.getValueOf("Club Name(0.Club Menu)");

            if(clubName.equals("0")) { // 문자열 비교는 equals 를 이용한다!
                return; // clubMenu로 바뀐다.
            }

            String intro = consoleUtil.getValueOf("Club Intro(0.Club Menu)");
            if (intro.equals("0")){
                return;
            }
            // 새로운 클럽 이름과 인트로를 입력받음
            TravelClub newClub = new TravelClub(clubName,intro);
            clubService.register(newClub);
            System.out.println(newClub.toString());
        }
    }

    public void findAll(){
        //
        TravelClub[] foundClubs = clubService.findAll();
        // 만들어진 클럽이 없다면
        if(foundClubs.length == 0) {
            System.out.println("Empty Club");
            return;
        } else {
            for(TravelClub club : foundClubs){
                System.out.println(club.toString());
            }
        }
    }

    public void findById() {
        TravelClub foundClub = null;
        while(true) {
            String clubId = consoleUtil.getValueOf("Club id to find(0.Club menu)");
            if (clubId.equals("0")) {
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null) {
                System.out.println(foundClub.toString());
            } else {
                System.out.println("Can not find club By Id");
            }

        }
    }

    public void findByName() {
        TravelClub[] foundClubs = null;
        while(true) {
            String clubName = consoleUtil.getValueOf("Club name to find(0.club Menu)");
            if (clubName.equals("0")) {
                break;
            }

            foundClubs = clubService.findByName(clubName); // 인터페이스 상속받은 클래스

            if(foundClubs != null && foundClubs.length !=0) {
                for (TravelClub club: foundClubs) {
                    System.out.println(club);
                }
            } else {
                System.out.println("Can not find club, Name:"+ clubName);
            }
        }
    }

    // modify 와 함께 사용하기 위한 메서드
    private TravelClub findOne() {
        TravelClub foundClub = null;
        while(true) {
            String clubId = consoleUtil.getValueOf("Club id to find(0.Club menu)");
            if (clubId.equals("0")) {
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null) {
                break;
            } else {
                System.out.println("Can not find club By Id");
            }
        }
        return foundClub;
    }
    public void modify() {
        TravelClub target = findOne();
        String newName = consoleUtil.getValueOf("New Club name(0.Club Menu, Enter. No Change.)");
        if (newName.equals("0")) {
            return;
        }
        if (!newName.isEmpty()){
            target.setClubName(newName);
        }
        String newIntro = consoleUtil.getValueOf("New Club Intro(0.Club Menu, Enter. No Change.)");

        if (!newIntro.isEmpty()) {
            target.setIntro(newIntro);
        }

        clubService.modify(target);
        System.out.println("Modify Club:" + target.toString());
    }

    public void remove() {
        TravelClub targetClub = findOne();
        String confirmStr = consoleUtil.getValueOf("Remove the club?(Y:yes, N:No)");
        if(confirmStr.toLowerCase().equals("y")||confirmStr.toLowerCase().equals("yes")) {
            System.out.println("Removing a club --> :" + targetClub.getClubName());
            clubService.remove(targetClub.getId());
        } else {
            System.out.println("Remove cancelled,");
        }
    }
}
