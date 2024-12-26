package com.example.moments.data.api

import com.example.moments.MomentItems
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ListApiServiceTest {
    @Test
    fun `WHEN api call is successful THEN return list of items`() = runBlocking {
        // Given
        val mockListApiService = mockk<ListApiService>()
        coEvery { mockListApiService.getList() } returns MomentItems
        // When
        val result = mockListApiService.getList()
        // Then
        assertEquals(result, MomentItems)
    }
}