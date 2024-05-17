package kr.or.ddit.collection;

public class TeacherVO extends PersonVO{

	private String operateType;	// 정교사, 기간제
	private String manageType;	// 담임교사, 일반교사
	
	public TeacherVO(String name,
					int age,
					String sex,
					String operateType,
					String manageType
					) {
			this.setName(name);
			this.setAge(age);
			this.setSex(sex);
			this.setOperateType(operateType);
			this.setManageType(manageType);
		
	}
	
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getManageType() {
		return manageType;
	}
	public void setManageType(String manageType) {
		this.manageType = manageType;
	}

	@Override
	public String toString() {
		return super.toString() + "[operateType=" + operateType + ", manageType=" + manageType + "]";
	}
	
	
}
