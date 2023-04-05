package com.assignment.ui.viewmodel

import com.assignment.data.models.SearchImage
import com.assignment.di.repositories.MainRepository
import com.assignment.di.repositories.Resource
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ImageViewModelTest {
    private lateinit var imageViewModel: ImageViewModel
    @MockK
    private lateinit var searchImage: SearchImage
    @MockK
    private lateinit var mainRepository: MainRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        clearAllMocks()
        imageViewModel = ImageViewModel(mainRepository)
    }

    @Test
    fun `when_image_search_api_called_it_should_emit_success`() {
        coEvery { mainRepository.getSearchImages(any(), any(), any()) } returns searchImage
        every { searchImage.success } returns true
        every { searchImage.status } returns 200

        Assert.assertEquals(Resource.success(200), Resource.success(searchImage.status))
        Assert.assertEquals(Resource.success(true), Resource.success(searchImage.success))
    }

    @Test
    fun `when_image_search_api_called_it_should_emit_failure`() {
        coEvery { mainRepository.getSearchImages(any(), any(), any()) } returns searchImage
        every { searchImage.success } returns false
        every { searchImage.status } returns 400

        Assert.assertEquals(Resource.success(400), Resource.success(searchImage.status))
        Assert.assertEquals(Resource.success(false), Resource.success(searchImage.success))
    }
}