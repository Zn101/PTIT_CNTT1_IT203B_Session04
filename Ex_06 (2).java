import java.time.LocalDate;
import java.util.List;

class User {
    private String email;
    private LocalDate birthDate;
    public User(String email, LocalDate birthDate) {
        this.email = email;
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
class UserProfile {
    private String email;
    private LocalDate birthDate;
    public UserProfile(String email, LocalDate birthDate) {
        this.email = email;
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
}

public class Ex_06 {
    public User updateProfile(User existingUser,
                              UserProfile newProfile,
                              List<User> allUsers) {
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }
        String newEmail = newProfile.getEmail();
        for (User u : allUsers) {
            if (u != existingUser && u.getEmail().equalsIgnoreCase(newEmail)) {
                return null;
            }
        }
        existingUser.setEmail(newEmail);
        existingUser.setBirthDate(newProfile.getBirthDate());
        return existingUser;
    }
}
