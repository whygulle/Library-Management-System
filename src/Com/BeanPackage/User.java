package Com.BeanPackage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User {

	@Id	
	@Column(name="user_id")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Transient
	private int uid;
	private String username;
	private String useremail;
	private String password;
	
	public String getUemail() {
		return useremail;
	}

	public void setUemail(String useremail) {
		this.useremail = useremail;
	}

	

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", uemail=" + useremail + ", password=" + password
				+  "]";
	}

	
}
