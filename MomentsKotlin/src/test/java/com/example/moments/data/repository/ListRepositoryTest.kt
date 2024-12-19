package com.example.moments.data.repository

import com.example.moments.data.datasource.ListDataSource
import com.example.moments.data.model.ListItem
import com.example.moments.data.model.MomentInfo
import com.example.moments.data.model.UserInfo
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
        coEvery { mockListDataSource.fetchList() } returns Result.success(expectedList)
        // When
        val result = listRepository.getList()
        // Then
        assertEquals(Result.success(expectedList), result)
    }
}
