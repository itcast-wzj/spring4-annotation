package cn.itcast.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private String lable = "service1";

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	@Override
	public String toString() {
		return "UserService [lable=" + lable + "]";
	}

}
