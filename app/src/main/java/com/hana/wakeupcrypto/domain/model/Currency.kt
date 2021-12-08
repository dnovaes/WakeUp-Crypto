package com.hana.wakeupcrypto.domain.model

sealed class Currency(open val name: String, open val value: String)

data class Fiat(override val name: String, override val value: String) : Currency(name, value)
data class Spot(override val name: String, override val value: String) : Currency(name, value)

