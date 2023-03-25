package Hunter.Web;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Server {
	@Autowired
	Database db;
	
	@Autowired
	UserDb udb;
	
	@GetMapping("/getdata")
	@ResponseBody
	public List<ObjectTable> getdata(){
		return db.findAll();
	}
	@ResponseBody
	@PostMapping("/adddata")
	public String adddata(@RequestBody ObjectTable obj) {
		
		
		db.save(obj);
		return "successfull";
	}
	@ResponseBody
	@GetMapping("/search/{question}")
	public List<ObjectTable> search(@PathVariable("question")String question){
		
		List<ObjectTable> tb = new ArrayList<>();
		tb=db.findByquestionContaining(question);
		if(tb.isEmpty())
			tb.add(new ObjectTable("Not Found :(","try searching another :)"));
		return tb;
		
		
	}
	@ResponseBody
	 @PostMapping("/login")
	 public boolean login(HttpServletRequest req) {
		 String mailId= req.getParameter("mailId");
		 String password = req.getParameter("password");
		 UserTable u= udb.findBymail(mailId);
		 validator v = new validator();
		 if(u!=null) {
			 if(u.pass.equals(password)) {
			 v.setValiduser(true);
			 v.setUsr(u);
				 System.out.println(true);
//			 return v;
				 return true;
			 }
			 else {
				 v.setValiduser(false);
				 v.setUsr(new UserTable("-","-","-"));
//				 return v;
				 return false;
			 }
		 }
		 else {
			 v.setValiduser(false);
			 v.setUsr(new UserTable("-","-","-"));
//			 return v;
			 return false;
		 }
	 }
	 
	 @ResponseBody
	 @PostMapping("/signup")
	 public String signup(@RequestBody UserTable u) {
		 if(udb.findBymail(u.mail)!=null) {
			 return "User Already exists!";
		 }
			 udb.save(u);
		 return "successful";
	 }
	 

	
}

class validator{
	boolean isValiduser;
	UserTable usr;
	public boolean isValiduser() {
		return isValiduser;
	}
	public void setValiduser(boolean isValiduser) {
		this.isValiduser = isValiduser;
	}
	public UserTable getUsr() {
		return usr;
	}
	public void setUsr(UserTable usr) {
		this.usr = usr;
	}
	
}
