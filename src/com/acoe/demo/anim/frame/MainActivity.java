package com.acoe.demo.anim.frame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.acoe.demo.anim.R;

/**
 * @author Acoe
 * @date 2016-2-18
 * @version V1.0.0
 */
public class MainActivity extends Activity {
	private ImageView imgWrite;
	private TextView txtDaily, txtDailyShow, txtWeekly, txtWeeklyShow, txtMonthly, txtMonthlyShow;
	private boolean isFold = true; // 卫星按钮展开状态
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		initUI(); // 初始化界面
		initAnimation(); // 初始化动画
	}
	
	/**
	 * 初始化界面
	 */
	private void initUI() {
		imgWrite = (ImageView) this.findViewById(R.id.daily_write_imageview);
		txtDaily = (TextView) this.findViewById(R.id.daily_dialy_textview);
		txtDailyShow = (TextView) this.findViewById(R.id.daily_dialy_show_textview);
		txtWeekly = (TextView) this.findViewById(R.id.daily_weekly_textview);
		txtWeeklyShow = (TextView) this.findViewById(R.id.daily_weekly_show_textview);
		txtMonthly = (TextView) this.findViewById(R.id.daily_monthly_textview);
		txtMonthlyShow = (TextView) this.findViewById(R.id.daily_monthly_show_textview);
		// 绑定事件
		this.imgWrite.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isFold) {
					txtDaily.startAnimation(dailyUnfoldAnimation);
					txtWeekly.startAnimation(weeklyUnfoldAnimation);
					txtMonthly.startAnimation(monthlyUnfoldAnimation);
				} else {
					txtDaily.startAnimation(dailyFoldAnimation);
					txtWeekly.startAnimation(weeklyFoldAnimation);
					txtMonthly.startAnimation(monthlyFoldAnimation);
				}
				isFold = !isFold;
				if (isFold) {
					imgWrite.setBackgroundResource(R.drawable.write_daily_fold_icon);
				} else {
					imgWrite.setBackgroundResource(R.drawable.write_daily_unfold_icon);
				}
			}
		});
	}
	
	private Animation dailyUnfoldAnimation, dailyFoldAnimation, weeklyUnfoldAnimation,
		weeklyFoldAnimation, monthlyUnfoldAnimation, monthlyFoldAnimation;
	/**
	 * 初始化动画
	 */
	private void initAnimation() {
		// 展开日报，展开结束时，在停留点显示控件
		dailyUnfoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1.05f);
		dailyUnfoldAnimation.setDuration(500);
		dailyUnfoldAnimation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				txtDailyShow.setVisibility(View.VISIBLE);
			}
		});
		// 收起日报，开始动画时，隐藏起始点控件
		dailyFoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1.05f, Animation.RELATIVE_TO_SELF, 0f);
		dailyFoldAnimation.setDuration(500);
		dailyFoldAnimation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				txtDailyShow.setVisibility(View.GONE);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
			}
		});
		// 展开周报
		weeklyUnfoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1.05f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
		weeklyUnfoldAnimation.setDuration(500);
		weeklyUnfoldAnimation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				txtWeeklyShow.setVisibility(View.VISIBLE);
			}
		});
		// 收起周报
		weeklyFoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, -1.05f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
		weeklyFoldAnimation.setDuration(500);
		weeklyFoldAnimation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				txtWeeklyShow.setVisibility(View.GONE);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
			}
		});
		// 展开月报
		monthlyUnfoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1.05f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
		monthlyUnfoldAnimation.setDuration(500);
		monthlyUnfoldAnimation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				txtMonthlyShow.setVisibility(View.VISIBLE);
			}
		});
		// 收起月报
		monthlyFoldAnimation = new TranslateAnimation( Animation.RELATIVE_TO_SELF, 1.05f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
		monthlyFoldAnimation.setDuration(500);
		monthlyFoldAnimation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				txtMonthlyShow.setVisibility(View.GONE);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
			}
		});
	}
}
