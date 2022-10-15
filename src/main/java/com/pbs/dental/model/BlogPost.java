package com.pbs.dental.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogPostId;
    @ManyToOne
    @JoinColumn(name = "dentist_id", nullable = false, referencedColumnName = "dentistId")
    private Dentist dentist;
    private String title;
    private String content;

    public BlogPost(Dentist dentist, String title, String content) {
        this.dentist = dentist;
        this.title = title;
        this.content = content;
    }

    public Long getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(Long blogPostId) {
        this.blogPostId = blogPostId;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "blogPostId=" + blogPostId +
                ", dentist=" + dentist +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
