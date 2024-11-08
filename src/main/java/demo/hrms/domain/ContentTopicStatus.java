package demo.hrms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name ="content_topic_status")
public class ContentTopicStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "contentTopicStatus")
    private List<ContentTopic> contentTopic;

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

    public List<ContentTopic> getContentTopic() {
        return contentTopic;
    }

    public void setContentTopic(List<ContentTopic> contentTopic) {
        this.contentTopic = contentTopic;
    }
}
