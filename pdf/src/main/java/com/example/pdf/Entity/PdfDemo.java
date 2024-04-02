package com.example.pdf.Entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.Arrays;

@Entity
@Table
@Builder
public class PdfDemo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Lob
            @Column(name="pdf",length = 1000)
    byte[]pdfdoc;

    @Override
    public String toString() {
        return "PdfDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", pdfdoc=" + Arrays.toString(pdfdoc) +
                '}';
    }

    public PdfDemo() {
    }

    public PdfDemo(Long id, String name, String type, byte[] pdfdoc) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pdfdoc = pdfdoc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPdfdoc() {
        return pdfdoc;
    }

    public void setPdfdoc(byte[] pdfdoc) {
        this.pdfdoc = pdfdoc;
    }
}
