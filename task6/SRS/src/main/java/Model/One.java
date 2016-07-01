package Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Enum.EnrollmentStatus;

/** 
 * 
 * @author zhang
 * @Date  2016年6月23日 下午12:36:17
 * @doing 
 */

@Entity
public class One {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String password;
	private Date date;
	private EnrollmentStatus status;
	private Many many;
	private List<String> strings;
	private List<Many> manies;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public EnrollmentStatus getStatus() {
		return status;
	}
	public void setStatus(EnrollmentStatus status) {
		this.status = status;
	}
	
	
	
	public Many getMany() {
		return many;
	}
	public void setMany(Many many) {
		this.many = many;
	}
	public List<String> getStrings() {
		return strings;
	}
	public void setStrings(List<String> strings) {
		this.strings = strings;
	}
	public List<Many> getManies() {
		return manies;
	}
	public void setManies(List<Many> manies) {
		this.manies = manies;
	}
	

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", password=" + password + ", date=" + date + ", status="
				+ status + ", many=" + many + ", strings=" + strings + ", manies=" + manies + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manies == null) ? 0 : manies.hashCode());
		result = prime * result + ((many == null) ? 0 : many.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((strings == null) ? 0 : strings.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		One other = (One) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manies == null) {
			if (other.manies != null)
				return false;
		} else if (!manies.equals(other.manies))
			return false;
		if (many == null) {
			if (other.many != null)
				return false;
		} else if (!many.equals(other.many))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		if (strings == null) {
			if (other.strings != null)
				return false;
		} else if (!strings.equals(other.strings))
			return false;
		return true;
	}
	/**
	 * 合并数据，以obj为主 ，当自己有数据且不等于obj中的数据时，合并自己到obj中
	 * @param obj 传入obj
	 * @return 传出obj
	 */
	public Object merge(Object obj) {
		One other = (One) obj;
		if(name!=null&&!(name=="")&&!name.equals("")&&!name.equals(other.name)){
			other.setName(name);
		}
		if (password!=null||!password.equals(other.password)){
			other.setPassword(password);
		}
		return other;
	}
}
