package Hunter.Web;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="CodeBaseUser")
@Entity
public class UserTable {
		@Id
		@GeneratedValue
		int userId;
		@Column(name="mail")
		String mail;
		@Column(name="pass")
		String pass;
		@Column(name="username")
		String username;
		public UserTable() {
			
		}
		public UserTable(String mailId, String password, String userName) {
			
			this.mail = mailId;
			this.pass = password;
			this.username = userName;
		}
		@Override
		public String toString() {
			return "UserTable [userId=" + userId + ", mail=" + mail + ", pass=" + pass + ", username=" + username + "]";
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
}
