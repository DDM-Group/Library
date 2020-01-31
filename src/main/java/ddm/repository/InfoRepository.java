package ddm.repository;

import ddm.enums.Category;
import ddm.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, Integer>
{

    List<Info> findAllByCategory (Category category);


}
