package link.example.com.ctb;

/**
 * Created by piyush on 17/1/18.
 */

public class usersemester {

    public String semester;


    public usersemester() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public usersemester(String semester) {
        this.semester = semester;

    }
}
