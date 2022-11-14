package pro.goforit.dto;

import java.util.Date;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/10/24 8:30
 * @desc:
 **/
public class SearchDTO {

    private String username;

    private Date date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "username='" + username + '\'' +
                ", date=" + date +
                '}';
    }
}
