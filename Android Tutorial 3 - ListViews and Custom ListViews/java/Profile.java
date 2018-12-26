
package  com.snoott.android3;
public class  Profile{

    private String name = "name", description = "description";
    private int profileImage = 12345;


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return this.name;
    }

    public int getProfileImage() {
        return this.profileImage;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s" , name , description);
    }

    public Profile () {}

    public Profile(String name , String description ) {
        this.name = name;
        this.description = description;
    }

    public Profile(String name , String description , int profileImage) {
        this(name , description);
        this.profileImage = profileImage;

    }
}