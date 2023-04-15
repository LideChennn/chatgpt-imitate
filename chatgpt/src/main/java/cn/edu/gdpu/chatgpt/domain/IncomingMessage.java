package cn.edu.gdpu.chatgpt.domain;

public class IncomingMessage {
    private String content;
    private Integer userId;

    // 构造方法、getter 和 setter 省略
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "IncomingMessage{" +
                "content='" + content + '\'' +
                ", userId=" + userId +
                '}';
    }
}
