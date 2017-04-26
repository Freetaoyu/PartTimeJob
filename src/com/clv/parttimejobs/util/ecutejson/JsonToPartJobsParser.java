package com.clv.parttimejobs.util.ecutejson;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.clv.parttimejobs.entity.consult.DatailJobBean;
import com.clv.parttimejobs.entity.consult.job.JobDescriptionBean;
import com.clv.parttimejobs.entity.consult.job.ProblemBean;

public class JsonToPartJobsParser {

	// value��[{"claim":"����Ҫ��","companyId":"��˾id","deadline":"������ֹ����",
	// "description":[{"content":"˵������","descriptionId":˵��id,"title":"��ְ˵��"}��������],
	// "jobDescription":"�������","location":"��ְ�ص�","needNumber":"��Ҫ����","numberOfapplicants":"�ѱ�������",
	// "partTimeId":��ְid,"partTimeStatus":��ְ״̬,"photoName":"��ְͼƬ","salary":"н��",
	// "settlementMethod":"���㷽ʽ","title":"��ְ����","type":��ְ����,"workDate":"����ʱ���"]
	public List<DatailJobBean> JSONAnalysisMessageForInformation(String string,
			String partjobid) {
		List<DatailJobBean> partjob = new ArrayList<DatailJobBean>();
		try {
			JSONObject jsonObj = new JSONObject(string);
			JSONArray resultJsonArray = jsonObj.getJSONArray("value");
			System.out.println(resultJsonArray.length());
			JSONObject resultJsonObject = resultJsonArray.getJSONObject(0);
			DatailJobBean p = new DatailJobBean();
			p.setClaim(resultJsonObject.getString("claim"));
			p.setCompanyId(resultJsonObject.getString("companyId"));
			p.setDeadline(resultJsonObject.getString("deadline"));
			p.setJobDescription(resultJsonObject.getString("jobDescription"));
			p.setLocation(resultJsonObject.getString("location"));
			p.setNeedNumber(resultJsonObject.getInt("needNumber"));
			p.setNumberOfapplicants(resultJsonObject
					.getString("numberOfapplicants"));
			p.setPartTimeId(resultJsonObject.getString("partTimeId"));
			p.setPartTimeStatus(resultJsonObject.getString("partTimeStatus"));
			p.setPhotoName(resultJsonObject.getString("photoName"));
			p.setSalary(resultJsonObject.getString("salary"));
			p.setSettlementMethod(resultJsonObject
					.getString("settlementMethod"));
			p.setTitle(resultJsonObject.getString("title"));
			p.setType(resultJsonObject.getString("type"));
			p.setWorkDate(resultJsonObject.getString("workDate"));

			List<JobDescriptionBean> description = new ArrayList<JobDescriptionBean>();
			JSONArray descriptionJsonArray = resultJsonObject
					.getJSONArray("description");
			JobDescriptionBean descriptionbean = new JobDescriptionBean();
			for (int i = 0; i < descriptionJsonArray.length(); i++) {
				JSONObject descriptionJsonObject = descriptionJsonArray
						.getJSONObject(i);
				descriptionbean.setPartTimeId(partjobid);
				descriptionbean.setContent(descriptionJsonObject
						.getString("content"));
				descriptionbean.setDescriptionId(descriptionJsonObject
						.getString("descriptionId"));
				descriptionbean.setTitle(descriptionJsonObject
						.getString("title"));
				description.add(descriptionbean);
				partjob.add(p);
			}
			p.setDescription(description);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partjob;
	}

	/*
	 * �û�����δ��¼ʱ
	 */
	// value:[{"claim":"����Ҫ��","companyId":"��˾id",
	// "deadline":"������ֹ����","description":[{"content":"˵������",
	// "descriptionId":˵��id,"title":"��ְ˵��"}��������],"jobDescription":"�������","location":"��ְ�ص�",
	// "needNumber":"��Ҫ����","numberOfapplicants":"�ѱ�������","partTimeId":��ְid,"partTimeStatus":��ְ״̬,
	// "photoName":"��ְͼƬ","salary":"н��","settlementMethod":"���㷽ʽ","title":"��ְ����",
	// "type":��ְ����,"workDate":"����ʱ���","registrationType":���û��ı���״̬}]
	public List<DatailJobBean> JSONAnalysisMessageForInformationOnLoginIn(
			String string, String partjobid) {
		List<DatailJobBean> partjob = new ArrayList<DatailJobBean>();
		try {
			JSONObject jsonObj = new JSONObject(string);
			JSONArray resultJsonArray = jsonObj.getJSONArray("value");
			System.out.println(resultJsonArray.length());
			JSONObject resultJsonObject = resultJsonArray.getJSONObject(0);
			DatailJobBean p = new DatailJobBean();
			p.setClaim(resultJsonObject.getString("claim"));
			p.setCompanyId(resultJsonObject.getString("companyId"));
			p.setDeadline(resultJsonObject.getString("deadline"));
			p.setJobDescription(resultJsonObject.getString("jobDescription"));
			p.setLocation(resultJsonObject.getString("location"));
			p.setNeedNumber(resultJsonObject.getInt("needNumber"));
			p.setNumberOfapplicants(resultJsonObject
					.getString("numberOfapplicants"));
			p.setPartTimeId(resultJsonObject.getString("partTimeId"));
			p.setPartTimeStatus(resultJsonObject.getString("partTimeStatus"));
			p.setPhotoName(resultJsonObject.getString("photoName"));
			p.setSalary(resultJsonObject.getString("salary"));
			p.setSettlementMethod(resultJsonObject
					.getString("settlementMethod"));
			p.setTitle(resultJsonObject.getString("title"));
			p.setType(resultJsonObject.getString("type"));
			p.setWorkDate(resultJsonObject.getString("workDate"));
			p.setRegistrationType(resultJsonObject
					.getString("registrationType"));

			List<JobDescriptionBean> description = new ArrayList<JobDescriptionBean>();
			JSONArray descriptionJsonArray = resultJsonObject
					.getJSONArray("description");
			JobDescriptionBean descriptionbean = new JobDescriptionBean();
			for (int i = 0; i < descriptionJsonArray.length(); i++) {
				JSONObject descriptionJsonObject = descriptionJsonArray
						.getJSONObject(i);
				descriptionbean.setPartTimeId(partjobid);
				descriptionbean.setContent(descriptionJsonObject
						.getString("content"));
				descriptionbean.setDescriptionId(descriptionJsonObject
						.getString("descriptionId"));
				descriptionbean.setTitle(descriptionJsonObject
						.getString("title"));
				description.add(descriptionbean);
				partjob.add(p);
			}
			p.setDescription(description);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partjob;
	}

	/*
	 * 
	 * ��ְ�������
	 */
	public List<ProblemBean> JSONAnalysisMessageForProblem(String string,
			String partjobid) {
		List<ProblemBean> partjob = new ArrayList<ProblemBean>();
		try {
			JSONObject jsonObj = new JSONObject(string);
			JSONArray resultJsonArray = jsonObj.getJSONArray("value");
			for (int i = 0; i < resultJsonArray.length(); i++) {
				JSONObject resultJsonObject = resultJsonArray.getJSONObject(i);
				ProblemBean p = new ProblemBean();
				p.setPartTimeId(partjobid);
				p.setProblem_topic(resultJsonObject.getString("topic"));
				p.setTopy(resultJsonObject.getString("type"));
				p.setProblemId(resultJsonObject.getString("problemId"));
				String problemstring = resultJsonObject.getString("content");
				p.setProblem_content(problemstring);
				partjob.add(p);
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partjob;

	}
}
