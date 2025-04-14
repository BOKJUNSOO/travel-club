package io.junesoo.java.travelClub.service.logic;

import io.junesoo.java.travelClub.entity.TravelClub;
import io.junesoo.java.travelClub.service.ClubService;

import java.util.Arrays;

// 실제 클럽 데이터에 접근하는 로직 - 서비스 인터페이스 구현체
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
        return Arrays.copyOfRange(clubs, 0,index);
    }

    @Override
    public TravelClub findById(String clubId) {
        // 생성된 인덱스 까지만 복사
        TravelClub[] createdClub = Arrays.copyOfRange(clubs,0,index);
        TravelClub foundClub = null;
        for (TravelClub club : createdClub) {
            if(club.getId().equals(clubId)) {
                foundClub = club;
                return foundClub;
            }
        }
        return foundClub;
    }

    @Override
    public TravelClub[] findByName(String clubName) {
        TravelClub[] createdClub = Arrays.copyOfRange(clubs,0,index);
        TravelClub[] foundClubs = new TravelClub[createdClub.length];
        int subIndex = 0;
        for (TravelClub club : createdClub) {
            if(club.getClubName().equals(clubName)) {
                foundClubs[subIndex] = club;
                subIndex++;
            }
        } return Arrays.copyOfRange(foundClubs,0,subIndex);
    }

    @Override
    public void modify(TravelClub modifyClub) {
        int foundIndex = 0;
        for(int i = 0; i< clubs.length;i++) {
            if (clubs[i].getId().equals(modifyClub.getId())){
                foundIndex = i;
                break;
            }
        }
        this.clubs[foundIndex] = modifyClub;
    }

    @Override
    public void remove(String clubId) {
        int foundIndex = 0;
        for(int i =0; i<clubs.length;i++) {
            if (clubs[i].getId().equals(clubId)) {
                foundIndex = i;
                break;
            }
        }
        for (int i = foundIndex;i<this.index+1;i++) {
            clubs[i] = clubs[i+1];
        }
        this.index -= 1;
    }
}