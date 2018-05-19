package cc.web.vo;

import javax.validation.constraints.NotNull;

public class PostVO {

	@NotNull
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content=content;
	}
}