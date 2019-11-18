package com.homestay.korea.util;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.homestay.korea.DTO.ThemePreferDTO;
//사용법
//1.세션으로 넘어온 로그인아이디를 매개변수로 하는 생성자를 통해 객체생성
//2.getMatchIds 메소드사용 (매개변수로 IThemePreferReadService.getThemePreferList를 통해 리스트 받은걸 넣어주면된다)
public class RelationAnalyze {
	
	private ThemePreferDTO loginData;	
	private double pearsonArr[] = null;
	
	public RelationAnalyze() {}
	public RelationAnalyze(ThemePreferDTO loginData) {
		this.loginData = loginData;
	}
	
	public List<String> getMatchIds(List<ThemePreferDTO> ThemePreferDTOList){
		int listSize = ThemePreferDTOList.size()-1;
		if (listSize>3) {
			listSize = 3;
		}
		String idArr[] = new String[listSize];
		pearsonArr = new double[listSize];
		int count = listSize;
		
		for(ThemePreferDTO themePrefer : ThemePreferDTOList) {
			if (loginData.getId().equals(themePrefer.getId())) {
				continue;
			}
			
			double pearson = Pearson(themePrefer);
			if(Double.isNaN(pearson)) {
				continue;
			}
			System.out.println("id :" + themePrefer.getId() + " pearson : " + pearson);
			for(int i = 0; i<count; i++) {
				if(idArr[i] == null ||  pearsonArr[i] < pearson) {
					if(i<count-1) {
						pearsonArr[i+1] = pearsonArr[i];
						idArr[i+1] = idArr[i];
					}
					pearsonArr[i] = pearson;
					idArr[i] = themePrefer.getId();
					break;
				}
			}
		}
		List<String> ids = new ArrayList<String>();
		for(String id : idArr) {
			ids.add(id);
		}

		return ids;
	}

	
	
	private double Pearson(ThemePreferDTO compareData) {
		Map<String, Double> loginDataMap = new HashMap<String, Double>();
		Map<String, Double> compareDataMap = new HashMap<String, Double>();
		
		double dThemePrefer[] = new double[] {(double)loginData.getCult_facil(), 
												(double)loginData.getDining(),
												(double)loginData.getEvent(),
												(double)loginData.getLeports(),
												(double)loginData.getShopping(),
												(double)loginData.getTour_attr()};
		
		double dCompareThemePrefer[] = new double[] {(double)compareData.getCult_facil(), 
														(double)compareData.getDining(),
														(double)compareData.getEvent(),
														(double)compareData.getLeports(),
														(double)compareData.getShopping(),
														(double)compareData.getTour_attr()};
		
		double dThemePreferSum = 0.0;
		for(int i = 0; i < dThemePrefer.length; i++) {
			dThemePreferSum += dThemePrefer[i];
		}
		
		for(int i = 0; i < dThemePrefer.length; i++) {
			dThemePrefer[i] = dThemePrefer[i] / dThemePreferSum * 100.0;
			loginDataMap.put("dThemePrefer" + i, dThemePrefer[i]);
		}
		
		double dCompareThemePreferSum = 0.0;
		for(int i = 0; i < dCompareThemePrefer.length; i++) {
			dCompareThemePreferSum += dCompareThemePrefer[i];
		}
		
		for(int i = 0; i < dCompareThemePrefer.length; i++) {
			dCompareThemePrefer[i] = dCompareThemePrefer[i] / dCompareThemePreferSum * 100.0;
			compareDataMap.put("dCompareThemePrefer" + i, dCompareThemePrefer[i]);
		}

		int ThemeCount = dThemePrefer.length;
		
		double sumX = 0;
		double sumY = 0;
		double sumPowX = 0;
		double sumPowY = 0;
		double sumXY = 0;
		
		
		for(int i=0;i<ThemeCount;i++) {
			sumX += loginDataMap.get("dThemePrefer" + i);
			sumY += compareDataMap.get("dCompareThemePrefer" + i);
			sumPowX += Math.pow(loginDataMap.get("dThemePrefer" + i), 2);
			sumPowY += Math.pow(compareDataMap.get("dCompareThemePrefer" + i), 2);
			sumXY += loginDataMap.get("dThemePrefer" + i) * compareDataMap.get("dCompareThemePrefer" + i);
		}
		
		double numerator = sumXY - ((sumX*sumY)/ThemeCount);
		double denominator = Math.sqrt((sumPowX - Math.pow(sumX, 2)/ThemeCount) * (sumPowY - Math.pow(sumY, 2)/ThemeCount));
		
		return numerator / denominator;
	}
}
