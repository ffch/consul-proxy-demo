package cn.pomit.consulproxy.domain.advice;

public class FAdviceInfo {
	private int id;
	private String name;
	private String contract;

	private String summary;

	private String content;

	private Integer status;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getContract() {
		return contract;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return summary;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}