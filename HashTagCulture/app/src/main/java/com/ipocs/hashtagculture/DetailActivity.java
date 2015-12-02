package com.ipocs.hashtagculture;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.imageView_backdrop)
    ImageView ivBackdrop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        final ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setDisplayHomeAsUpEnabled(true);
        }

        loadBackdrop(); //인텐트로 받은 객체 넘기기
        loadData();  //인텐트로 받은 객체 넘기기

    }

    private void loadBackdrop() {
//        Glide.with(this).load(Cheeses.getRandomCheeseDrawable()).centerCrop().into(ivBackdrop);
        ivBackdrop.setImageResource(R.drawable.cheese_1);
    }

    //Todo: DB에서 Data load
    private void loadData() {
//        tvMainInfoRecruitmentPeriodStart.setText("2015-08-22");
//        tvMainInfoRecruitmentPeriodEnd.setText("2015-08-24");
//        tvMainInfoVoluntaryTime.setText("12시간");
//        tvMainInfoVoluntaryDday.setText("8");
//        tvMainInfoVoluntaryLocation.setText("서울 서초구");
//        tvMainInfoVoluntaryAuth.setText("가능");
//        tvDetailInfoDetails.setText("유기견과 함께 사랑을 나누는 힐링 봉사활동");
//        tvDetailInfoVoluntaryPeriodStart.setText("2015-10-16");
//        tvDetailInfoVoluntaryPeriodEnd.setText("2015-10-18");
//        tvDetailInfoSupportCondition.setText("20대, 알러지 없으신 분");
//        tvDetailInfoSupportGender.setText("남녀무관");
//        tvDetailInfoContact.setText("Yoofdkffdfdsf@seoul.go.kr");
//        tvDetailInfoLocation.setText("서울시 서초구 반포3동 324-1");
//
//        ivPoster.setImageResource(R.drawable.cheese_2);
////        Glide.with(this).load(Cheeses.getRandomCheeseDrawable()).centerCrop().into(ivPoster);
    }



}
