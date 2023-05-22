package com.live.lukastore.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.live.lukastore.Navigation

abstract class BaseFragment<Binding : ViewBinding> : Fragment() {
    private var _binding: Binding? = null
    protected val binding: Binding
        get() = _binding!!
    var navigate: Navigation? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater, container)
        return binding.root
    }


    fun popCurrentFragment() {
        requireActivity().supportFragmentManager.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            navigate = context as? Navigation
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement YourInterface")
        }
    }
}