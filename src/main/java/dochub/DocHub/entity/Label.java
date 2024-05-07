package dochub.DocHub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "labels")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String labelName;
    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
