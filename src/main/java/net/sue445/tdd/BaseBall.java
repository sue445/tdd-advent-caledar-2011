package net.sue445.tdd;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseBall {
	/**
	 * 小数第４位で四捨五入する
	 * @param num
	 * @return
	 */
	public double roundHalfUp(double num) {
		return new BigDecimal(num).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}

	/**
	 * 打率を計算する（打率は小数第４位で四捨五入する）
	 * @param batsCount			打数
	 * @param hitsCount			安打数
	 * @param plateAppearCount	打席数
	 * @return			打率
	 */
	public Double calcBattingAverage(int batsCount, int hitsCount, int plateAppearCount) {
		if(plateAppearCount == 0){
			return null;
		}
		if(batsCount == 0){
			return 0.0;
		}
		double battingAverage = (double)hitsCount / batsCount;
		return roundHalfUp(battingAverage);
	}

	/**
	 * 打率を整形する
	 * @param battingAverage	打率
	 * @return
	 */
	public String formatBattingAverage(Double battingAverage) {
		if(battingAverage == null){
			return "----";
		}
		if(is10wari(battingAverage)){
			return "1.00";
		}
		return String.format("%.3f", battingAverage).substring(1);
	}

	private boolean is10wari(Double battingAverage) {
		return Double.valueOf(1).equals(battingAverage);
	}



}
