package examen1.superheroes;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="miembros") // nombre cotiene todo , por defecto MemberList
public class MemberList {

	private List<Member> members;

	public MemberList() {
	}

	public MemberList(List<Member> members) { //dado una lista de miembos la copia en sus datos
		this.members = members;
	}

	@XmlElement(name = "member")
	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
