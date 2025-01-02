package com.example.moments.ui.list

import com.example.moments.momentItems
import com.example.moments.data.repository.ListRepository
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
import java.io.IOException

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
        coEvery { mockListRepository.getList() } returns momentItems
        // When
        listViewModel.loadItems()
        advanceUntilIdle()
        // Then
        assertEquals(listViewModel.list.value, momentItems)
    }

    @Test
    fun `WHEN loadItems call fails THEN should set error`() = runTest {
        // Given
        val expectedError = IOException("IOE failed")
        coEvery { mockListRepository.getList() } throws expectedError
        // When
        listViewModel.loadItems()
        advanceUntilIdle()
        // Then
        assertEquals(listViewModel.error.value, expectedError.toString())
    }
}