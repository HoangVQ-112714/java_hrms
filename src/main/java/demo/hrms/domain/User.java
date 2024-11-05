package demo.hrms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @NotNull
    @Email(message = "invalid email", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @NotNull
    private String password;
    private String phone;
    private String avatar;
    private String status;

    @OneToMany(mappedBy = "user")
    private Set<ProjectUser> projectUsers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<ContentSection> contentSections;

    @OneToMany(mappedBy = "user")
    private List<ContentSectionDetail> contentSectionDetails;

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", status='" + status + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @NotNull @Email(message = "invalid email", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email(message = "invalid email", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String email) {
        this.email = email;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public Set<ContentTopic> getContentTopics() {
//        return contentTopics;
//    }

//    public void setContentTopics(Set<ContentTopic> contentTopics) {
//        this.contentTopics = contentTopics;
//    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<ContentSection> getContentSections() {
        return contentSections;
    }

    public void setContentSections(List<ContentSection> contentSections) {
        this.contentSections = contentSections;
    }

    public List<ContentSectionDetail> getContentSectionDetails() {
        return contentSectionDetails;
    }

    public void setContentSectionDetails(List<ContentSectionDetail> contentSectionDetails) {
        this.contentSectionDetails = contentSectionDetails;
    }
}
