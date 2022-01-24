package users.create;

public class CreateUserRequestBody {
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    private String name;
    private String gender;
    private String email;
    private String status;

    public CreateUserRequestBody(String name, String email, String gender, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }

}