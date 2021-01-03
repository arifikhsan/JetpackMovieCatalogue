package com.arifikhsan.jetpackmoviecatalogue.util

import org.json.JSONObject
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class MockResponseFileReaderTest {

    @Test
    fun `read simple file`() {
        val reader = MockResponseFileReader("test.json")
        assertNotNull(reader.content)
    }
}