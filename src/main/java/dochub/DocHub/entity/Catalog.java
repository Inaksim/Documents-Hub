package dochub.DocHub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "catalogs")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String catalogName;

    @ManyToMany
    @JoinTable(
            name = "catalog_members",
            joinColumns = @JoinColumn(name = "catalog_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> members;

    @OneToMany(mappedBy = "catalog")
    private List<Document> documents;

}
