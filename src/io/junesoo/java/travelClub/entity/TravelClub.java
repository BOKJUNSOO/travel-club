package io.junesoo.java.travelClub.entity;
import io.junesoo.java.travelClub.utill.DateUtill;
import java.util.UUID;

public class TravelClub {
    // Field
    private static final int MINIMUM_NAME_LENGTH = 3;
    private static final int MINIMUM_INTRO_LENGTH = 5;
    private String id;
    private String clubName;
    private String intro;
    private String foundationDay;

    // Constructor
    private TravelClub(){
        this.id = UUID.randomUUID().toString();
    }

    public TravelClub(String clubName, String intro){
        // UUID - universalUnique ID
        this(); // private 생성자를 통해 현재 class에서만 UUID 지정
        //this.clubName = clubName;
        setClubName(clubName); // 객체 생성시에도 setter 메서드 사용
        //this.intro = intro;
        setIntro(intro);
        this.foundationDay = DateUtill.today();
    }

    // Method
    // setter
    public void setClubName(String clubName){
        if(clubName.length() < MINIMUM_NAME_LENGTH){
            System.out.println("club name should be longer then 3");
            return;
        }
        this.clubName = clubName;
    }

    public void setIntro(String intro){
        if (intro.length() < MINIMUM_INTRO_LENGTH){
            System.out.println("Intro should be longer then" + MINIMUM_INTRO_LENGTH); // 연산자 오버로딩
            return;
        }
        this.intro = intro;
    }

    //getter
    public String getClubName() {
        return this.clubName;
    }

    public String getIntro(){
        return this.intro;
    }

    public String getId(){
        return this.id;
    }

    public String getFoundationDay(){
        return this.foundationDay;
    }

    // for test
    public static TravelClub getSample() {
        String clubName = "SimpleClub";
        String intro = "Sample Club Intro~";
        TravelClub sampleClub = new TravelClub(clubName, intro);
        return sampleClub;
    }

    // a - notation "object class 로부터 상속받은 toString 메서드를 사용해 새롭게 만들었다는 표현"
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TravelClub club Id :").append(id);
        builder.append(", clubName :").append(clubName);
        builder.append(", Intro :").append(intro);
        builder.append(", FoundationDay :").append(foundationDay);

        return builder.toString();
//        return "TravelClub{" +
//                "id='" + id + '\'' +
//                ", clubName='" + clubName + '\'' +
//                ", intro='" + intro + '\'' +
//                ", foundationDay='" + foundationDay + '\'' +
//                '}';
    }
}
