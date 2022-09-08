package com.royalaviation.scrollp3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private TextView tvUname;
    private ImageButton imB1, imB2, imB3, imB4;
    private ActionMode mActionMode;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvUname = getView().findViewById(R.id.tvUname);
        imB1 = getView().findViewById(R.id.ibMv1);
        imB2 = getView().findViewById(R.id.ibMv2);
        imB3 = getView().findViewById(R.id.ibMv3);
        imB4 = getView().findViewById(R.id.ibMv4);

//
        //hiding the action bar
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("name");
        tvUname.setText("Hello, " + name + "!");
        Log.d("lifecycle", "onCreate invoked");
        imB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), PrimeActivity.class);
                startActivity(intent1);
            }
        });

        //Contextual
        imB4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //if action mode is already activated we don't to activate it again
                if (mActionMode != null) {
                    return false;
                }

                mActionMode = getActivity().startActionMode(mActionModeCallback);
                return true;
            }
        });

        imB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), PrimeActivity.class);
                startActivity(intent1);
            }
        });

        imB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), PrimeActivity.class);
                startActivity(intent1);
            }
        });
        imB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), PrimeActivity.class);
                startActivity(intent1);
            }
        });

        //Popupmenu
        tvUname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPop(view);
            }
        });

    }

    public void showPop(View view) {
        PopupMenu popupMenu = new PopupMenu(getActivity().getApplicationContext(), view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item_1:
                Toast.makeText(getActivity().getApplicationContext(), "Item 1 is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_2:
                Toast.makeText(getActivity().getApplicationContext(), "Item 2 is selected", Toast.LENGTH_SHORT).show();
                return true;


            case R.id.item_3:
                Toast.makeText(getActivity().getApplicationContext(), "Item 3 is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_4:
                Toast.makeText(getActivity().getApplicationContext(), "Item 4 is selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.context_menu, menu);
            actionMode.setTitle("Choose your option");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.option_1:
                    Toast.makeText(getActivity().getApplicationContext(), "Option 1 is selected", Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    return true;

                case R.id.option_2:
                    Toast.makeText(getActivity().getApplicationContext(), "Option 2 is selected", Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    return true;

                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            mActionMode = null;
        }
    };
}
