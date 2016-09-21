package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.BuildConfig;
import com.udacity.gradle.builditbigger.JokeQueryAsyncTask;
import com.udacity.gradle.builditbigger.R;

import apps.nanodegree.thelsien.jokeviewer.JokeViewerActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeQueryAsyncTask.OnJokeQueryListener {

    private InterstitialAd mInterstitialAd;
    private String mJokeString;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        setupInterstitialAd();

        Button jokeButton = ((Button) root.findViewById(R.id.btn_joke));
        TextView flavorView = ((TextView) root.findViewById(R.id.tv_flavor));
        flavorView.setText(String.format(getString(R.string.flavor_text), BuildConfig.FLAVOR));

        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JokeQueryAsyncTask asyncTask = new JokeQueryAsyncTask(MainActivityFragment.this);
                asyncTask.execute();
            }
        });

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    private void setupInterstitialAd() {
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.d("MainActivityFragment", "onAdLoaded");
            }

            @Override
            public void onAdClosed() {
                requestNewInterstitialAd();
                startJokeViewerActivity();
            }
        });

        requestNewInterstitialAd();
    }

    private void startJokeViewerActivity() {
        Intent intent = new Intent(getActivity(), JokeViewerActivity.class);
        intent.putExtra(JokeViewerActivity.INTENT_JOKE_STRING_EXTRA, mJokeString);

        startActivity(intent);
    }

    private void requestNewInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("40B5B05168077AB3541339D5C34035BC")
                .build();

        mInterstitialAd.loadAd(adRequest);

    }

    @Override
    public void onJokeQueryFinished(String joke) {
        mJokeString = joke;
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            startJokeViewerActivity();
        }
    }
}
