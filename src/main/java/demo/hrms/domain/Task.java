package demo.hrms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String status;

    @NotNull
    private long created_user_id;

    @NotNull
    private long assigned_user_id;

    @NotNull
    private String priority;

    @NotNull
    private String type;

    @NotNull
    private String parent;

    @NotNull
    private String start_date;

    @NotNull
    private String due_date;

    @NotNull
    private String created_at;

    @NotNull
    private String updated_at;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "content_topic_id")
    private ContentTopic contentTopic;

    @ManyToOne
    @JoinColumn(name = "content_section_id")
    private ContentSection contentSection;

    @OneToOne(mappedBy = "task")
    private ContentSectionDetail contentSectionDetail;

    @OneToMany(mappedBy = "task")
    private List<Comment> comments;

}
