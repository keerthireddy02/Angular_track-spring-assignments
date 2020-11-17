import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INSURANCE_P")
public class Insurance implements Serializable 
{
 @Id
 @GeneratedValue
 @Column(name="POLICYNO")
 private int policyno;
 @Column(name="POLICYNAME")
 private String pname;
 @Column(name="TENURE")
 private int tenure;
 @Column(name="AMOUNT")
 private int amount;
 
 public Insurance() {}
 public Insurance(int policyno,String pname,int tenure,int amount) {
	 this.policyno=policyno;
	 this.pname=pname;
	 this.tenure=tenure;
	 this.amount=amount;
 }
 public int getPolicy() {
  return policyno;
 }
 public void setPolicy(int policyno) {
  this.policyno = policyno;
 }
 public String getPName() {
  return pname;
 }
 public void setPName(String pname) {
  this.pname = pname;
 }
 public int getTenure() {
  return tenure;
 }
 public void setTenure(int tenure) {
  this.tenure = tenure;
 }
 public int getAmount() {
  return amount;
 }
 public void setAmount(int amount) {
  this.amount = amount;
 }
}
