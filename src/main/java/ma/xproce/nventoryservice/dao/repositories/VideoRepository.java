package ma.xproce.nventoryservice.dao.repositories;

import ma.xproce.nventoryservice.dao.entites.Creator;
import ma.xproce.nventoryservice.dao.entites.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository   extends JpaRepository<Video,Long> {
    Page<Video> findByNameContainsIgnoreCase(String name, Pageable pageable);
}
