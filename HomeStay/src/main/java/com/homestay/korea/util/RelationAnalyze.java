package com.homestay.korea.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.homestay.korea.DTO.ThemePreferDTO;
//사용법
//1.세션으로 넘어온 로그인아이디를 매개변수로 하는 생성자를 통해 객체생성
//2.getMatchIds 메소드사용 (매개변수로 IThemePreferReadService.getThemePreferList를 통해 리스트 받은걸 넣어주면된다)
public class RelationAnalyze {
	
	ThemePreferDTO loginData;	

	public RelationAnalyze() {}
	public RelationAnalyze(ThemePreferDTO loginData) {
		this.loginData = loginData;
	}
	
	public String[] getMatchIds(List<ThemePreferDTO> ThemePreferDTOList){
		String idArr[] = new String[3];
		double pearsonArr[] =new double[3];
		int count = 3;
		
		for(ThemePreferDTO themePrefer : ThemePreferDTOList) {
			if (loginData.getId().equals(themePrefer.getId())) {
				continue;
			}
			
			double pearson = Pearson(themePrefer);
			
			for(int i = 0; i<count; i++) {
				if(idArr[i] == null || pearsonArr[i] < pearson) {
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
		return idArr;
	}
	
	
	private double Pearson(ThemePreferDTO compareData) {
		Map<String, Integer> loginDataMap = new HashMap<String, Integer>();
		Map<String, Integer> compareDataMap = new HashMap<String, Integer>();
		
		loginDataMap.put("Cult_facil", loginData.getCult_facil());
		loginDataMap.put("Dining", loginData.getDining());
		loginDataMap.put("Event", loginData.getEvent());
		loginDataMap.put("Leports", loginData.getLeports());
		loginDataMap.put("Shopping", loginData.getShopping());
		loginDataMap.put("Tour_attr", loginData.getTour_attr());
		
		compareDataMap.put("Cult_facil", compareData.getCult_facil());
		compareDataMap.put("Dining", compareData.getDining());
		compareDataMap.put("Event", compareData.getEvent());
		compareDataMap.put("Leports", compareData.getLeports());
		compareDataMap.put("Shopping", compareData.getShopping());
		compareDataMap.put("Tour_attr", compareData.getTour_attr());
		
		String ThemeArr[] = new String[] {"Cult_facil", "Dining","Event",
											"Leports","Shopping","Tour_attr"};
		int ThemeCount = 6;
		
		double sumX = 0;
		double sumY = 0;
		double sumPowX = 0;
		double sumPowY = 0;
		double sumXY = 0;
		
		
		for(int i=0;i<ThemeCount;i++) {
			sumX += loginDataMap.get(ThemeArr[i]);
			sumY += compareDataMap.get(ThemeArr[i]);
			sumPowX += Math.pow(loginDataMap.get(ThemeArr[i]), 2);
			sumPowY += Math.pow(compareDataMap.get(ThemeArr[i]), 2);
			sumXY += loginDataMap.get(ThemeArr[i]) * compareDataMap.get(ThemeArr[i]);
		}
		
		double numerator = sumXY - ((sumX*sumY)/ThemeCount);
		double denominator = Math.sqrt((sumPowX - Math.pow(sumX, 2)/ThemeCount) * (sumPowY - Math.pow(sumY, 2)/ThemeCount));
		
		return numerator / denominator;
	}
}
