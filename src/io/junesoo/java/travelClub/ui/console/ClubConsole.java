package io.junesoo.java.travelClub.ui.console;

import io.junesoo.java.travelClub.entity.TravelClub;
import io.junesoo.java.travelClub.service.ClubService;
import io.junesoo.java.travelClub.service.logic.ClubServiceLogic;
import io.junesoo.java.travelClub.utill.ConsoleUtil;

public class ClubConsole {

    private ConsoleUtil consoleUtil; // find, register에서 사용할 것이기 때문에 field 정의
    
    // service 내의 인터페이스
    private ClubService clubService;

    public ClubConsole() {
        this.consoleUtil = new ConsoleUtil();
        // 이후 변경될 코드
        this.clubService = new ClubServiceLogic(); // findAll method 사용 가능
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
            // 배열에 저장 - clubService 로직
            clubService.register(newClub);
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

    }
}
