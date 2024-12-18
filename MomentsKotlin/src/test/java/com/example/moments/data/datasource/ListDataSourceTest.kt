package com.example.moments.data.datasource

import com.example.moments.data.api.ListApiService
import com.example.moments.data.model.ListItem
import com.example.moments.data.model.MomentInfo
import com.example.moments.data.model.UserInfo
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
        val expectedList = listOf(
            ListItem(
                userInfo = UserInfo(
                    username = "Alice",
                    avatar = "https://example/avatar/01.png"
                ),
                momentInfo = MomentInfo(
                    text = "Hello, Alice",
                    picture = listOf("https://example/picture/01.png")
                )
            ),
            ListItem(
                userInfo = UserInfo(
                    username = "Bob",
                    avatar = "https://example/avatar/02.png"
                ),
                momentInfo = MomentInfo(
                    text = "Hello, Bob",
                    picture = listOf("https://example/picture/02.png")
                )
            )
        )
        coEvery { mockListApiService.getList() } returns expectedList
        // When
        val result = listDataSource.fetchList()
        // Then
        assertEquals(result.isSuccess, true)
        assertEquals(result.getOrNull(), expectedList)
    }

    @Test
    fun `WHEN api call fails THEN return error`() = runBlocking {
        // Given
        val expectedError = Exception("API call failed")
        coEvery { mockListApiService.getList() } throws expectedError
        // When
        val result = listDataSource.fetchList()
        // Then
        assertEquals(result.isFailure, true)
        assertEquals(result.exceptionOrNull(), expectedError)
    }
}
