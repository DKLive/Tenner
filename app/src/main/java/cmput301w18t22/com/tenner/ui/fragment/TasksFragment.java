package cmput301w18t22.com.tenner.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.fragmentnavigator.FragmentNavigator;

import cmput301w18t22.com.tenner.R;
import cmput301w18t22.com.tenner.ui.adapter.TasksFragmentAdapter;
import cmput301w18t22.com.tenner.ui.widget.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class TasksFragment extends Fragment {


    public static final String TAG = TasksFragment.class.getSimpleName();

    private FragmentNavigator mNavigator;

    private TabLayout tabLayout;

    public TasksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavigator = new FragmentNavigator(getChildFragmentManager(), new TasksFragmentAdapter(), R.id.taskChildContainer);
        mNavigator.setDefaultPosition(0);
        mNavigator.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = (TabLayout) view.findViewById(R.id.taskTabLayout);
        tabLayout.setOnTabItemClickListener(new TabLayout.OnTabItemClickListener() {
            @Override
            public void onTabItemClick(int position, View view) {
                setCurrentTab(position);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setCurrentTab(mNavigator.getCurrentPosition());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigator.onSaveInstanceState(outState);
    }

    public void setCurrentTab(int position) {
        mNavigator.showFragment(position);
        tabLayout.select(position);
    }


    public static Fragment newInstance(int position) {
        Fragment fragment = new TasksFragment();
        return fragment;
    }
}
