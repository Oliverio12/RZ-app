package com.android.rz_app.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.android.rz_app.Models.Presupuesto;
import com.android.rz_app.R;
import com.android.rz_app.UI.ViewModels.BudgetVM;
import com.android.rz_app.databinding.ActivityAddBudgetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddBudget extends BottomSheetDialogFragment {
    private ActivityAddBudgetBinding binding;
    private BudgetVM viewModel;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(BudgetVM.class);
        binding = ActivityAddBudgetBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.btnGuardarPresupuesto.setOnClickListener(v -> {
            Presupuesto mObject = new Presupuesto(
                    binding.edtATitulo.getText().toString(),
                    Double.parseDouble(binding.edtAMonto.getText().toString()),
                    true);
            viewModel.addBudget(
                    mObject,
                    documentReference -> {
                        this.dismiss();
                        Toast.makeText(getContext(), "Guardado correctamente el presupuesto", Toast.LENGTH_SHORT).show();
                    },
                    e -> {
                        Toast.makeText(getContext(), "Error no se guardo el presupuesto", Toast.LENGTH_SHORT).show();
                    }
            );
        });
        return view;
    }
}