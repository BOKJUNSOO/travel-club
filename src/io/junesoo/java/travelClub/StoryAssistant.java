package io.junesoo.java.travelClub;
import io.junesoo.java.travelClub.entity.TravelClub;
import io.junesoo.java.travelClub.ui.menu.ClubMenu;

public class StoryAssistant {
    private void startStory(){
        ClubMenu clubMenu = new ClubMenu();
        clubMenu.show();
    }
    static public void main(String[] args){
        // System.out.print(TravelClub.getSample().toString()); // for test 인스턴스화 없이 접근가능 메서드
        StoryAssistant assistant = new StoryAssistant();
        assistant.startStory();
    }
}
