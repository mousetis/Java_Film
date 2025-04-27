package services;

import java.util.ArrayList;

public class Movies {
	dao.Movies dao;

	public Movies(dao.Movies dao) {
		this.dao = new dao.Movies();
	}
	
	//lấy danh sách phim
	public ArrayList<model.Movies> getList() {
		ArrayList<model.Movies> list = dao.getListMovie();
		return list;
	}
	
}
