package com.arifikhsan.jetpackmoviecatalogue.data.response

import com.google.gson.annotations.SerializedName

data class ErrorUnauthorizedResponse(

	@field:SerializedName("status_message")
	val statusMessage: String? = null,

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)
