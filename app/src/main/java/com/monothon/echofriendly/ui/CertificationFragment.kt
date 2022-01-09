package com.monothon.echofriendly.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.monothon.echofriendly.*
import com.monothon.echofriendly.databinding.FragmentCertificationBinding
import com.monothon.echofriendly.viewmodel.EchoViewModel
import java.io.File

class CertificationFragment(private val viewModel: EchoViewModel) : Fragment() {
    private lateinit var binding: FragmentCertificationBinding

    private var imageFile: File? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_certification, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureUI()
    }

    private fun configureUI() {
        binding.camera.setOnClickListener { checkPermission() }
    }

    private fun checkPermission() {
        val permission = Manifest.permission.CAMERA
        if (ContextCompat.checkSelfPermission(requireActivity(), permission) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(arrayOf(permission), REQUEST_CAMERA_PERMISSION_CODE)
        } else {
            switchToCamera()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            REQUEST_CAMERA_PERMISSION_CODE -> {
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)
                ) {
                    switchToCamera()
                }
                return
            }
            else -> { /* ignored */ }
        }
    }

    private fun switchToCamera() {
        imageFile = FileUtil.createJpgFileExternal(requireContext())

        // uri 데이터 형태 = content://{authority}/{파일의 디렉토리}/{파일명}
        val uri = FileProvider.getUriForFile(requireContext(), "${requireContext().packageName}.fileprovider", imageFile!!)

        Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            .apply { putExtra(MediaStore.EXTRA_OUTPUT, uri) }
            .also { startActivityForResult(it, REQUEST_IMAGE_CAPTURE) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == AppCompatActivity.RESULT_OK) {
            val imageBitmap = imageFile?.absolutePath?.let { BitmapUtil.getBitmap(it) }

            binding.photo.setImageBitmap(imageBitmap)
        }
    }
}