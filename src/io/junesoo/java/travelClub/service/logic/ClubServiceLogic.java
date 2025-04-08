package io.junesoo.java.travelClub.service.logic;

import io.junesoo.java.travelClub.entity.TravelClub;
import io.junesoo.java.travelClub.service.ClubService;

import java.util.Arrays;

// 실제 클럽 데이터를 배열에 저장하는 로직
// 재정의 메서드
public class ClubServiceLogic implements ClubService {

    private TravelClub[] clubs;
    private int index; // 비어있는 인덱스 확인용

    public ClubServiceLogic() {
        this.clubs = new TravelClub[10]; // hard coding
        this.index = 0;
    }

    @Override
    public void register(TravelClub travelClub) {
        clubs[index] = travelClub;
        index++;
    }

    @Override
    public TravelClub[] findAll() {
        // copy 를 이용하여 배열에 존재하는 데이터만 return
        // iterable 하게 만들어서 확인한다.
        return Arrays.copyOfRange(clubs, 0,index);
    }

    @Override
    public TravelClub[] findByName(String clubName) {
        return new TravelClub[0];
    }

    @Override
    public TravelClub findById(String clubId) {
        int length_ = clubs.length;
        TravelClub foundClub = null;
        
        for(int i=0; i<length_ ;i++){
            if (clubs[i].getId().equals(clubId)) {
                foundClub = clubs[i];
                break;
            }
        }
        return foundClub;
    }
// 다른 방법
//    public TravelClub findById(String clubId){
//        // iterable 하게 초기화 
//        TravelClub[] createdClubs = Arrays.copyOfRange(clubs, 0,index);
//        TravelClub foundClub = null;
//        for(TravelClub club : createdClubs){ // 모든 요소 탐색
//            if (club.getId().equals(clubId)){
//                foundClub = club;
//                break;
//            }
//        }
//        return foundClub;
//    }


    @Override
    public void modify(TravelClub modifyClub) {

    }

    @Override
    public void remove(String clubId) {

    }
}
