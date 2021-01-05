package com.arifikhsan.jetpackmoviecatalogue.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arifikhsan.jetpackmoviecatalogue.databinding.FavoriteFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private lateinit var favoriteFragmentBinding: FavoriteFragmentBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favoriteFragmentBinding = FavoriteFragmentBinding.inflate(layoutInflater, container, false)
        return favoriteFragmentBinding.root
    }
}