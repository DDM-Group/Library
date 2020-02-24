package ddm.entity;

import ddm.enums.Category;
import ddm.enums.InfoStatus;
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
    private int infoId;

    private String name;

    private String data;

    private Category category;

    @ManyToOne(targetEntity = Photo.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "photoId")
    private Photo photo;

    private InfoStatus status;

}
