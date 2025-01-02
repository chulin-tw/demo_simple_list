package com.example.moments.data.repository

import com.example.moments.momentItems
import com.example.moments.data.datasource.ListDataSource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ListRepositoryTest {
    private lateinit var mockListDataSource: ListDataSource
    private lateinit var listRepository: ListRepository

    @Before
    fun setUp() {
        mockListDataSource = mockk()
        listRepository = ListRepository(mockListDataSource)
    }

    @Test
    fun `WHEN list repository is called THEN should return data`() = runBlocking {
        // Given
        coEvery { mockListDataSource.fetchList() } returns momentItems
        // When
        val result = listRepository.getList()
        // Then
        assertEquals(momentItems, result)
    }
}
