package demo.hrms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="content_topics")
public class ContentTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String url_1;

    private String url_2;
    private String url_3;
    private String image;

    @ManyToOne
    @JoinColumn(name = "content_topic_status_id")
    private ContentTopicStatus contentTopicStatus;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "contentTopic")
    private List<ContentSection> contentSections;

    @OneToMany(mappedBy = "contentTopic")
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

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public @NotNull String getUrl_1() {
        return url_1;
    }

    public void setUrl_1(@NotNull String url_1) {
        this.url_1 = url_1;
    }

    public String getUrl_2() {
        return url_2;
    }

    public void setUrl_2(String url_2) {
        this.url_2 = url_2;
    }

    public String getUrl_3() {
        return url_3;
    }

    public void setUrl_3(String url_3) {
        this.url_3 = url_3;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ContentTopicStatus getContentTopicStatus() {
        return contentTopicStatus;
    }

    public void setContentTopicStatus(ContentTopicStatus contentTopicStatus) {
        this.contentTopicStatus = contentTopicStatus;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<ContentSection> getContentSections() {
        return contentSections;
    }

    public void setContentSections(List<ContentSection> contentSections) {
        this.contentSections = contentSections;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
