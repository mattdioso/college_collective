package cc.model;

public class Topic {
	private String topic_id;
	private String topic_name;
	private String school_id;

	public void setTopicID(String id) {
		this.topic_id = id;
	}

	public String getTopicId() {
		return topic_id;
	}

	public void setTopicName(String name) {
		this.topic_name=name;
	}

	public String getTopicName() {
		return topic_name;
	}

	public void setSchoolID(String id) {
		this.school_id = id;
	}

	public String getSchoolID() {
		return school_id;
	}
}