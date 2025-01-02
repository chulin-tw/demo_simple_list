package com.example.moments.data.datasource

import com.example.moments.momentItems
import com.example.moments.data.api.ListApiService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ListDataSourceTest {
    private lateinit var mockListApiService: ListApiService
    private lateinit var listDataSource: ListDataSource

    @Before
    fun setUp() {
        mockListApiService = mockk()
        listDataSource = ListDataSource(mockListApiService)
    }

    @Test
    fun `WHEN api call is successful THEN return list of items`() = runBlocking {
        // Given
        coEvery { mockListApiService.getList() } returns momentItems
        // When
        val result = listDataSource.fetchList()
        // Then
        assertEquals(result, momentItems)
    }
}
