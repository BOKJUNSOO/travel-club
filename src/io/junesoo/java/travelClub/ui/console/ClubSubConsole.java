package io.junesoo.java.travelClub.ui.console;

import io.junesoo.java.travelClub.service.ClubService;
import io.junesoo.java.travelClub.service.ServiceLogicLifeCycler;
import io.junesoo.java.travelClub.service.logic.ClubServiceLogic;

public class ClubSubConsole {
    private ClubService clubService;

    public ClubSubConsole() {
        //this.clubService = new ServiceLogicLifeCycler().getClubService();
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }
}
