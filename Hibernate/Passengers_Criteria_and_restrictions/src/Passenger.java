
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRAIN_RESERVATION")
public class Passenger implements Serializable 
{
 @Id
 @Column(name="P_ID")
 @GeneratedValue
 private int p_id;
 @Column(name="PASSENGERNAME")
 private String passname;
 @Column(name="Train_NO")
 private int train_no;
 @Column(name="AGE")
 private int age;
 
 public Passenger() {}
 public Passenger(int p_id,String passname,int train_no,int age) {
	 this.p_id=p_id;
	 this.train_no=train_no;
	 this.passname=passname;
	 this.age=age;
 }
 public int getPId() {
  return p_id;
 }
 public void setPId(int p_id) {
  this.p_id=p_id;
 }
 public String getPassName() {
  return passname;
 }
 public void setPassName(String passname) {
  this.passname = passname;
 }
 public int getTrainNo() {
  return train_no;
 }
 public void setTrainNo(int train_no) {
  this.train_no=train_no;
 }
 public int getAge() {
  return age;
 }
 public void setAge(int age) {
  this.age = age;
 }
}
