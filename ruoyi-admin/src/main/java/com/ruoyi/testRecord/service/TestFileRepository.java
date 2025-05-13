package com.ruoyi.testRecord.service;

import com.ruoyi.testRecord.domain.TestFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestFileRepository extends JpaRepository<TestFile, Long> {
    boolean existsByFileName(String fileName);
}
