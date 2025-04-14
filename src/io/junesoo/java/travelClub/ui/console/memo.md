```java
public class ClubConsole {

    private ConsoleUtil consoleUtil; // find, register에서 사용할 것이기 때문에 field 정의
    
    // service 내의 인터페이스
    private ClubService clubService;

    public ClubConsole() {
        this.consoleUtil = new ConsoleUtil();
        // 이후 변경될 코드
        this.clubService = new ClubServiceLogic(); // findAll method 사용 가능
    }
}
```
`ClubConsole` 에서 `ClubServiceLogic` 해당 클래스를 직접 참조해서 사용하고 있다.