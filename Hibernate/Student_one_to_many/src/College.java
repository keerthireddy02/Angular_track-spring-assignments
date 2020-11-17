import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="college")
public class College {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int cid;
	
	private String name;
	private String city;
	private String state;
	private String zipcode;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COLLEGE", joinColumns = { @JoinColumn(name = "cid") }, inverseJoinColumns = { @JoinColumn(name = "sid") })
	private Set<Student> students= new HashSet<>();
	
	public College() {}
	public College(String name, String city, String state, String zipcode, Set<Student> students) {
		this.name=name;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
		this.students=students;
	}
	
	public int getCId() {
		return cid;
	}
	public void setCId(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state=state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode=zipcode;
	}
	
	public Set<Student> getStudents(){
		return this.students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students=students;
	}
	

}
