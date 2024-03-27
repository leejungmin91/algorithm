package priorityqueue;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Long userNo;
    private String userName;

    public User(long userNo, String userName){
        this.userNo = userNo;
        this.userName = userName;
    }
}
