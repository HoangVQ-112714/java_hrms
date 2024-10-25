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

}
