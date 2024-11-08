package demo.hrms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "content_sections")
public class ContentSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "content_topic_id")
    private ContentTopic contentTopic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "contentSection")
    private List<ContentSectionDetail> contentSectionDetails;

    @OneToMany(mappedBy = "contentSection")
    private List<Task> tasks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public ContentTopic getContentTopic() {
        return contentTopic;
    }

    public void setContentTopic(ContentTopic contentTopic) {
        this.contentTopic = contentTopic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ContentSectionDetail> getContentSectionDetails() {
        return contentSectionDetails;
    }

    public void setContentSectionDetails(List<ContentSectionDetail> contentSectionDetails) {
        this.contentSectionDetails = contentSectionDetails;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
