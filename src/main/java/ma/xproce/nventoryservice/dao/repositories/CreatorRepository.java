package ma.xproce.nventoryservice.dao.repositories;

import ma.xproce.nventoryservice.dao.entites.Creator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator,Long> {

    Page<Creator> findByProfileContainsIgnoreCaseOrUsernameContainsIgnoreCase(String profile , String username, Pageable pageable);

}
