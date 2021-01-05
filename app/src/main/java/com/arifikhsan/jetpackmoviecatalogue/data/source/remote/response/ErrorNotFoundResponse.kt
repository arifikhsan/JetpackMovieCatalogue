package com.arifikhsan.jetpackmoviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ErrorNotFoundResponse(

	@field:SerializedName("status_message")
	val statusMessage: String? = null,

	@field:SerializedName("status_code")
	val statusCode: Int? = null
)
