package ma.xproce.nventoryservice.dao.entites;


import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String url;
    private String description;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date datePublication;
    @ManyToOne
   private  Creator creator;
}

