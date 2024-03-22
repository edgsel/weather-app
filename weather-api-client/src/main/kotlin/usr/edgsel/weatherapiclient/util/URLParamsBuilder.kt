package usr.edgsel.weatherapiclient.util

object URLParamsBuilder {

    fun build(params: Map<String, Any>): String {
        return params.entries.joinToString(
            separator = "&"
        )
    }
}
