package com.example.moments.data.datasource

import com.example.moments.data.api.ListApiClient
import com.example.moments.MomentItems
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ListDataSourceTest {
    private lateinit var mockListApiClient: ListApiClient
    private lateinit var listDataSource: ListDataSource

    @Before
    fun setUp() {
        mockListApiClient = mockk()
        listDataSource = ListDataSource(mockListApiClient)
    }

    @Test
    fun `WHEN api call is successful THEN return list of items`() = runBlocking {
        // Given
        coEvery { mockListApiClient.getList() } returns MomentItems
        // When
        val result = listDataSource.fetchList()
        // Then
        assertEquals(result.isSuccess, true)
        assertEquals(result.getOrNull(), MomentItems)
    }

    @Test
    fun `WHEN api call fails THEN return error`() = runBlocking {
        // Given
        val expectedError = Exception("API call failed")
        coEvery { mockListApiClient.getList() } throws expectedError
        // When
        val result = listDataSource.fetchList()
        // Then
        assertEquals(result.isFailure, true)
        assertEquals(result.exceptionOrNull(), expectedError)
    }
}
