package com.clv.parttimejobs.model.callback;

import com.clv.parttimejobs.entity.consult.DatailJobBean;

public interface JobsListCallback {

	/**
	 * ���б������Ϻ󽫻���õĻص�����
	 * @param musics
	 */
	void onJobsListLoaded(String results);
	
}
