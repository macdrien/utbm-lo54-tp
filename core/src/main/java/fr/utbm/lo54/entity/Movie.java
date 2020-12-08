package fr.utbm.lo54.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MOVIES", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "copies", nullable = false)
    private Integer copies;

    @Column(name = "movie_type", nullable = false)
    private String type;

    @JoinColumn(name = "main_actor_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Actor mainActor;

    @Transient
    private List<Actor> actors;
}
