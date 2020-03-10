package ddm.repository;

import ddm.enums.Category;
import ddm.entity.Info;
import ddm.enums.InfoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfoRepository extends JpaRepository<Info, Integer> {

    List<Info> findAllByCategoryAndStatus(Category category, InfoStatus status);

    List<Info> findAllByStatus(InfoStatus status);

    Optional<Info> findByInfoIdAndStatus(int infoId, InfoStatus status);

}
