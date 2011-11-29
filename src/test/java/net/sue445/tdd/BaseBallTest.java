package net.sue445.tdd;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class BaseBallTest {
	private BaseBall baseBall = new BaseBall();


	// お題その１：打率計算
	@Test
	public void calcBattingAverage() throws Exception {
		int batsCount = 80;
		int hitsCount = 30;
		int plateAppearCount = 100;
		Double actual = baseBall.calcBattingAverage(batsCount, hitsCount, plateAppearCount);

		assertThat(actual, is(closeTo(0.375, 0.0001)));
	}

	@Test
	public void roundHalfUp() throws Exception {
		double actual = baseBall.roundHalfUp(0.5925);
		assertThat(actual, is(0.593));
	}

	// お題その２：打席数が０なら打率を計算しない
	@Test
	public void calcBattingAverage_plateAppearCount0() throws Exception {
		int batsCount = 80;
		int hitsCount = 30;
		int plateAppearCount = 0;
		Double actual = baseBall.calcBattingAverage(batsCount, hitsCount, plateAppearCount);

		assertThat(actual, is(nullValue()));

	}

	// お題その３：打数が０の時は0.000とする
	@Test
	public void calcBattingAverage_batsCount0() throws Exception {
		int batsCount = 0;
		int hitsCount = 30;
		int plateAppearCount = 100;
		Double actual = baseBall.calcBattingAverage(batsCount, hitsCount, plateAppearCount);

		assertThat(actual, is(0.0));
	}

	// お題その４：打率を整形する
	@Test
	public void formatBattingAverage() throws Exception {
		String actual = baseBall.formatBattingAverage(0.333);
		assertThat(actual, is(".333"));
	}

	// １０割の時
	@Test
	public void formatBattingAverage_10() throws Exception {
		String actual = baseBall.formatBattingAverage(1.0);
		assertThat(actual, is("1.00"));
	}

	// 打率を計算しないとき
	@Test
	public void formatBattingAverage_NotCalc() throws Exception {
		String actual = baseBall.formatBattingAverage(null);
		assertThat(actual, is("----"));
	}
}
