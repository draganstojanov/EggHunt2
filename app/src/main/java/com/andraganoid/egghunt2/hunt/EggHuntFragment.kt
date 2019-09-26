package com.andraganoid.egghunt2.hunt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.andraganoid.egghunt2.R
import com.andraganoid.egghunt2.SharedViewModel
import com.andraganoid.egghunt2.databinding.EggHuntFragmentBinding
import kotlinx.android.synthetic.main.egg_hunt_fragment.*

class EggHuntFragment : Fragment() {

    private lateinit var viewModel: EggHuntViewModel
    private lateinit var binding: EggHuntFragmentBinding
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EggHuntViewModel::class.java)
        viewModel.huntInit()
        sharedViewModel =
            activity?.let { ViewModelProviders.of(it).get(SharedViewModel::class.java) }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.egg_hunt_fragment,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.sharedViewModel = sharedViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        camera.setLifecycleOwner(viewLifecycleOwner)
        sharedViewModel.currentPosition.observe(viewLifecycleOwner, Observer { currentPosition ->
            if (viewModel.isSearchMode.get()) {
                viewModel.eggBox.value?.forEach { egg ->
                    viewModel.eggToRemove =
                        checkEgg(currentPosition, egg)
                    viewModel.eggVisibility.set(viewModel.eggToRemove != null)
                }
            }
        })
    }

}
