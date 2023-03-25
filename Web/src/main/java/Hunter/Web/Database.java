package Hunter.Web;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Database extends JpaRepository<ObjectTable,Integer>{
		List<ObjectTable> findByquestionContaining(String question);
}
