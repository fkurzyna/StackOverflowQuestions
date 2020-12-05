package model

class PagedResponseBody<T>(val items: T, val hasMore: Boolean, val quotaMax: Int, val quotaRemaining: Int) {


}