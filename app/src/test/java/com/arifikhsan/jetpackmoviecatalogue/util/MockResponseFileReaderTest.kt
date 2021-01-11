package com.arifikhsan.jetpackmoviecatalogue.util

import org.junit.Assert.assertNotNull
import org.junit.Test

class MockResponseFileReaderTest {

    @Test
    fun `read simple file`() {
        val reader = MockResponseFileReader("test.json")
        assertNotNull(reader.content)
    }
}