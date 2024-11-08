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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public @NotNull String getStatus() {
        return status;
    }

    public void setStatus(@NotNull String status) {
        this.status = status;
    }

    @NotNull
    public long getCreated_user_id() {
        return created_user_id;
    }

    public void setCreated_user_id(@NotNull long created_user_id) {
        this.created_user_id = created_user_id;
    }

    @NotNull
    public long getAssigned_user_id() {
        return assigned_user_id;
    }

    public void setAssigned_user_id(@NotNull long assigned_user_id) {
        this.assigned_user_id = assigned_user_id;
    }

    public @NotNull String getPriority() {
        return priority;
    }

    public void setPriority(@NotNull String priority) {
        this.priority = priority;
    }

    public @NotNull String getType() {
        return type;
    }

    public void setType(@NotNull String type) {
        this.type = type;
    }

    public @NotNull String getParent() {
        return parent;
    }

    public void setParent(@NotNull String parent) {
        this.parent = parent;
    }

    public @NotNull String getStart_date() {
        return start_date;
    }

    public void setStart_date(@NotNull String start_date) {
        this.start_date = start_date;
    }

    public @NotNull String getDue_date() {
        return due_date;
    }

    public void setDue_date(@NotNull String due_date) {
        this.due_date = due_date;
    }

    public @NotNull String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(@NotNull String created_at) {
        this.created_at = created_at;
    }

    public @NotNull String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(@NotNull String updated_at) {
        this.updated_at = updated_at;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ContentTopic getContentTopic() {
        return contentTopic;
    }

    public void setContentTopic(ContentTopic contentTopic) {
        this.contentTopic = contentTopic;
    }

    public ContentSection getContentSection() {
        return contentSection;
    }

    public void setContentSection(ContentSection contentSection) {
        this.contentSection = contentSection;
    }

    public ContentSectionDetail getContentSectionDetail() {
        return contentSectionDetail;
    }

    public void setContentSectionDetail(ContentSectionDetail contentSectionDetail) {
        this.contentSectionDetail = contentSectionDetail;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
