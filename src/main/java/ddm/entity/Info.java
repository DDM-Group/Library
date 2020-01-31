package ddm.entity;

import ddm.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "info")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String data;

    private Category category;

    @ManyToOne(targetEntity = Photo.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id")
    private Photo photo;

}
