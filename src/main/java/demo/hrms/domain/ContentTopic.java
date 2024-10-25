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

    @NotNull
    private String status;

    @ManyToMany(mappedBy = "contentTopics")
    private Set<User> users = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "contentTopic")
    private List<ContentSection> contentSections;

    @OneToMany(mappedBy = "contentTopic")
    private List<Task> tasks;

}
