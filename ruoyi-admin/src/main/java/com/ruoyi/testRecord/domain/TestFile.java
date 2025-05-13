package com.ruoyi.testRecord.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "test_files")
public class TestFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String fileName;

    @Column(nullable = false, length = 50)
    private String productCode;

    @Column(nullable = false, length = 50)
    private String testStation;

    @Column(nullable = false, length = 50)
    private String softwareVersion;

    @Column(length = 100)
    private String barcode;

    @Column(length = 20)
    private String testResult;

    private Date startTime;

    @Column(precision = 10, scale = 3)
    private Double testDuration;

    @Column(updatable = false)
    private Date createTime;

    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestStep> steps;

    @PrePersist
    protected void onCreate() {
        createTime = new Date();
    }
}