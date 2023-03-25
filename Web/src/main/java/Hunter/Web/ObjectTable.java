package Hunter.Web;






import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="codebase1")
public class ObjectTable {
	@Id
	@GeneratedValue
	int id;
	@Column(name="question",columnDefinition="TEXT")
	String question;
	@Column(name="code",columnDefinition="TEXT")
	String code;
	
	public ObjectTable( String question, String code) {
		super();
		this.question = question;
		this.code = code;
	}
	public ObjectTable() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "ObjectTable [id=" + id + ", question=" + question + ", code=" + code + "]";
	}
	
	
	
}
