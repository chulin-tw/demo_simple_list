package com.example.moments.data.datasource

import android.content.Context
import com.example.moments.data.api.ListApiService
import com.example.moments.momentItems
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class ListDataSourceTest {
    private lateinit var mockListApiService: ListApiService
    private lateinit var listDataSource: ListDataSource
    private lateinit var mockContext: Context

    @Before
    fun setUp() {
        mockListApiService = mockk()
        mockContext = mockk()
        every { mockContext.applicationContext } returns mockContext
        every { mockContext.getString(any()) } returns "Mocked String"
        every { mockContext.filesDir } returns File("mocked_files_dir")
        listDataSource = ListDataSource(mockListApiService, mockContext)
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
