package com.example.pdf.Repo;

import com.example.pdf.Entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepo extends JpaRepository<FileData,Long> {
    Optional<FileData> findByName(String name);
}
