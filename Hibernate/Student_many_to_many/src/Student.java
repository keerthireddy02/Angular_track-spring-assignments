
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_MTM")
public class Student {
	
	@Id
	@Column(name = "sid")
	private int sid;
	@Column(name = "name")
	private String name;
	
	Student(){
		
	}
	
	Student(int sid, String name){
		this.sid=sid;
		this.name = name;
	}
	
	public void setSId(int sid) {
		this.sid=sid;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSId() {
		return this.sid;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "ID : "+this.getSId()+"\tName : "+this.getName();
	}
	
}