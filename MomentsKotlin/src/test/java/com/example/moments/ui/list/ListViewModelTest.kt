package com.example.moments.ui.list

import com.example.moments.data.repository.ListRepository
import com.example.moments.expectedList
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class ListViewModelTest {
    private lateinit var mockListRepository: ListRepository
    private lateinit var listViewModel: ListViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        mockListRepository = mockk()
        listViewModel = ListViewModel(mockListRepository)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `WHEN loadItems is called THEN should load data`() = runTest {
        // Given
        coEvery { mockListRepository.getList() } returns Result.success(expectedList)
        // When
        listViewModel.loadItems()
        advanceUntilIdle()
        // Then
        assertEquals(listViewModel.list.value, expectedList)
    }

    @Test
    fun `WHEN loadItems call fails THEN should set error`() = runTest {
        // Given
        val expectedError = Exception("API call failed")
        coEvery { mockListRepository.getList() } returns Result.failure(expectedError)
        // When
        listViewModel.loadItems()
        advanceUntilIdle()
        // Then
        assertEquals(listViewModel.error.value, expectedError.message)
    }
}