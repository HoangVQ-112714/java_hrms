package demo.hrms.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "content_section_details")
public class ContentSectionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String type;

    private String url;

    @ManyToOne
    @JoinColumn(name = "content_section_id")
    private ContentSection contentSection;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
