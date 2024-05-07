package dochub.DocHub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentTitle;
    private String label;
    private String extension;
    private int fileSize;
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
