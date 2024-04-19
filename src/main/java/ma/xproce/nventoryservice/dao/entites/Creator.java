package ma.xproce.nventoryservice.dao.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
@Data
 @Entity
@AllArgsConstructor
@NoArgsConstructor
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profile;
    private String username;
    private String mail;
    private String password;
    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER)
    private Collection<Video> videos = new ArrayList<>();

}
