package com.ixinrun.lifestyle.module_run.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ixinrun.lifestyle.common.base.BaseLsFrag;
import com.ixinrun.lifestyle.common.router.RouterConfig;
import com.ixinrun.lifestyle.common.widget.LiveDataBus;
import com.ixinrun.lifestyle.module_run.R;
import com.ixinrun.lifestyle.module_run.main.widget.StepView;

@Route(path = RouterConfig.ModuleRun.MainRunFrag)
public class MainRunFrag extends BaseLsFrag {

    private StepView mStepView;

    @Override
    protected View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.main_run_frag_layout, null);
        mStepView = view.findViewById(R.id.step_view);
        return view;
    }

    @Override
    protected void loadData(@Nullable Bundle savedInstanceState) {
        LiveDataBus.get()
                .with("step", Integer.class)
                .observe(this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        mStepView.setStepCount(integer);
                    }
                });
    }

    public static MainRunFrag newInstance() {
        Bundle args = new Bundle();

        MainRunFrag fragment = new MainRunFrag();
        fragment.setArguments(args);
        return fragment;
    }
}