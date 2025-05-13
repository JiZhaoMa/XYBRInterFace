package com.ruoyi.testRecord.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "test_steps")
public class TestStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "file_id", nullable = false)
    private TestFile file;

    private Integer stepNumber;

    @Column(length = 255)
    private String testItem;

    @Column(length = 255)
    private String displayName;

    @Column(length = 255)
    private String resultSpec;

    @Column(length = 50)
    private String productResult;

    @Column(length = 50)
    private String testTime;

    @ManyToOne
    @JoinColumn(name = "parent_step_id")
    private TestStep parentStep;

    @Column(length = 255)
    private String detailName;

    @Column(length = 255)
    private String detailSpec;

    @Column(length = 255)
    private String detailValue;

    @Column(updatable = false)
    private Date createTime;

    @OneToMany(mappedBy = "parentStep", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestStep> details;

    @PrePersist
    protected void onCreate() {
        createTime = new Date();
    }
}