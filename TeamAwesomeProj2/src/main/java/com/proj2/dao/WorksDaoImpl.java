package com.proj2.dao;

import com.proj2.model.Works;

public class WorksDaoImpl implements WorksDao{

	private static WorksDaoImpl getWo;
	
	public static WorksDaoImpl getWoDa() {
		if(getWo == null) {
			getWo = new WorksDaoImpl();
		}
		
		return getWo;
	}
	
	@Override
	public void saveWorks(String username, int api_id, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Works getWorks(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateComment(String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWorks(int id) {
		// TODO Auto-generated method stub
		
	}

}
