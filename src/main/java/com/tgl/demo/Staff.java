package com.tgl.demo;

public class Staff {
	
	private String staffHeight;
	
	private String staffWeight;
	
	private String staffEnglishName;
	
	private String staffChineseNmae;
	
	private String staffExt;
	
	private String staffEmail;
	
	private String staffBMI;
	
	public Staff (String H, String W, String EN, String CN, String Ext, String Email, String BMI) {
		this.staffHeight = H;
		this.staffWeight = W;
		this.staffEnglishName = EN;
		this.staffChineseNmae = CN;
		this.staffExt = Ext;
		this.staffEmail = Email;
		this.staffBMI = BMI;
	}

	public String getStaffHeight() {
		return staffHeight;
	}

	public void setStaffHeight(String staffHeight) {
		this.staffHeight = staffHeight;
	}

	public String getStaffWeight() {
		return staffWeight;
	}

	public void setStaffWeight(String staffWeight) {
		this.staffWeight = staffWeight;
	}

	public String getStaffEnglishName() {
		return staffEnglishName;
	}

	public void setStaffEnglishName(String staffEnglishName) {
		this.staffEnglishName = staffEnglishName;
	}

	public String getStaffChineseNmae() {
		return staffChineseNmae;
	}

	public void setStaffChineseNmae(String staffChineseNmae) {
		this.staffChineseNmae = staffChineseNmae;
	}

	public String getStaffExt() {
		return staffExt;
	}

	public void setStaffExt(String staffExt) {
		this.staffExt = staffExt;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public String getStaffBMI() {
		return staffBMI;
	}

	public void setStaffBMI(String staffBMI) {
		this.staffBMI = staffBMI;
	}
	
	@Override
	public String toString() {
		return staffHeight + " " + staffWeight + " " + staffEnglishName + " " + staffChineseNmae + " " + staffExt + " " + staffEmail + " " + staffBMI;
	}
	
}
