package kr.or.ddit.collection;

public class StudentVO extends PersonVO {

	private int hak;	// 학년
	private int ban;	// 반
	private int no;		// 번호
	
	public StudentVO(String name,
					int age, 
					String sex, 
					int hak, 
					int ban, 
					int no
		) {
		this.setName(name);
		this.setAge(age);
		this.sex = sex;
		this.hak = hak;
		this.ban = ban;
		this.no = no;
	}
	public int getHak() {
		return hak;
	}
	public void setHak(int hak) {
		this.hak = hak;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return super.toString() + " [hak=" + hak + ", ban=" + ban + ", no=" + no + "]";
	}
	
	
	
}
