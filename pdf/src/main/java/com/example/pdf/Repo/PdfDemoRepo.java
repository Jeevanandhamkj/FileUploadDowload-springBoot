package com.example.pdf.Repo;

import com.example.pdf.Entity.PdfDemo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PdfDemoRepo extends JpaRepository<PdfDemo,Long> {
    Optional<PdfDemo> findByName(String name);
}
