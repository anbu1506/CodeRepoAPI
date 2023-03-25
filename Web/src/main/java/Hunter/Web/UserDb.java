package Hunter.Web;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDb extends JpaRepository<UserTable,Integer> {
		 UserTable findBymail(String MailId);
}
